package blacklist

import utils.db._
import scala.collection.mutable.Map

object Blacklist {

  def setBlacklist(users: Map[Int, User], id: Int): Map[Int, User] =  {
    users(id) = users(id).copy(blacklist = true)
    users
  }

  def unsetBlacklist(users: Map[Int, User], id: Int): Map[Int, User] =  {
    users(id) = users(id).copy(blacklist = true)
    users
  }
}
