package com.knoldus.kip.objective1.services

import com.knoldus.kip.objective1.models.{Course, Scorecard, Student, Subject}

trait ScorecardProcessor {

  def getThirdFailedStudent(scorecardList: List[Scorecard]): Option[(String, Int)] = ???
  def getFailedStudentWithHeighestTotal(scorecardList: List[Scorecard]): Option[(String, Int)] = ???
  def getPassStudentWithLowestMarks(scorecardList: List[Scorecard]): Option[(String, Int)] = ???
  def getSubjectWithZeroFailure(scorecardList: List[Scorecard]): List[String] = ???
  def getTopperStudent(scorecardList: List[Scorecard]): Option[(String, Int)] = getTopper(scorecardList)
  def getTopThreeStudents(scorecardList: List[Scorecard]): List[Option[(String, Int)]] = ???
  def getFailedStudents(scorecardList: List[Scorecard]): List[(String, Int)] = ???
  def getPassStudentsCount(scorecardList: List[Scorecard]): Int = ???
  def getFailedStudentsCount(scorecardList: List[Scorecard]): Int = ???
  def getStudentsWithGrade(grade: String, scorecardList: List[Scorecard]): List[(String, Int)] = ???
  def getStudentCountWithGrade(grade: String, scorecardList: List[Scorecard]): Int = ???
  def getStudentsWithPercentageMoreThan(percentage: Float, scorecardList: List[Scorecard]): List[(String, Int)] = ???
  def getStudentsWithPercentageLessThan(percentage: Float, scorecardList: List[Scorecard]): List[(String, Int)] = ???
  def getStudentCountWithPercentageMoreThan(percentage: Float, scorecardList: List[Scorecard]): Int = ???
  def getStudentCountWithPercentageLessThan(percentage: Float, scorecardList: List[Scorecard]): Int = ???
  def getStudentsWithHighestMarksInCourse(courseName: String, scorecardList: List[Scorecard]): List[(String, Int)] = ???
  def getStudentsWithLowestMarksInCourse(courseName: String, scorecardList: List[Scorecard]): List[(String, Int)] = ???

  private def getTopper(scorecardList: List[Scorecard]): Option[(String, Int)] = scorecardList match{
    case Nil => None
    case onlyOneScorecard :: Nil => Some(onlyOneScorecard.nameOfStudent, onlyOneScorecard.rollNumber)
    case firstScorecard :: secondScorecard :: restScorecards =>
      val scoreCardWithMaxTotal = if(firstScorecard.getAverageOfMarks > secondScorecard.getAverageOfMarks) {
        firstScorecard
      } else {
        secondScorecard
      }
      getTopper(scoreCardWithMaxTotal :: restScorecards)
  }
}
