package utils.db

import akka.Done

class Database {

  final case class User(idUser:Int, nom:String, pnom:String, blacklist:Boolean, subscribe:Boolean)
  final case class Don(idDon:Int, idUser:Int, prix:Double )
  final case class GiveAway(idGiveAways:Int, nomGiveAways:String)
  final case class GiveAwayToUser(idGiveAways:Int, idUser: Int)

  var Users: List[User] = List(User(0,"Hernandez","Pierre",false,true),User(1,"Petricevic","Adrian",false,false), User(2,"Tardy","Charles",true,true))
  var Dons: List[Don] = List(Don(0,1,50.0),Don(1,2,50.00),Don(2,0,25.00),Don(3,1,2.50))
  var GiveAways: List[GiveAway] = List(GiveAway(0,"Tombola du jour"), GiveAway(1,"Tombala d'hier"))
  var GiveAwayToUsers : List[GiveAwayToUser] = List(GiveAwayToUser(0,0),GiveAwayToUser(0,1),GiveAwayToUser(1,0),GiveAwayToUser(1,2))





  
}
