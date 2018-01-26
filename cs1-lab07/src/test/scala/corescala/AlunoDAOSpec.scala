package corescala

import org.specs2.mutable.Specification

class AlunoDAOSpec extends Specification {
  "o dao de alunos" >> {
    val alunoDAO = new AlunoDAO

    "retornar None se o aluno para o email especificado nao existir" >> {
      alunoDAO.findAlunoByEmail("test@globalcode.com") must_== None
    }

    "retornar Some com o aluno" >> {
      alunoDAO.findAlunoByEmail("p@p.com") must_== Some(Aluno(1, "paulo", "p@p.com", 13))
    }
  }
}
