package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import model._
import play.api.data._
import play.api.data.Forms._


@Singleton
class ParticipantesCotroller @Inject() extends Controller {

  var participantesDao = List(Participante("João", "joao@email.com"))

  def all = Action { req =>
    Ok(views.html.participantes(participantesDao, req.session.get("visitas").map{
      visitas => visitas.toInt
    }.getOrElse(0))) 
  }

  val participanteForm = Form(
    mapping(
      "nome"  -> nonEmptyText,
      "email" -> nonEmptyText
    )(Participante.apply)(Participante.unapply)
  )
 
  def novo = Action{ implicit req => {
      participanteForm.bindFromRequest.fold(
        formWithErrors => {          
          BadRequest(views.html.novoParticipante(formWithErrors))
        },
        userData => {          
          val novoParticipante = Participante(userData.nome, userData.email)     
          participantesDao = participantesDao :+ novoParticipante     
          Redirect(routes.ParticipantesCotroller.all)
        }
      )
    }
  }

  def pageCadastro = Action{
    Ok(views.html.novoParticipante(participanteForm))
  }

}
