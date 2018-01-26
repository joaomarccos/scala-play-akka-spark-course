package corescala

import akka.actor._
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import scala.language.postfixOps

case class Participante(nome: String, email: String){

}

case object ImprimaParticipantes{

}

class ColetorParticipantesConfig extends Actor{
	import scala.collection.mutable.MutableList
	import akka.actor.SupervisorStrategy._
	import akka.actor.OneForOneStrategy
	import akka.routing._
	import scala.concurrent.duration._	
	import EnviadorEmails._			

	val participantes = MutableList[Participante]()
	val enviadorEmails = context.actorOf(FromConfig.props(Props[EnviadorEmails]),"RoteadorEmails")	

	override val supervisorStrategy = OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 minute) {
		case _:TimeoutException => Resume
		case _:UnknownHostException => Restart
	}

	def receive = {
		case Participante(nome, email) => {			
			participantes += Participante(nome, email)
			enviadorEmails ! EnviarEmail(email, s"$nome, bem vindo(a)!")			
		}

		case ImprimaParticipantes => {
			sender ! participantes.toList
		}	
	}
}

class ColetorParticipantes extends Actor{
	import scala.collection.mutable.MutableList
	import akka.actor.SupervisorStrategy._
	import akka.actor.OneForOneStrategy
	import akka.routing._
	import scala.concurrent.duration._	
	import EnviadorEmails._			

	val participantes = MutableList[Participante]()
	val enviadorEmails = context.actorOf(BalancingPool(5).props(Props[EnviadorEmails]),"RoteadorEmails")	

	override val supervisorStrategy = OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 minute) {
		case _:TimeoutException => Resume
		case _:UnknownHostException => Restart
	}

	def receive = {
		case Participante(nome, email) => {			
			participantes += Participante(nome, email)
			enviadorEmails ! EnviarEmail(email, s"$nome, bem vindo(a)!")			
		}

		case ImprimaParticipantes => {
			sender ! participantes.toList
		}	
	}
}

class EnviadorEmails extends Actor with Logger{
	import EnviadorEmails._
	import scala.collection.mutable.MutableList

	var contadorDeEmailsEnviados = 0

	override def preStart = log(s"[${self.path}] Iniciando o ator de envio de emails")

	override def preRestart(reason: Throwable, msg:Option[Any]) = log(s"[${self.path}] O ator de envio de emails vai ser reiniciado. Causa: [$reason]")
	
	def receive = {
		case EnviarEmail(email, msg) if email == "timeout" => throw new TimeoutException
		case EnviarEmail(email, msg) if email == "desconhecido" => throw new UnknownHostException
		case EnviarEmail(email, msg) => {
			val enviar = s"Enviando:\n $msg \npara: $email"
			contadorDeEmailsEnviados += 1
			println(s"[${self.path}: $contadorDeEmailsEnviados enviados]\n $enviar")
		}
		case "desconhecido" => throw new UnknownHostException
	}
}



object EnviadorEmails {
	case class EnviarEmail(email:String, msg:String)
}

trait Logger{
	def log(msg: String){
		val traco = s"${"-" * msg.length}"		
		println(s"$traco\n$msg\n$traco\n")		
	}
}