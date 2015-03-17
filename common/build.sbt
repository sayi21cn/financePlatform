name := "common"

version := "1.3-SNAPSHOT"

resolvers ++= Seq(
  "Sunlights 3rd party" at "http://nexus.sunlights.me/nexus/content/repositories/thirdparty",
  "Sunlights snapshots" at "http://nexus.sunlights.me/nexus/content/repositories/snapshots/",
  "Sunlights releases" at "http://nexus.sunlights.me/nexus/content/repositories/releases/"
)

libraryDependencies ++= Seq(
  javaCore,
  javaJdbc,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  cache,
  javaWs,
  "org.hibernate" % "hibernate-entitymanager" % "4.3.6.Final",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "commons-beanutils" % "commons-beanutils" % "1.9.2",
  "org.quartz-scheduler" % "quartz" % "2.1.7",
  "commons-io" % "commons-io" % "2.4",
  "commons-net" % "commons-net" % "1.4.1",
  "com.google.guava" % "guava" % "18.0",
  "rapid" % "xsqlbuider" % "1.0.4",
  "com.sunlights" % "QRCode" % "1.0",
  "commons-httpclient" % "commons-httpclient" % "3.1",
  "com.wordnik" %% "swagger-play2" % "1.3.12",
  "org.unitils" % "unitils-core" % "3.4.2",
  "org.unitils" % "unitils-dbunit" % "3.4.2",
  "org.unitils" % "unitils-orm" % "3.4.2"
)

sources in(Compile, doc) := Seq.empty

publishArtifact in(Compile, packageDoc) := false

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishTo <<= version { v: String =>
  val nexus = "http://nexus.sunlights.me/nexus/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "content/repositories/releases")
}
