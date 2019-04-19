package blacklist

import org.scalatest.FunSuite
import blacklist.Blacklist._
import utils.db._

import scala.collection.mutable.Map

class BlacklistSuite extends FunSuite {

  test("Blacklist should be set to true") {
    val Users_Map: Map[Int, User] = Map((0, User(0, "Hernandez", "Pierre", false, true)))
    setBlacklist(Users_Map, 0)
    assert(Users_Map(1) == User(0, "Hernandez", "Pierre", true, true))
  }

}
