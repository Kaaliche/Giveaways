package subs

import utils.db._

object Subs {
 /* def getSubs(users: List[Subs]): List[String] = {
    users.map(x => x.name)
  } */

  def getSubs(users: List[User]): List[(String, String)] = {
    for{
      u <- users if u.subscribe
    } yield (u.nom, u.pnom)
  }
}
