name := "cs2-lab06"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
	"org.specs2" %% "specs2-core" % "3.6.5" % "test",
	"com.typesafe.akka" %% "akka-actor" % "2.4.0",
	"com.typesafe.akka" %% "akka-testkit" % "2.4.0" % "test"
)

