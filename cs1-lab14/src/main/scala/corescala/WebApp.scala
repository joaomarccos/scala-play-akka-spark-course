package corescala

class Request(val id: Int)

class WebApp {
  def index(implicit request: Request): String = "id: " + request.id
  def about(implicit request: Request): String = "about!"
  def contato(implicit request: Request): String = "envie emails para teste@test.com"
}
