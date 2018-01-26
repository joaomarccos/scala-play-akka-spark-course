package corescala

import org.specs2.mutable.Specification

class FatorialSpec extends Specification {
  "fatorial" >> {
    "ter o valor correto com o algoritmo convencional" >> {
      Fatorial.fatorial(4) must_== 24
      Fatorial.fatorial(5) must_== 120
    }

    "ter o valor correto com o algoritmo com pattern matching" >> {
      Fatorial.fatorial2(4) must_== 24
      Fatorial.fatorial2(5) must_== 120
    }
  }
}
