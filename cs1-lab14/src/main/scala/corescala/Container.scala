package corescala

import scala.xml.NodeSeq

class Container(implicit app: WebApp) {
  private implicit val request = new Request(1)

  def run(page: String): String = page match {
    case "index" => app.index
    case "about" => app.about
    case "contato" => app.contato
    case p => "pagina desconhecida"
  }
}