package tips

import org.scalatest.FunSuite
import utils.db._
import tips.Tips._

import scala.collection.mutable.Map

class Tips {
  test("Create a donator") {
    val donatorU = User(4,"CAFFE","John",true,true)
    val donatorD = Don(4,4,50.0)
    assert(ListUser == getDonator(tipN:List[Don], users: List[User]))
  }

  test("Donation loading") {
    val donatorD = Don(4,4,50.0)
    val donDone = List[Don] :+ donatorD
    assert(donDone == mkDonation(tipN: List[Don], id1:Int, user1:Int, amount1:Double))
  }

  test("Cancel Donation") {
    val donatorD = Don(4,4,50.0)
    val donDone = List[Don] :+ donatorD
    assert(donDone == cancelDonation(tipN: List[Don], id1:Int, user1:Int, amount1:Double))
  }

  test("sum donations") {
    val DONATOR_MAP: Map[Int,Don] = Map((0, Don(0,1,50.0)),(1,Don(1,2,50.00)),(2,Don(2,0,25.00)),(3,Don(3,1,2.50)))
    val total = sumDonation(DONATOR_MAP)
    assert(total == 127.50)
  }

  test("sum donnations/Users"){

  }
}
