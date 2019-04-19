package tips

import utils.db._
import scala.collection.mutable.Map

object Tips {


  def getDonator(tipN:List[Don], users: List[User]): List[User] = {    //recupere la liste des donateurs
    val idUserDon = tipN.map(x => x.idUser)
    users.filter(x => idUserDon.contains(x.idUser))
  }

  def mkDonation(tipN: List[Don], id1:Int, user1:Int, amount1:Double): List[Don] = {              //Realiser un don
    tipN :+ Don(id1, user1, amount1)
  }

  def cancelDonation(tipN: List[Don], id1:Int, user1:Int, amount1:Double): List[Don] = {          //Annuler un don
    tipN.filterNot( _==Don(id1, user1, amount1))
  }

  def sumDonation(donator: Map[Int,Don]):Double={                                                 //Total des dons
    donator.values.map(p => p.prix).sum
  }

  def sumDonationperUser(donator: Map[Int,Don]):Map[Int,Double]={                                //Total des dons/User
    val iter= donator.values
    val map2 = iter.groupBy(_.idUser)
    val m = map2.mapValues(_.map(_.prix).sum)
    Map(m.toSeq: _*)
  }

  def sumDonationForUser(donator: Map[Int,Don], id: Int):(Int, Double)={                                    //Total des dons pour un User
    val map = sumDonationperUser(donator)
    (id, map(id))
  }
}