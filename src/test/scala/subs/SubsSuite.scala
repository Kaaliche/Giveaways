package subs

import org.scalatest.FunSuite
import subs.Subs._
import utils.db.User

import scala.collection.mutable.Map

class SubsSuite extends FunSuite {

  test("Get subs from a list") {
    val Users_Map: Map[Int, User] = Map((0, User(0, "Hernandez", "Pierre", false, true)))
    val subs = getSubs(Users_Map)
    assert(subs == List(("Hernandez", "Pierre")))
  }
}
