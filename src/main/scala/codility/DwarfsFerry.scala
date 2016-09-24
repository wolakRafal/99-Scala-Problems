package codility

object DwarfsFerry {

  case class Seat(occupied: Boolean = false, barrel: Boolean = false)

  type Raft = Array[Array[Seat]]

  def toInt(char: Char): Int = char - 'A'

//  def count()

  def makeRaft(n: Int, s: String, t: String): Raft = {
    val raft = Array.fill(n)(Array.fill(n)(Seat()))
    s.split(" ").filter(_.nonEmpty).foreach {
      case seat =>
        val row = seat.take(1).toInt - 1
        val col = toInt(seat(1))
        raft(row)(col) = Seat(barrel = true)
    }

    t.split(" ").filter(_.nonEmpty).foreach {
      case seat =>
        val row = seat.take(1).toInt -1
        val col = toInt(seat(1))
        raft(row)(col) = Seat(occupied = true)
    }
    raft
  }

  def freeSeats(raft: Raft): Int = raft.map(_.count(seat => (seat.barrel == false ) && (seat.occupied == false))).sum

  /**
    * Checks if given number of `dwarfs` can be placed in `raft`
    *
    * @param raft the raft representation
    * @param dwarfs number of dwarfs to position in raft
    * @return >= 0 if we cane fit all dwarfs on the raft
    *          < if we cannot fit all dwarfs
    */
  def check(raft: Raft, dwarfs: Int): Int = ???

  def solution(n: Int, s: String, t: String): Int = {
    var result = -1
    val raft: Raft = makeRaft(n, s,t)

    val maxDwarfs: Int = freeSeats(raft)

    var begin = 0
    var end = maxDwarfs

    // binary search of results give as O(log n) tries
    while (begin <= end) {
      val mid = (begin + end ) / 2 // + 1??
      // check is O(n+m)
      if (check(raft, mid) >= 0) {
        // we fit all dwarfs , try more
        begin = mid + 1
        result = mid
      } else {
        // cannot fit all dwarfs check smaller number
        end = mid - 1
      }
    }
    result
  }

}
