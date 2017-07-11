package com.knoldus.kip.objective2.models

case class CourseImpl(id: String, name: String, mandatorySubjects: List[Subject],
                      optionalSubjects: List[Subject]) extends Course {
  def apply(id: String, name: String, mandatorySubjects: List[Subject], optionalSubjects: List[Subject]): CourseImpl = ???
}
