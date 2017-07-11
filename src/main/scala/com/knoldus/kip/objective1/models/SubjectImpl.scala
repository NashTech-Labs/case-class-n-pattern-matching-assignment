package com.knoldus.kip.objective1.models

case class SubjectImpl(name: String, id: String, obtainedMarks: Float, maxMarks: Float) extends Subject {
  def apply(name: String, id: String, obtainedMarks: Float, maxMarks: Float): SubjectImpl = ???
}
