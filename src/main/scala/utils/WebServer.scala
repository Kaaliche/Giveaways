package utils.db

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.io.StdIn
import blacklist.Blacklist._
import surveys.Surveys._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._
import utils.db.Database._
import subs.Subs._
import tips.Tips._

object WebServer {
  def main(args: Array[String]) {
    // needed to run the route
    implicit val system = ActorSystem("my-system")
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher

    case class Blacklist(idBlackList:Int)
    implicit val blacklistFormat = jsonFormat1(Blacklist)
    case class Survey(id:Int,answer:String, rep1:String, rep2:String)
    implicit val surveyFormat = jsonFormat4(Survey)
    case class Vote(id:Int, choice:Int)
    implicit val voteFormat = jsonFormat2(Vote)
    case class ListUser(listUser:List[User])
    implicit val userFormat= jsonFormat5(User)
    implicit val listUserFormat = jsonFormat1(ListUser)
    case class ListDon(listDon:List[Don])
    implicit val donFormat = jsonFormat3(Don)
    implicit val listDonFormat = jsonFormat1(ListDon)


    val route =
      path("hello") {
        get {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
        }
      }~
        post {
          path("blacklist") {
            entity(as[Blacklist]) { blacklist =>
              USERS_MAP = setBlacklist(USERS_MAP, blacklist.idBlackList)
              complete("User avec id: " + blacklist.idBlackList +" ajouté à la black list")
            }
          }
        }~
        post {
          path("unset_blacklist") {
            entity(as[Blacklist]) { unsetblacklist =>
              USERS_MAP = unsetBlacklist(USERS_MAP, unsetblacklist.idBlackList)
              complete("User avec id: " + unsetblacklist.idBlackList +" enlever de la black list")
            }
          }
        }~
        post{
          path("create_survey") {
            entity(as[Survey]) { survey =>
              SURVEYS_MAP = createSurvey(SURVEYS_MAP, survey.answer, survey.rep1, survey.rep2)
              complete("Ajout du questionnaire \n" + survey.answer + "\n Avec les réponses:\n " + survey.rep1 +"\n" +survey.rep2)
            }
          }
        }~
        post{
          path("vote") {
            entity(as[Vote]) { v =>
              SURVEYS_MAP = vote(SURVEYS_MAP, v.id, v.choice)
              complete("Vous avez voté " +  v.choice +  " pour la question\n" + SURVEYS_MAP(v.id).question)
            }
          }
        }~
        post{
          path("mkDon") {
            entity(as[Don]) { don =>
              DONS = mkDonation(DONS, don.idDon, don.idUser, don.prix)
              complete("Vous avez donnée " +  don.prix)
            }
          }
        }~
        post{
          path("cancelDon") {
            entity(as[Don]) { don =>
              DONS = cancelDonation(DONS, don.idDon, don.idUser, don.prix)
              complete("Vous avez annuler le don " +  don.idDon +" d'une valeur de " +don.prix)
            }
          }
        }~
        path("get_result" ) {
          get{
            parameter('id.as[Int]) {id => complete(getResults(SURVEYS_MAP, id))}

          }
        }~
        path("get_sub" ) {
          get{
            complete(getSubs(USERS_MAP))
          }
        }~
        path("get_don" ) {
          get{
            complete(getDonator(DONS,USERS))
          }
        }~
        path("sum_don" ) {
          get{
            complete("La somme des don est de " + sumDonation(DONATOR_MAP).toString)
          }
        }



    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)
    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}