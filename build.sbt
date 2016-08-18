name := """akka-lnl"""

version := "1.0"

scalaVersion := "2.11.8"

scalacOptions := Seq("-deprecation", "-encoding", "utf8")

lazy val akkaHttpHateoas = ProjectRef(uri("https://github.com/marcuslange/akka-http-hateoas.git"), "akka-http-hateoas")

lazy val root = (project in file("."))
  .dependsOn(akkaHttpHateoas)

libraryDependencies ++= {
  val akkaV = "2.4.4"
  Seq(
    "com.typesafe.akka" %% "akka-slf4j" % akkaV,
    "com.typesafe.akka" %% "akka-http-core" % akkaV,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaV,
    "com.typesafe.akka" %% "akka-actor" % akkaV,

    "com.typesafe.akka" %% "akka-testkit" % akkaV % "test",
    "com.typesafe.akka" %% "akka-http-testkit" % akkaV % "test",
    "org.scalatest" %% "scalatest" % "2.2.6" % "test")
}
