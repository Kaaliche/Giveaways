package giveaways

import utils.db._
import scala.collection.mutable.Map
import scala.util.Random

object Giveaways {

  def createGiveaway(giveaways: Map[Int, GiveAway], name: String): Map[Int, GiveAway] = {
      var count = 0
      if(giveaways.nonEmpty) {
        count = giveaways.size
      }
      giveaways(count) = GiveAway(count, name)
      giveaways
  }

  def signGiveAway(giveaways: Map[Int, GiveAway], idGiveaway: Int, users: Map[Int, User], idUser: Int): Map[Int, GiveAway] = {
    if(users(idUser).blacklist){
      giveaways
    }
    //giveaways(idGiveaway) = giveaways(idGiveaway).copy(usersMap = users(idUser))
    giveaways(idGiveaway).usersMap(idUser) = users(idUser)
    giveaways
  }

  def winner(giveaways: Map[Int, GiveAway], users: Map[Int, User]): User = {        //Gagnant du GiveAway
    val random = Random
    val winner = random.nextInt(users.size + 1)
    users(winner)
  }
}
