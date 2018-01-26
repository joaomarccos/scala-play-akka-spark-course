package corescala

import akka.actor._

object ContadorActor {
	case object Contar
	case object MostrarConta
}

class ContadorActor extends Actor {
	import ContadorActor._
	var contador = 0

	def receive = {
		case Contar => contador += 1
		case MostrarConta => println(contador)
	}
}
