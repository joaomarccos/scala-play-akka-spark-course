package corescala

import scala.xml.NodeSeq

object Conversor{
	implicit def stringToNodeSeq(x:String):NodeSeq = {
		<html>
			<body>{x}</body>
		</html>
	}
}
