package corescala

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class AlunosSpec extends Specification {
  "o object Alunos" >> {
    "encontrar todos os alunos maiores de idade" >> new AlunosScope  {
      Alunos.encontraMaiores(alunos) must_== List(a1, a4, a6, a8, a9)
    }

    "retornar uma lista apenas com os nomes dos alunos" >> new AlunosScope {
      Alunos.nomes(alunos) must_== List(
        "Joao", "Paulo", "Maria", "George", "Mariana", "Felipe", "Jorge", "Ricardo", "Madalena"
      )
    }

    "retornar uma lista com os nomes dos alunos maiores de idade" >> new AlunosScope {
      Alunos.nomesMaiores(alunos) must_== List(
        "Joao", "George", "Felipe", "Ricardo", "Madalena"
      )
    }

    "retornar uma nova lista, com a media de todos os alunos calculada" >> new AlunosScope {
      Alunos.calculaMedias(alunos) must_== List(
        a1.copy(media = Some(7)),
        a2.copy(media = Some(5.33)),
        a3.copy(media = Some(8.67)),
        a4.copy(media = Some(7)),
        a5.copy(media = Some(3)),
        a6.copy(media = Some(9.67)),
        a7.copy(media = Some(8.67)),
        a8.copy(media = Some(5.67)),
        a9.copy(media = Some(4))
      )
    }

    "lancar erro se algum aluno nao tiver 3 notas" >> {
      Alunos.calculaMedias(List(Aluno(99, "Maria", 29, List(1, 9), None))) must throwAn[IllegalStateException](
        message = "Maria nao tem a quantidade certa de notas, notas encontradas: 1, 9")
    }
  }

  class AlunosScope extends Scope {
    val a1 = Aluno(1, "Joao", 18, List(5, 7, 9), None)
    val a2 = Aluno(2, "Paulo", 12, List(1, 7, 8), None)
    val a3 = Aluno(3, "Maria", 17, List(7, 10, 9), None)
    val a4 = Aluno(4, "George", 29, List(10, 7, 4), None)
    val a5 = Aluno(5, "Mariana", 15, List(2, 1, 6), None)
    val a6 = Aluno(6, "Felipe", 60, List(10, 10, 9), None)
    val a7 = Aluno(7, "Jorge", 5, List(8, 9, 9), None)
    val a8 = Aluno(8, "Ricardo", 33, List(1, 7, 9), None)
    val a9 = Aluno(9, "Madalena", 41, List(5, 2, 5), None)

    val alunos = List(a1, a2, a3, a4, a5, a6, a7, a8, a9)
  }
}
