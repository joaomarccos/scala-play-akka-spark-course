package corescala

abstract class Pessoa(nome: String) {
  def numDocumento: String
}

class PessoaFisica(val nome: String,val cpf: String) extends Pessoa(nome){
	def numDocumento:String = cpf
	override def toString = s"PessoaFisica(${nome},${cpf})"
}

object PessoaFisica{
	def apply(nome: String, cpf: String) = new PessoaFisica(nome, cpf)
}

class PessoaJuridica(val nome: String,val cnpj: String) extends Pessoa(nome){
	def numDocumento:String = cnpj
	override def toString = s"PessoaJuridica(${nome},${cnpj})"
}

object PessoaJuridica{
	def apply(nome: String, cnpj: String) = new PessoaJuridica(nome, cnpj)
}