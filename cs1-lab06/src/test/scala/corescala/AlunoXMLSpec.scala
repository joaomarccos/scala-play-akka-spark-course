package corescala

import org.specs2.mutable.Specification
import org.specs2.specification.Scope
import org.specs2.matcher.XmlMatchers
import org.specs2.mock.Mockito

class AlunoXMLSpec extends Specification with XmlMatchers with Mockito {
  "geracao de xmls de alunos" >> {
    
	val alunoMock = mock[AlunoDAO]
    alunoMock.findAll returns List(new Aluno("joao", "joao@test.com"), new Aluno("maria", "maria@test.com"))
	
    "gerar a lista completa" >> {
      val alunoXML = new AlunoXML(alunoMock)
      alunoXML.alunos must ==/(
        <alunos>
          <aluno email="joao@test.com">joao</aluno>
          <aluno email="maria@test.com">maria</aluno>
        </alunos>
      )
    }
  }
}