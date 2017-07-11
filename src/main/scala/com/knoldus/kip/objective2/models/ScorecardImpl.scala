package com.knoldus.kip.objective2.models

case class ScorecardImpl(nameOfStudent: String, rollNumber: Int, subjects: List[Subject], course: Course,
                         total: Float, percentage: Float, grade: String) extends Scorecard {

  override def getSubjectsWithMaxMarks: List[Subject]= ???
  override def getSubjectsWithMinMarks: List[Subject] = ???
  override def getAverageOfMarks: Float = ???

  /**
    * @param nameOfStudent
    * @param rollNumber
    * @param subjects
    * @param course Make sure all the subjects passed (either mandatory or optional) are in part of
    *               passed course, if not throw required exception
    * @return Scorecard object created with `new ScorecardImpl()`
    */
  def apply(nameOfStudent: String, rollNumber: Int, subjects: List[Subject], course: Course): Scorecard = ???

  private def isSubjectInCourse: Boolean = ???
}
