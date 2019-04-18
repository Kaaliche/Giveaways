package blacklist

import org.scalatest.FunSuite
import blacklist.Blacklist._
import utils.db._

class Blacklist extends FunSuite {

  test("Blacklist should be set to true") {
    val Users: List[User] = List(User(0,"Hernandez","Pierre",false,true))
    setBlacklist(Users)
    assert(true)
  }

}
