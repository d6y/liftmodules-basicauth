name := "basic-auth"

version := "2.4-M4-1.0"

organization := "net.liftmodules"

scalaVersion := "2.9.1"
 
// If using JRebel
jettyScanDirs := Nil

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

libraryDependencies ++= {
  val liftVersion = "2.4-M4" 
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default")
}

// Customize any further dependencies as desired
libraryDependencies ++= Seq(
  "javax.servlet" % "servlet-api" % "2.5" % "provided->default",
  "ch.qos.logback" % "logback-classic" % "0.9.29" % "compile->default" // Logging
)

// To publish to the Cloudbees repos:

publishTo := Some("liftmodules repository" at "https://repository-liftmodules.forge.cloudbees.com/release/")
 
credentials += Credentials( file("/private/liftmodules/cloudbees.credentials") )
