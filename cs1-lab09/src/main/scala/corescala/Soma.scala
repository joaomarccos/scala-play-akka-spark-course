package corescala

object Soma {
  def somar(lista: List[Int]): Int = lista match{
  	case Nil => 0
  	case head :: tail => head + somar(tail)
  }
}
