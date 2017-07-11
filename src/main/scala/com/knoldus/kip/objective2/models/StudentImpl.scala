package com.knoldus.kip.objective2.models

case class StudentImpl(name: String, rollNumber: Int, age: Int, gender: Char, enrollemntNumber: Long,
                       course: String) extends Student {
  def apply(name: String, rollNumber: Int, age: Int, gender: Char, enrollemntNumber: Long,
            course: String): Student = ???
}
