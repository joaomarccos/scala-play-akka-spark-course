package corescala

import org.specs2.mutable.Specification
import Utils._

class FuncionarioSpec extends Specification {
  "calculo de um valor aumentado" >> {
    aumentar(10)(100) must_== 110
  }

  "calculo de aumento de salario" >> {
    val func = new Funcionario(100)

    "retornar um funcionario com 10% de aumento" >> {
      func.aumentarSalario(v => aumentar10(v)) must_== Funcionario(110)
    }

    "retornar um funcionario com 20% de aumento" >> {
      func.aumentarSalario(v => aumentar20(v)) must_== Funcionario(120)
    }

     "retornar um funcionario com 30% de aumento" >> {
      func.aumentarSalario(v => aumentar30(v)) must_== Funcionario(130)
    }
  }
}
