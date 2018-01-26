package corescala

import org.specs2.mutable.Specification

class SomaSpec extends Specification {
  "soma" >> {
    "somar todos os numeros" >> {
      Soma.somar(List(1,2,3)) must_== 6
      Soma.somar(List(4, 6, 10)) must_== 20
      Soma.somar(List(-5, 5, -99, 1, 2, 3)) must_== -93
    }
  }
}
