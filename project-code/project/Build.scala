import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "currency-converter"
  val appVersion      = "1.1.4"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    publishArtifact in(Compile, packageDoc) := false,
    organization := "com.edulify"
  )

}
