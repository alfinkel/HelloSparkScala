name := "HelloSpark"
 
version := "1.0"
 
scalaVersion := "2.10.4"
 
libraryDependencies ++= {
    val sparkVersion =  "1.4.1"
    Seq(
        "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
        "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
        "org.apache.spark" %% "spark-repl" % sparkVersion % "provided"
    )
}

assemblyMergeStrategy in assembly := {
 case PathList("org", "apache", "spark", xs @ _*) => MergeStrategy.first
 case PathList("scala", xs @ _*) => MergeStrategy.discard
 case PathList("META-INF", "maven", "org.slf4j", xs @ _* ) => MergeStrategy.first
 case x =>
   val oldStrategy = (assemblyMergeStrategy in assembly).value
   oldStrategy(x)
}