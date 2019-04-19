package tips

import utils.db.Database._


class Tips {


  def getDonator(tipN:List[Don], users: List[User]): List[User] = {    //recupere la liste des donateurs
    val idUserDon = tipN.map(x => x.idUser)
    users.filter(x => idUserDon.contains(x.idUser))
  }

  def mkDonation(tipN: List[Don], id1:Int, user1:Int, amount1:Double): List[Don] = {              //Realiser un don
    tipN :+ Don(id1, user1, amount1)
  }

  def cancelDonation(tipN: List[Don], id1:Int, user1:Int, amount1:Double): List[Don] = {          //Annuler un don
    tipN -= Don(id1, user1, amount1)
  }

  def sumDonation(donator: Map[Int,Don]):Double={                                                 //Total des dons
    Map.values.map(prix).sum
  }

  def sumDonationperUser(donator: Map[Int,Don]):List[Int,Double]={                                      //Total des dons/User
    Map.values.filter

  }

  def sumDonationForUser(donator: Map[Int,Don]):{Int,Double}={                                          //Total des dons pour un User


  }
}