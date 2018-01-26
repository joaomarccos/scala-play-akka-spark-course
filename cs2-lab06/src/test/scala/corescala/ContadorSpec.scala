package corescala

import org.specs2.mutable.Specification
import akka.testkit.TestActorRef
import akka.actor._

import ContadorActor._

class ContadorSpec extends Specification {
	"O ator Contador" >> {
		implicit val system = ActorSystem("CoreScala")
		val contador = TestActorRef[ContadorActor]	
		
		"contar ate 30" >> {		
			for (i <- 1 to 30) contador ! Contar
			contador.underlyingActor.contador must_== 30
		}
	}
}