package utils.db

import akka.Done
import surveys.Survey

import scala.collection.mutable.Map

case class User(idUser:Int, nom:String, pnom:String, blacklist:Boolean, subscribe:Boolean)
case class Don(idDon:Int, idUser:Int, prix:Double )
case class GiveAway(idGiveAways:Int, nomGiveAways:String)
case class GiveAwayToUser(idGiveAways:Int, idUser: Int)

class Database {

  var USERS: List[User] = List(User(0,"Hernandez","Pierre",false,true),User(1,"Petricevic","Adrian",false,false), User(2,"Tardy","Charles",true,true))
  var DONS: List[Don] = List(Don(0,1,50.0),Don(1,2,50.00),Don(2,0,25.00),Don(3,1,2.50))
  var GIVEAWAYS: List[GiveAway] = List(GiveAway(0,"Tombola du jour"), GiveAway(1,"Tombala d'hier"))
  var GIVEAWAYTOUSERS : List[GiveAwayToUser] = List(GiveAwayToUser(0,0),GiveAwayToUser(0,1),GiveAwayToUser(1,0),GiveAwayToUser(1,2))

  val USERS_MAP: Map[Int, User] = Map((0, User(0,"Hernandez","Pierre",false,true)), (1, User(1,"Petricevic","Adrian",false,false)), (2, User(2,"Tardy","Charles",true,true)))
  val SURVEYS_MAP: Map[Int, Survey] = Map((0, Survey("Yo tout le monde ça va ?", "Oui", "Non")), (1, Survey("Elle est où la poulette ?", "Elle est bien cachée", "Mordu")))






}
