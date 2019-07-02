scalaVersion := "2.11.8"


organization := "demo"

val derby = "org.apache.derby" % "derby" % "10.4.1.3"

lazy val hello = (project in file("."))
  .settings(
    name := "Demo",
    mainClass in assembly := Some("demo.Demo"),

    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", xs@_*) => MergeStrategy.discard
      case x => MergeStrategy.first
    },
    
    libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.0",
    libraryDependencies += "com.holdenkarau" %% "spark-testing-base" % "1.6.1_0.3.2" % Test


  )


