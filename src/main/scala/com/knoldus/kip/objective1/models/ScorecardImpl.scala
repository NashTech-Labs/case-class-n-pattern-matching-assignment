package com.knoldus.kip.objective1.models

case class ScorecardImpl(nameOfStudent: String, rollNumber: Int, subjects: List[Subject],
                         total: Float = 0, percentage: Float = 0, grade: String = "") extends Scorecard {
  override def getSubjectsWithMaxMarks: List[Subject]= ???
  override def getSubjectsWithMinMarks: List[Subject] = ???
  override def getAverageOfMarks: Float = ???

  def apply(nameOfStudent: String, rollNumber: Int, subjects: List[Subject]): ScorecardImpl = ???
}
