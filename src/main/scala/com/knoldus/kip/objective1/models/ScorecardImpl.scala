package com.knoldus.kip.objective1.models

case class ScorecardImpl(nameOfStudent: String, rollNumber: Int, subjects: List[Subject], total: Float = 0,
                         percentage: Float = 0, grade: String = "") extends Scorecard {

}

object ScorecardImpl {
  def apply(nameOfStudent: String, rollNumber: Int, subjects: List[Subject]): ScorecardImpl = {

    if (subjects.isEmpty) {
      throw new IllegalArgumentException("Not enough subjects are supplied. Please add more subjects")
    }

    val obtainedMarks: List[Float] = subjects map (_.obtainedMarks)
    val totalMarks: List[Float] = subjects map (_.maxMarks)

    val obtainedTotal = obtainedMarks.foldLeft(0.0){(z,i) => z + i}
    val grandTotal = totalMarks.foldLeft(0.0){(z,i) => z + i}

    val percentage: Double = (obtainedTotal/grandTotal) * 100


    //Add all the cases of all grades like wise. Handle the case when percentage is more than 100%
    val grade = percentage match {
      case greaterThanNinety: Double if greaterThanNinety >= 90 => "A"
      case _ => "F"
    }

    new ScorecardImpl(nameOfStudent, rollNumber, subjects, obtainedTotal.toFloat, percentage.toFloat, grade)
  }

}
