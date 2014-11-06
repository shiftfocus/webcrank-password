name := "webcrank-password"

organization := "ca.shiftfocus"

version := "0.4"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "org.mindrot" % "jbcrypt" % "0.3m",
  "com.lambdaworks" % "scrypt" % "1.3.3",
  "com.owtelse.codec" % "base64" % "1.0.6"
)
