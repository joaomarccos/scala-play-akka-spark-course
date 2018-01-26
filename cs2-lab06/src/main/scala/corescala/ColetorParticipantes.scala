package corescala

import akka.actor._

object ColetorParticipantes {
	case class Participante(nome:String,email:String)
	case object GetParticipantes
}

class ColetorParticipantes extends Actor {
	import scala.collection.mutable._
	import ColetorParticipantes._
	
	val participantes:ArrayBuffer[String] = ArrayBuffer()
	
	def receive = {
		case Participante(nome,email) => 
			participantes += nome
		
		case GetParticipantes => sender ! participantes.toList
	}
}