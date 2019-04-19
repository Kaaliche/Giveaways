package giveaways

import utils.db._

object Giveaways {

  def createGiveAway(idGiveAways:Int, nomGiveAways:String){                 //Creation d'une Give away

  }

  def signGiveAway(giveaways: List[GiveAwayToUser], idGiveAways:Int, idUser: Int): List[GiveAwayToUser] = {        //Realiser un don
    giveaways :+ GiveAwayToUser(idGiveAways, idUser)
  }

  def winner(giveaways: List[GiveAwayToUser], users:List[User]): User = {        //Gagnant du GiveAway

  }
}
