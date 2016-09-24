/** ***************************************************************************
  * Copyright (c) 2015
  * ADVA Optical Networking
  *
  * All rights reserved. Any unauthorized disclosure or publication of the
  * confidential and proprietary information to any other party will constitute
  * an infringement of copyright laws.
  *
  * $Id$
  * Author  : Rafal Wolak, RWolak@advaoptical.com
  * Created : 24 September 2016
  * Purpose :
  *
  * $Rev$
  * $URL$
  *
  * Notes:
  *
  * ****************************************************************************
  */

package codility

import codility.DwarfsFerry.Seat
import org.specs2.mutable.Specification

class DwarfsFerrySpec extends Specification {

  "make raft" should {
    "N = 4 , S = '1B 1C 4B 1D 2A' and T = '3B 2D'" in {
      DwarfsFerry.makeRaft(4, "1B 1C 4B 1D 2A", "3B 2D") must_==
        Array(Array(Seat(), Seat(barrel = true), Seat(barrel = true), Seat(barrel = true)),
             Array(Seat(barrel = true), Seat(), Seat(), Seat(occupied = true)),
             Array(Seat(), Seat(occupied = true), Seat(), Seat()),
             Array(Seat(), Seat(barrel = true), Seat(), Seat())
        )
    }
  }

  "free seats" should {
    "for N = 4 , S = '1B 1C 4B 1D 2A' and T = '3B 2D' " in {
      DwarfsFerry.freeSeats(DwarfsFerry.makeRaft(4, "1B 1C 4B 1D 2A", "3B 2D")) must_== 9
    }

    "for N = 4 , S and T  empty " in {
      DwarfsFerry.freeSeats(DwarfsFerry.makeRaft(4, "", "")) must_== 16
    }
  }

}

