class Calculadora{
	def soma (x:BigDecimal, y: BigDecimal) = x + y
	def subtrai (x:BigDecimal, y: BigDecimal) = x - y
	def multiplica (x:BigDecimal, y: BigDecimal) = x * y
	def divide (x:BigDecimal, y: BigDecimal) = x / y
	def modulo (x:BigDecimal, y: BigDecimal) = x % y	
	def porcentagem(x:BigDecimal, y: BigDecimal) = /(*(x,y), 100) 

	def + = soma _
	def - = subtrai _
	def * = multiplica _
	def / = divide _
	def % = modulo _
}

