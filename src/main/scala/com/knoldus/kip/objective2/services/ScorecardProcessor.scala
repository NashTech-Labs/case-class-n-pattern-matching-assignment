package com.knoldus.kip.objective2.services

import com.knoldus.kip.objective2.models.{Course, Student, Subject}

trait ScorecardProcessor {

  def getThirdFailedStudent: Option[Student] = ???
  def getFailedStudentWithHeighestMarks: Option[Student] = ???
  def getPassStudentWithLowestMarks: Option[Student] = ???
  def getSubjectWithZeroFailure: Option[Subject] = ???
  def getSubjectWithFullSuccessRate: Option[Subject] = ???
  def getOptionalSubjectWithZeroFailure: Option[Subject] = ???
  def getOptionalSubjectWithFullSuccessRate: Option[Subject] = ???
  def getTopperStudent: Student = ???
  def getBestThreeStudents: List[Student] = ???
  def getFailedStudents: List[Student] = ???
  def getPassStudentsCount: List[Student] = ???
  def getFailedStudentsCount: List[Student] = ???
  def getStudentsWithGrade(grade: String): List[Student] = ???
  def getStudentCountWithGrade(grade: String): Int = ???
  def getStudentsWithPercentageMoreThan(percentage: Float): List[Student] = ???
  def getStudentsWithPercentageLessThan(percentage: Float): List[Student] = ???
  def getStudentCountWithPercentageMoreThan(percentage: Float): Int = ???
  def getStudentCountWithPercentageLessThan(percentage: Float): Int = ???
  def getStudentsWithHighestMarksInCourse(courseName: String): List[Student] = ???
  def getStudentsWithLowestMarksInCourse(courseName: String): List[Student] = ???
  def getSubjectsWithHighestFailure: List[Subject] = ??? //Can be plural if two subject have same highest failure
  def getSubjectsWithLowestFailure: List[Subject] = ??? //Can be plural if two subject have same lowest failure
  def getCourseWithNoFailure: Course = ???

}
