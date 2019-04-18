package surveys

import utils.db._

case class Survey(question: String, c1: String, c2: String, c1_votes: Int = 0, c2_votes: Int = 0)

object Surveys {
  def createSurvey(question: String, c1: String, c2: String): Survey = {
    Survey(question, c1, c2)
  }

  def vote() = {}

  def getResults(survey: Survey): String = {
    s"Choix 1 : ${survey.c1_votes} - Choix 2 : ${survey.c2_votes}"
  }
}
