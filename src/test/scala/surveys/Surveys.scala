package surveys

import org.scalatest.FunSuite
import surveys.Surveys._
import utils.db._


class Surveys extends FunSuite {
  test("Create a survey") {
    val survey = Survey("Yo tout le monde ça va ?", "Oui", "Non")
    assert(survey == Survey("Yo tout le monde ça va ?", "Oui", "Non"))
  }

  test("A user should be able to vote on a survey") {

  }

  test("We should be able to get results from a survey") {
    val survey = Survey("Yo tout le monde ça va ?", "Oui", "Non", 10, 20)
    val results = getResults(survey)
    assert(results == "Choice 1 : 10 - Choice 2 : 20")
  }
}
