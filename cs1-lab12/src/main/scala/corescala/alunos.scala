package corescala

case class Aluno(id: Int, nome: String, idade: Int, notas: List[Int], media: Option[Double])

object Alunos {
  def encontraMaiores(alunos: List[Aluno]): List[Aluno] = alunos.filter(_.idade >= 18)

  def nomes(alunos: List[Aluno]): List[String] = alunos.map(_.nome)

  // na implementação da função abaixo, use as funções acima como base
  def nomesMaiores(alunos: List[Aluno]): List[String] = nomes (encontraMaiores(alunos))


  def calculaMedias(alunos: List[Aluno]): List[Aluno] = {
  	alunos.map(aluno => {
  		if (aluno.notas.length < 3) throw new IllegalStateException(s"${aluno.nome} nao tem a quantidade certa de notas, notas encontradas: ${aluno.notas.mkString(", ")}")
  		val media = Option(trunc(aluno.notas.sum.toDouble / aluno.notas.length)); 
  		aluno.copy(media = media)
  	})
  }
  
  // use esta função para evitar dizimas periódicas
  def trunc(x: Double) = math.round(x * 100) * 0.01
}
