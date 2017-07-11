package com.knoldus.kip.objective1.services

import com.knoldus.kip.objective1.models.{Course, Scorecard, Student, Subject}

trait ScorecardProcessor {

  def getThirdFailedStudent(scorecardList: List[Scorecard]): Option[Student] = ???
  def getFailedStudentWithHeighestTotal(scorecardList: List[Scorecard]): Option[Student] = ???
  def getPassStudentWithLowestMarks(scorecardList: List[Scorecard]): Option[Student] = ???
  def getSubjectWithZeroFailure(scorecardList: List[Scorecard]): List[String] = ???
  def getTopperStudent(scorecardList: List[Scorecard]): Option[Student] = ???
  def getTopThreeStudents(scorecardList: List[Scorecard]): List[Student] = ???
  def getFailedStudents(scorecardList: List[Scorecard]): List[Student] = ???
  def getPassStudentsCount(scorecardList: List[Scorecard]): Int = ???
  def getFailedStudentsCount(scorecardList: List[Scorecard]): List[Student] = ???
  def getStudentsWithGrade(grade: String, scorecardList: List[Scorecard]): List[Student] = ???
  def getStudentCountWithGrade(grade: String, scorecardList: List[Scorecard]): Int = ???
  def getStudentsWithPercentageMoreThan(percentage: Float, scorecardList: List[Scorecard]): List[Student] = ???
  def getStudentsWithPercentageLessThan(percentage: Float, scorecardList: List[Scorecard]): List[Student] = ???
  def getStudentCountWithPercentageMoreThan(percentage: Float, scorecardList: List[Scorecard]): Int = ???
  def getStudentCountWithPercentageLessThan(percentage: Float, scorecardList: List[Scorecard]): Int = ???
  def getStudentsWithHighestMarksInCourse(courseName: String, scorecardList: List[Scorecard]): List[Student] = ???
  def getStudentsWithLowestMarksInCourse(courseName: String, scorecardList: List[Scorecard]): List[Student] = ???

}
