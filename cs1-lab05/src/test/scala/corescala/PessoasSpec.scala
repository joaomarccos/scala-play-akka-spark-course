package corescala

import org.specs2.mutable.Specification

class PessoasSpec extends Specification {
  "pessoa fisica" >> {
    val pf = PessoaFisica("joao", "12312312312")

    "ter cpf correto" >> {
      pf.cpf must_== "12312312312"
    }

    "ter nome correto" >> {
      pf.nome must_== "joao"
    }
  }

  "pessoa juridica" >> {
    val pj = PessoaJuridica("joao", "24142412410001")

    "ter cnpj correto" >> {
      pj.cnpj must_== "24142412410001"
    }

    "ter nome correto" >> {
      pj.nome must_== "joao"
    }
  }

  "trabalhando com listas de pessoas" >> {
    val pessoas:List[Pessoa] = List(
      PessoaFisica("joao", "123"),
      PessoaJuridica("globalcode", "321435"),
      PessoaFisica("paulo", "321"))    

    "ter o tamanho da lista de pessoas igual a 3" >> {
      pessoas.length must_== 3
    }

    "ter o documento correto" >> {
      pessoas(0).numDocumento must_== "123"
      pessoas(1).numDocumento must_== "321435"
    }
  }
}
