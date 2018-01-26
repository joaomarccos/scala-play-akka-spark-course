package corescala

// obs: conforme for executando os passos abaixo, use sempre os testes como guia para saber se tudo está como deveria ou não
//      se necessário, corrija eventuais problemas gerados nos testes também

// 1. corrija a implementação dos métodos
// 2. normalize os parâmetros, de forma que todos os métodos recebam apenas Double
// 3. declare os tipos de retorno dos métodos como Double

class Calc(nomeUsuario: String) {
  val nome = nomeUsuario.split(" ")(0)
  val sobrenome = nomeUsuario.split(" ")(1)

  def soma(x: Double, y: Double):Double = x + y
  def subtrai(x: Double, y: Double):Double = x - y
  def multiplica(x: Double, y: Double):Double = x * y
  def divide(x: Double, y: Double):Double = x / y
}
