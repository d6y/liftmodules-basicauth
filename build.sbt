name := "basic-auth"

version := "2.4-M4-1.0"

organization := "net.liftmodules"

 
scalaVersion := "2.9.1"
 
seq(com.github.siasia.WebPlugin.webSettings :_*)

// If using JRebel
jettyScanDirs := Nil

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

resolvers += "liftmodules repository" at "http://repository-liftmodules.forge.cloudbees.com/release/"

libraryDependencies ++= {
  val liftVersion = "2.4-M4" 
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default")
}

// Customize any further dependencies as desired
libraryDependencies ++= Seq(
  "javax.servlet" % "servlet-api" % "2.5" % "provided->default",
  "ch.qos.logback" % "logback-classic" % "0.9.26" % "compile->default" // Logging
)


