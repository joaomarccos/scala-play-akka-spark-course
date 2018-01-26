package corescala

object Fatorial {
  def fatorial(x: Int): Int = if (x == 1) 1 else x * fatorial(x - 1)
  def fatorial2(x: Int): Int = x match {
  	case 1 => 1
  	case outro => outro * fatorial2(outro - 1)
  }
}
