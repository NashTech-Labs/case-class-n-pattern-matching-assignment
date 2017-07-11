package com.knoldus.kip.objective1.models

trait Course {
  val name: String
  val subjects: List[Subject]
  val id: String
  val failPercentage: Float
}
