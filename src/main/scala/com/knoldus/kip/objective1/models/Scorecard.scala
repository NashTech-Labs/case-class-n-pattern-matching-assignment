package com.knoldus.kip.objective1.models

trait Scorecard {

  val nameOfStudent : String
  val rollNumber: Int
  val subjects: List[Subject]
  val total: Float
  val percentage: Float
  val grade: String

  def getSubjectsWithMaxMarks: List[Subject] = ???
  def getSubjectsWithMinMarks: List[Subject]  = ???
  def getAverageOfMarks: Float = ???

}
