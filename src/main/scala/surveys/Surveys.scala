package surveys

import utils.db._
import scala.collection.mutable.Map

object Surveys {

  def createSurvey(surveyMap: Map[Int, Survey], question: String, c1: String, c2: String): Map[Int, Survey] = {
    var count = 0
    if(surveyMap.nonEmpty) {
      count = surveyMap.size
    }
    surveyMap(count) = Survey(question, c1, c2)
    surveyMap
  }

  def vote(surveyMap: Map[Int, Survey], id: Int, choice: Int) : Map[Int, Survey] = choice match {
    case 1 => surveyMap(id) = surveyMap(id).copy(c1_votes = surveyMap(id).c1_votes + 1)
      surveyMap
    case 2 => surveyMap(id) = surveyMap(id).copy(c2_votes = surveyMap(id).c2_votes + 1)
      surveyMap
    case _ => surveyMap
  }

  def getResults(surveyMap: Map[Int, Survey], id: Int): String = {
    s"Choix 1 : ${surveyMap(id).c1_votes} - Choix 2 : ${surveyMap(id).c2_votes}"
  }
}