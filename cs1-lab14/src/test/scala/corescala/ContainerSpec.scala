package corescala

import org.specs2.mutable.Specification
import org.specs2.specification.Scope
import org.specs2.matcher.XmlMatchers
import scala.xml.NodeSeq
import Conversor._

class ContainerSpec extends Specification with XmlMatchers{
  "o container processando uma pagina" >> {
    "retornar o id da request na pagina inicial" >> new ContainerScope {
      container.run("index") must_== "id: 1"
    }

    "retornar a pagina de about" >> new ContainerScope {
      container.run("about") must_== "about!"
    }

    "retornar a pagina de contato" >> new ContainerScope {
      container.run("contato") must_== "envie emails para teste@test.com"
    }

    "mostrar pagina de erro para paginas desconhecidas" >> new ContainerScope {
      container.run("jcranky") must_== "pagina desconhecida"
    }    
  }

  "o  containner gerando html" >> {
      "gerar o html com o conteudo correto" >> new ContainerScope{
        val html: NodeSeq = container.run("index")
        html must ==/(
          <html>
            <body>id: 1</body>
          </html>
        )
      }
  }

  class ContainerScope extends Scope {
    implicit val webapp = new WebApp
    val container = new Container
  }
}
