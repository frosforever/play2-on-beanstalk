import NativePackagerKeys._
import com.typesafe.sbt.SbtNativePackager._

name := """test-act-docker"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

maintainer in Docker := "John Smith <john.smith@example.com>"

dockerExposedPorts in Docker := Seq(9000, 9443)

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)
