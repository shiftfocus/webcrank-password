name := "webcrank-password"

organization := "ca.shiftfocus"

version := "0.6.0"

scalaVersion := "2.13.14"

crossScalaVersions := Seq("2.12.19")

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
    "maven.private.shiftfocus.ca",
    22,
    "/var/www/maven.shiftfocus.ca/repositories/" + {
      if (isSnapshot.value) "snapshots" else "releases"
    }
  ) as ("gitlab-runner", privateKeyFile))
}
