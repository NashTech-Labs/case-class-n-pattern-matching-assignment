package com.knoldus.kip.objective1.models

case class StudentImpl(name: String, rollNumber: Int, age: Int, gender: Char, enrollemntNumber: Long,
                       course: Course) extends Student {

}

object StudentImpl {
  def apply(name: String, rollNumber: Int, age: Int, gender: Char, enrollemntNumber: Long,
            course: Course): StudentImpl = ???
}