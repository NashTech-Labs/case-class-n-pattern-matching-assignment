package com.knoldus.kip.objective2.models

trait Course {
  val id: String
  val name: String
  val mandatorySubjects: List[Subject]
  val optionalSubjects: List[Subject]
}
