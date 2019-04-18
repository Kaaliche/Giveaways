package subs

import utils.db._

import scala.collection.mutable.Map

object Subs {

  def getSubs(users: Map[Int, User]): List[(String, String)] = {
    users.values.toList.map(v => (v.nom, v.pnom))
  }
}
