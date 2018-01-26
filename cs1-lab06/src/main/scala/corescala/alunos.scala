package corescala

case class Aluno(nome: String, email: String)

class AlunoXML(alunoDAO: AlunoDAO) extends AlunoLog{
  def alunos = {
    val alunos = alunoDAO.findAll

    log(s"Gerando XML para ${alunos.length}")

    <alunos>
      {alunos.map{ aluno =>
        <aluno email={aluno.email}>{aluno.nome}</aluno>
      }}
    </alunos>
  }
}

class AlunoDAO {
  def findAluno(name: String): Option[Aluno] = throw new UnsupportedOperationException("not implemented yet")
  def findAll: List[Aluno] = throw new UnsupportedOperationException("not implemented yet")
}

trait AlunoLog{
  def log(msg:String) = println(msg)
}
