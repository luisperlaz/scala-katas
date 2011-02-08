import sbt._

class KataProject(info: ProjectInfo) extends DefaultProject(info) {

  // uncomment the following if you want to use the snapshot repo
  val scalatoolsSnapshot = ScalaToolsSnapshots

  override def libraryDependencies = Set(
    "junit" % "junit" % "4.5" % "test->default",
    "org.scala-tools.testing" %% "specs" % "1.6.6" % "test->default",
    "org.scalatest" % "scalatest" % "1.2" % "test->default"
  ) ++ super.libraryDependencies
}
