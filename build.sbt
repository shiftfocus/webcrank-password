name := "webcrank-password"

organization := "ca.shiftfocus"

version := "0.5.0"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.mindrot" % "jbcrypt" % "0.4",
  "com.lambdaworks" % "scrypt" % "1.4.0",
  "com.owtelse.codec" % "base64" % "1.0.6"
) 

publishMavenStyle := true

publishTo := {
  val privateKeyFile = new java.io.File(sys.env("HOME") + "/.ssh/id_rsa")
  Some(Resolver.sftp(
    "ShiftFocus Maven Repository",
    "maven.shiftfocus.ca",
    50022,
    "/var/www/maven.shiftfocus.ca/repositories/" + {
      if (isSnapshot.value) "snapshots" else "releases"
    }
  ) as ("maven", privateKeyFile))
}
