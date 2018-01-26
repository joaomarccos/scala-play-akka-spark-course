object Loader extends App{
	val c = new Calculadora	

	if(args.length > 2){

		val x = BigDecimal(args(0))
		val y = BigDecimal(args(1))
		val op = args(2)

		val resultado = if(op == "+") c.+(x,y) 
			else if(op == "-") c.-(x,y) 
			else if(op == "*") c.*(x, y)
			else if(op == "/") c./(x,y)
			else if(op == "%") c.%(x,y)
			else 0

		println(s"${x} ${op} ${y} = ${resultado}")

	} else {
		println("Parametros não foram informados corretamente")
	}
}