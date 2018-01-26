package corescala

import org.specs2.mutable.{Specification,After}
import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import ColetorParticipantes._
import scala.collection.mutable._

abstract class AkkaTestkitSpecs2Support extends TestKit(ActorSystem()) 
                                           with After 
                                           with ImplicitSender {
  def after = system.terminate()
}

class ColetorParticipantesSpec extends Specification {

	"Ator Coletor Participantes" >> {
		"deve retornar a lista de participantes correta" >> new AkkaTestkitSpecs2Support {			
			val ator = system.actorOf(Props[ColetorParticipantes])
			ator ! Participante("João","joao@email.com")
			ator ! Participante("outro","outro@email.com")
			ator ! Participante("participante x","outro@email.com")

			ator ! GetParticipantes
			expectMsg(Seq("João", "outro", "participante x"))
		}
	}
}