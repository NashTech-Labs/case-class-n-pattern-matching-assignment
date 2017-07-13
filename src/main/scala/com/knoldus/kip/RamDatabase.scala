package com.knoldus.kip

import com.knoldus.kip.models.CoursePerformance

import scala.collection.immutable.List
import scala.collection.mutable.ListBuffer

object RamDatabase {


  val performances: ListBuffer[CoursePerformance] = new ListBuffer[CoursePerformance]()

  def add(coursePerformance: CoursePerformance): ListBuffer[CoursePerformance] = {
    performances += coursePerformance.copy(id = performances.size())
  }

  def update(coursePerformance: CoursePerformance) = {
    performances.update(coursePerformance.id, coursePerformance)
  }

  def getById(id: Int): Option[CoursePerformance] = {
    val performanceList: List[CoursePerformance] = performances.toList
    performanceList.find(_.id = id)
  }

}
