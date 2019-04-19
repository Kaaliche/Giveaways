package surveys

import scala.collection.mutable.Map
import org.scalatest.FunSuite
import surveys.Surveys._
import utils.db._


class SurveysSuite extends FunSuite {

  val survey = Survey("Yo tout le monde ça va ?", "Oui", "Non")
  val surveyMap: Map[Int, Survey] = Map[Int, Survey]()

  test("Create a survey") {
    createSurvey(surveyMap, "Yo tout le monde ça va ?", "Oui", "Non")
    assert(survey == surveyMap(0))
  }

  test("A user should be able to vote on a survey") {
    vote(surveyMap, 0, 1)
    assert(surveyMap(0).c1_votes == 1)
  }

  test("We should be able to get results from a survey") {
    val results = getResults(surveyMap, 0)
    assert(results == "Choix : 1 - Choix 2 : 0")
  }
}
