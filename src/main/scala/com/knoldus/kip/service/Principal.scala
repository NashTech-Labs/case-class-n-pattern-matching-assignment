package com.knoldus.kip.service

import com.knoldus.kip.models.{Scoreboard, CoursePerformance}

trait Principal {


  def findOutIfCSE(id: Int): CoursePerformance = ???

  def findOutIfAnyCourse(id: Int, courseName: String): CoursePerformance = ???

  def expression(mod: Any): String = ???

  def checkScoreboard(scoreboard: Scoreboard): List[String] = ???

  def expressionRevisited: PartialFunction[String, String] = ???

}
