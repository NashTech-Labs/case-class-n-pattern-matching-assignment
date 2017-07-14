package com.knoldus.kip.objective1.services

import com.knoldus.kip.objective1.models._
import org.scalatest.{AsyncFunSuiteLike, AsyncWordSpecLike, MustMatchers}
import org.scalatest.mockito.MockitoSugar

class ScorecardProcessorSpec extends ScorecardProcessor with AsyncWordSpecLike with MockitoSugar with MustMatchers {

  "ScorecardProcessor " should {

    val MAX_MARKS100 = 100

    val subjectMCADM1: Subject = SubjectImpl("Discrete Mathematics", "dm-301", 35, MAX_MARKS100)
    val subjectMCACO1: Subject = SubjectImpl("Computer Organization", "co-302", 79, MAX_MARKS100)
    val subjectMCABN1: Subject = SubjectImpl("Basic Networking", "ba-305", 81, MAX_MARKS100)

    val subjectMCADM2: Subject = SubjectImpl("Discrete Mathematics", "dm-301", 55, MAX_MARKS100)
    val subjectMCACO2: Subject = SubjectImpl("Computer Organization", "co-302", 29, MAX_MARKS100)
    val subjectMCABN2: Subject = SubjectImpl("Basic Networking", "ba-305", 61, MAX_MARKS100)

    val subjectBTechCG1: Subject = SubjectImpl("Computer Graphics", "cg-801", 59, MAX_MARKS100)
    val subjectBTechCA1: Subject = SubjectImpl("Computer Architecture", "ca-804", 91, MAX_MARKS100)
    val subjectBTechAN1: Subject = SubjectImpl("Advanced Networking", "an-305", 38, MAX_MARKS100)

    val subjectBTechCG2: Subject = SubjectImpl("Computer Graphics", "cg-801", 79, MAX_MARKS100)
    val subjectBTechCA2: Subject = SubjectImpl("Computer Architecture", "ca-804", 91, MAX_MARKS100)
    val subjectBTechAN2: Subject = SubjectImpl("Advanced Networking", "an-305", 88, MAX_MARKS100)

    val subjectListMcaWithOneFailure1: List[Subject] = List(subjectMCADM1, subjectMCACO1, subjectMCABN1)
    val subjectListMcaWithOneFailure2: List[Subject] = List(subjectMCADM2, subjectMCACO2, subjectMCABN2)
    val subjectListBtechWithOneFailure1: List[Subject] = List(subjectBTechCG1, subjectBTechCA1, subjectBTechAN1)
    val subjectListBtechWithZeroFailure1: List[Subject] = List(subjectBTechCG2, subjectBTechCA2, subjectBTechAN2)

    val courseAndSubjectsMCA1: Course = CourseImpl("MCA-3", "MCA", subjectListMcaWithOneFailure1, 40)
    val courseAndSubjectsMCA2: Course = CourseImpl("MCA-3", "MCA", subjectListMcaWithOneFailure2, 40)

    val courseAndSubjectsBTech1: Course = CourseImpl("BTech-4", "BTech", subjectListBtechWithOneFailure1, 40)
    val courseAndSubjectsBTech2: Course = CourseImpl("BTech-4", "BTech", subjectListBtechWithZeroFailure1, 40)

    val student1: Student = StudentImpl("Ashish Tomer", 1, 24, 'm', 1032017071102L, courseAndSubjectsMCA1)
    val student2: Student = StudentImpl("Gaurav Mishra", 4, 26, 'm', 1082017071102L, courseAndSubjectsMCA2)
    val student3: Student = StudentImpl("Harshit Daga", 2, 25, 'm', 1032017071103L, courseAndSubjectsBTech1)
    val student4: Student = StudentImpl("Girish Bharti", 8, 27, 'm', 1082017071102L, courseAndSubjectsBTech2)

    val scorecardAshish: Scorecard = ScorecardImpl(student1.name, student1.rollNumber, subjectListMcaWithOneFailure1)
    val scorecardGaurav: Scorecard = ScorecardImpl(student2.name, student2.rollNumber, subjectListMcaWithOneFailure2)
    val scorecardHarshit: Scorecard = ScorecardImpl(student3.name, student3.rollNumber, subjectListBtechWithOneFailure1)
    val scorecardGirish: Scorecard = ScorecardImpl(student4.name, student4.rollNumber, subjectListBtechWithZeroFailure1)

    val scorecardListWithTwoFailures: List[Scorecard] = List(scorecardAshish, scorecardHarshit)
    val scorecardListWithThreeFailures: List[Scorecard] = List(scorecardAshish, scorecardHarshit, scorecardGaurav)
    val scoreCardListWithZeroFailure: List[Scorecard] = List(scorecardGirish)

    "get third failed student as None if fail count is less than 3" in {
      val result: Option[(String, Int)] = getThirdFailedStudent(scorecardListWithTwoFailures)
      assert(result == None)
    }

    "get third failed student as Some(....) if fail count is >= 3" in {
      val result: Option[(String, Int)] = getThirdFailedStudent(scorecardListWithThreeFailures)
      assert(result == Some((student2.name, student2.rollNumber)))
    }

    "get the failed student with highest total" in {
      val result: Option[(String, Int)] = getFailedStudentWithHeighestTotal(scorecardListWithThreeFailures)
      assert(result == Some((student1.name, student1.rollNumber)))
    }

    "get Some passed student with Lowest Marks" in {
      val result = getPassStudentWithLowestMarks(scoreCardListWithZeroFailure)
      assert(result == Some((student4.name, student4.rollNumber)))
    }

    "get None passed student with lowest marks when no student is passed" in {
      val result = getPassStudentWithLowestMarks(scorecardListWithThreeFailures)
      assert(result == None)
    }

    "get subject with zero failure" in {
      val result = getSubjectWithZeroFailure(scorecardListWithThreeFailures)
      assert(result == List("ba-305", "cg-801", "ca-804"))
    }

    "get sutudent with maximum marks" in {
      val result = getTopperStudent(scorecardListWithThreeFailures ::: scoreCardListWithZeroFailure)
      assert(result == Some((student4.name, student4.rollNumber)))
    }

    "get top three students" in {
      val result = getTopThreeStudents(scorecardListWithThreeFailures ::: scoreCardListWithZeroFailure)
      assert(result == List(Some((student1.name, student1.rollNumber)), Some((student4.name, student4.rollNumber)),
        Some((student2.name, student2.rollNumber))))
    }

    "get failed students" in {
      val result = getFailedStudents(scorecardListWithThreeFailures ::: scoreCardListWithZeroFailure)
      assert(result == List((student1.name, student1.rollNumber), (student2.name, student2.rollNumber),
        (student3.name, student3.rollNumber)))
    }

    "get pass student count" in {
      val result = getPassStudentsCount(scorecardListWithThreeFailures ::: scoreCardListWithZeroFailure)
      assert(result == 1)
    }

    "get failed student count" in {
      val result = getFailedStudentsCount(scorecardListWithThreeFailures ::: scoreCardListWithZeroFailure)
      assert(result == 3)
    }

    "get student with grade B+" in {
      val result: List[(String, Int)] = getStudentsWithGrade("B+", scorecardListWithThreeFailures ::: scoreCardListWithZeroFailure)
      assert(result == List((student4.name, student4.rollNumber)))
    }

    "get student with grade B+" in {
      val result = getStudentCountWithGrade("B+", scorecardListWithThreeFailures ::: scoreCardListWithZeroFailure)
      assert(result == 1)
    }

    "get students with percentage more than" in {
      val result: List[(String, Int)] = getStudentsWithPercentageMoreThan(80, scorecardListWithThreeFailures ::: scoreCardListWithZeroFailure)
      assert(result == List((student4.name, student4.rollNumber)))
    }

    "get students with percentage less than" in {
      val result: List[(String, Int)] = getStudentsWithPercentageLessThan(80, scorecardListWithThreeFailures ::: scoreCardListWithZeroFailure)
      assert(result == List((student4.name, student4.rollNumber), (student4.name, student4.rollNumber), (student4.name, student4.rollNumber)))
    }

    "get students count with percentage more than" in {
      val result = getStudentCountWithPercentageMoreThan(80, scorecardListWithThreeFailures ::: scoreCardListWithZeroFailure)
      assert(result == 1)
    }

    "get students count with percentage less than" in {
      val result = getStudentCountWithPercentageLessThan(80, scorecardListWithThreeFailures ::: scoreCardListWithZeroFailure)
      assert(result == 3)
    }

    "get student with highest marks in the subject" in {
      val result = getStudentsWithHighestMarksInCourse("Computer Organization", scorecardListWithThreeFailures ::: scoreCardListWithZeroFailure)
      assert(result == List((student1.name, student1.rollNumber)))
    }

    "get student with lowest marks in the subject" in {
      val result = getStudentsWithLowestMarksInCourse("Computer Organization", scorecardListWithThreeFailures ::: scoreCardListWithZeroFailure)
      assert(result == List((student2.name, student2.rollNumber)))
    }

  }
}
