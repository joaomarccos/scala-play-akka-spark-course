package corescala

case class Aluno(id: Int, nome: String, email: String, idade: Int)

class AlunoDAO {
  // nosso "banco de dados"
  private val alunos = List(
    Aluno(1, "paulo", "p@p.com", 13),
    Aluno(2, "joao", "j@j.com", 14),
    Aluno(3, "maria", "m@m.com", 15),
    Aluno(4, "jose", "jo@jo.com", 19)
  )

  def findAlunoByEmail(email: String) = alunos.find(a => a.email == email)
}
