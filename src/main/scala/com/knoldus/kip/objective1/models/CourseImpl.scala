package com.knoldus.kip.objective1.models

case class CourseImpl(id: String, name: String, subjects: List[Subject], failPercentage: Float) extends Course

object CourseImpl {
  def apply(id: String, name: String, subjects: List[Subject], failPercentage: Float): CourseImpl =
    ???
}
