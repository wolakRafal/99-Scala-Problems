
package codility

import org.specs2.mutable.Specification

class BinarySearchSpec extends Specification {

  "Binary search " should {
    "Work for simple case " in {
      BinarySearch.boards(Array(1, 1), 10) must_== 2
    }

    "Work for simple case zero" in {
      BinarySearch.boards(Array(0, 0), 10) must_== 0
    }

    "Work for simple case zero" in {
      BinarySearch.boards(Array(1, 0, 1, 1, 1, 1, 1, 1), 5) must_== -1
    }
  }

}

