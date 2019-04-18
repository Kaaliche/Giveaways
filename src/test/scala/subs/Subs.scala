package subs

import org.scalatest.FunSuite
import subs.Subs._
import utils.db.User

class Subs extends FunSuite {

  test("Get subs from a list") {
    val Users: List[User] = List(User(0,"Hernandez","Pierre",false,true))
    val subs = getSubs(Users)
    assert(subs == ("Hernandez", "Pierre"))
  }
}
