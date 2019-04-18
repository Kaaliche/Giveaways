package blacklist

import utils.db._

object Blacklist {

  def setBlacklist(users: List[User]): List[Any] = {
    users.patch(3, Seq(true), 1)
  }

  def unsetBlacklist(users: List[User]): List[Any] = {
    users.patch(3, Seq(false), 1)
  }
}
