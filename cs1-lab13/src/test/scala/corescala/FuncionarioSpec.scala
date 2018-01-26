package corescala

import org.specs2.mutable.Specification
import org.specs2.matcher.XmlMatchers

class FuncionarioSpec extends Specification with XmlMatchers{
  "o objeto Funcionario" >> {
    val funcionarios = List(
      Funcionario("joao", 10000),
      Funcionario("maria", 20000),
      Funcionario("jose", 3000)
    )

    "devolver a media de salarios" >> {
      Funcionario.totalSalarios(funcionarios) must_== 33000
    }

    "criar o xml com a lista de funcionarios" >> {
      Funcionario.xml(funcionarios) must ==/(
        <funcionarios>
          <funcionario salario="10000">joao</funcionario>
          <funcionario salario="20000">maria</funcionario>
          <funcionario salario="3000">jose</funcionario>
        </funcionarios>
      )
    }
  }
}
