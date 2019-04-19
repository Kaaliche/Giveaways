package tips

package surveys

import org.scalatest.FunSuite
import surveys.Surveys._
import utils.db._

class Tips {
  test("Create a donator") {
    val donatorU = User(4,"CAFFE","John",true,true)
    val donatorD = Don(4,4,50.0)
    assert(ListUser == getDonator(tipN:List[Don], users: List[User]))
  }

  test("Donation loading") {
    val donatorD = Don(4,4,50.0)
    val donDone = List[Don] :+ donatorD
    asser(donDone == mkDonation(tipN: List[Don], id1:Int, user1:Int, amount1:Double))

  }

  test("We should be able to get results from a survey") {
    val survey = Survey("Yo tout le monde ça va ?", "Oui", "Non", 10, 20)
    val results = getResults(survey)
    assert(results == "Choice 1 : 10 - Choice 2 : 20")
  }
}
