package com.knoldus.kip.models

case class Student(id: Int) extends ModelIdentifier{


}

case class Subject
case class Course


case class Scoreboard

object Scoreboard {
  def apply(student: Student, subject: Subject): Scoreboard = ???
}

case class CoursePerformance(id: Int) extends ModelIdentifier