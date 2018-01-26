import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class CalculadoraSpec extends Specification{

	"Somar dois números" should new CalculadoraScope {
		calc.soma(1,1) must beEqualTo(2)
	}

	"Subtrair dois números" should new CalculadoraScope {
		calc.subtrai(1,1) must beEqualTo(0)
	}

	"Multiplicar dois números" should new CalculadoraScope {
		calc.multiplica(1,1) must beEqualTo(1)
	}

	"Dividir por" should new CalculadoraScope {
		calc.divide(1,1) must beEqualTo(1)
	}

	"Exibir resto de divisao" should new CalculadoraScope {
		calc.modulo(5,1) must beEqualTo(0)
	}

	"Calcular a porcentagem" should new CalculadoraScope{
		calc.porcentagem(200, 10) must beEqualTo(20)
	}

	trait CalculadoraScope extends Scope{
		val calc = new Calculadora
	}

}