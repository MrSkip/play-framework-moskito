import com.typesafe.sbt.SbtAspectj.{ Aspectj, aspectjSettings, compiledClasses }
import com.typesafe.sbt.SbtAspectj.AspectjKeys.{ binaries, inputs, lintProperties }

name := "play_MKS2"

version := "1.0"

lazy val `play_mks2` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(jdbc, cache, ws, specs2 % Test,
  "org.slf4j" % "slf4j-api" % "1.7.21",
  "net.anotheria" % "moskito-aop" % "2.7.4",
  "net.anotheria" % "moskito-core" % "2.7.4",
  "net.anotheria" % "ano-tags" % "2.1.0",
  "net.anotheria" % "moskito-web" % "2.7.4",
  "net.anotheria" % "moskito-webui" % "2.7.4" exclude("de.erichseifert.vectorgraphics2d", "VectorGraphics2D"),
  "net.anotheria" % "moskito-webui-jersey" % "2.4.3" exclude("de.erichseifert.vectorgraphics2d", "VectorGraphics2D"),
  "net.anotheria" % "moskito-inspect-remote" % "2.7.4" exclude("de.erichseifert.vectorgraphics2d", "VectorGraphics2D") exclude("blowfish", "blowfish")
)

unmanagedResourceDirectories in Test <+= baseDirectory(_ / "target/web/public/test")

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

aspectjSettings

inputs in Aspectj <+= compiledClasses

binaries in Aspectj <++= update map { report =>
  report.matching(
    moduleFilter(organization = "net.anotheria", name = "moskito-aop")
  )
}

javaOptions += s"-DlocalRmiRegistryPort=9402"

products in Compile <<= products in Aspectj

products in Runtime <<= products in Compile