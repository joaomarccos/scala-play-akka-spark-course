package corescala

import akka.actor._
import akka.pattern.ask  
import akka.util.Timeout  
import scala.concurrent.duration._
import scala.util._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps
import scala.concurrent.Future


object SistemaColetor extends App{

	val system = ActorSystem("coresscala-system")
	val ator = system.actorOf(Props[ColetorParticipantesConfig], "coletor")

    implicit val timeout = Timeout(5 seconds)

    ator ! Participante("Mateus","mateus@email.com")
    ator ! Participante("Junior","junior@email.com")
	ator ! Participante("Joao","timeout")
	ator ! Participante("Marcos", "desconhecido")

	printMsgOnFuture(ator ? ImprimaParticipantes)
	
	ator ! Participante("Outro", "outro@email.com")

	printMsgOnFuture(ator ? ImprimaParticipantes)

	// Encerra o processamento após um tempo
	Thread.sleep(2000)
	system.stop(ator)
	system.terminate()

	
	/**
	* Imprime a mensagem de resposta quando recebida
	*/
	def printMsgOnFuture(p: Future[Any]){
		p onComplete {
			case Success(msg) => msg match{
				case ps: Seq[_] => ps foreach println
				case tipoDesconhecido => println(tipoDesconhecido)
			}
  			case Failure(t) => println("An error has occured: " + t.getMessage)
		}	
	}

}