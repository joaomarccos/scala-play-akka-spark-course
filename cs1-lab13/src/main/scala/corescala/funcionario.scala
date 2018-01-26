package corescala

import scala.xml.NodeSeq

case class Funcionario(nome: String, salario: BigDecimal)

object Funcionario {
  def totalSalarios(funcionarios: List[Funcionario]): BigDecimal = funcionarios.foldLeft(BigDecimal(0))( (total, f) => total + f.salario )

  def xml(funcionarios: List[Funcionario]): NodeSeq =
    <funcionarios>
      {funcionarios.foldLeft(NodeSeq.Empty){(node, f) =>
          node ++ <funcionario salario={f.salario.toString}>{f.nome}</funcionario>
        }
      }
    </funcionarios>
}
