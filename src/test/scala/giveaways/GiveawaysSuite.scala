package giveaways

import org.scalatest.FunSuite
import utils.db._
import giveaways.Giveaways._

import scala.collection.mutable.Map

class GiveawaysSuite extends FunSuite {

  val GiveawayMap: Map[Int, GiveAway] = Map[Int, GiveAway]()
  val Users_Map: Map[Int, User] = Map((0, User(0, "Hernandez", "Pierre", false, true)))

  test("We should be able to create a giveaway") {
    createGiveaway(GiveawayMap, "SOS")
    assert(GiveawayMap(0) == GiveAway(0, "SOS"))
  }

  test("A user should be able to participate in a giveaway") {
    signGiveAway(GiveawayMap, 0, Users_Map, 0)
    assert(GiveawayMap(0) == GiveAway(0, "SOS", Users_Map))
  }

  test("A giveaway should have a winner") {
    val win = winner(GiveawayMap, Users_Map)
    assert(win == User(0, "Hernandez", "Pierre", false, true))
  }
}
