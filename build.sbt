name := "CSC447"

version := "1.0"

scalaVersion := "3.0.1"

scalacOptions ++= Seq(
  "-encoding", "UTF-8", // Character encoding used by source files.
  "-deprecation",       // Emit warning and location for usages of deprecated APIs.
  "-feature",           // Emit warning and location for usages of features that should be imported explicitly.
  "-unchecked",         // Enable additional warnings where generated code depends on assumptions.
  "-Yexplicit-nulls",   // http://dotty.epfl.ch/docs/reference/other-new-features/explicit-nulls.html
  "-Ysafe-init",        // http://dotty.epfl.ch/docs/reference/other-new-features/safe-initialization.html
  "-new-syntax",        // Require `then` and `do` in control expressions.
  "-source:future",
  "-Xfatal-warnings",
)

Test / scalacOptions += "-language:adhocExtensions"
Test / scalacOptions -= "-Ysafe-init"

libraryDependencies += "org.scalatest"  %% "scalatest"  % "3.2.9"  % Test


