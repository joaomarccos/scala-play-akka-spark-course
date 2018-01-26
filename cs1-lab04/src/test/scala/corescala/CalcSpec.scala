package corescala

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class CalcSpec extends Specification {
  "o nome do usuario da calculadora" >> {
    "ter o nome correto" >> new CalcScope {
      calc.nome must_== "joao"
    }

    "ter o sobrenome correto" >> new CalcScope {
      calc.sobrenome must_== "silva"
    }
  }

  "fazer calculos com a calculadora" >> {
    "somar os numeros" >> new CalcScope {
      calc.soma(1, 2) must_== 3
    }

    "subtrair os numeros" >> new CalcScope {
      calc.subtrai(10, 2) must_== 8
    }

    "multiplicar os numeros" >> new CalcScope {
      calc.multiplica(3, 4) must_== 12
    }

    "dividir os numeros" >> new CalcScope {
      calc.divide(10, 3) must beCloseTo(3.33,0.01)
    }
  }

  trait CalcScope extends Scope {
    val calc: Calc = new Calc("joao silva")
  }
}