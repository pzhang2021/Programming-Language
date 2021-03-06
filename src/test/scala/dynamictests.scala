import org.scalatest.*
import org.scalatest.prop.TableDrivenPropertyChecks.*

class dynamictests extends UnitSpec:
  val EX : Map[Int, Tag] = 
    (for i <- (1 to 3).toList yield {
      object T extends Tag ("dynamicex%02d".format (i))
      (i, T)
    }).toMap

  import dynamic.*

  property ("EX01 - useGreet", EX (1)) {
    for greeting <- List ("Hello", "Bonjour")
        name     <- List ("Alice", "Bob")
    do
      val res1 = useGreet (new Internationalization {
        def greet (name : String) = greeting + " " + name
      }, name)
      assert (res1 === greeting + " " + name)
  }

  property ("EX02 - newEnglish", EX (2)) {
    val i18n : Internationalization = newEnglish ()
    for name <- List ("Alice", "Bob") do
      assert (i18n.greet (name) === "Hello" + " " + name)
  }

  property ("EX03 - newFrench", EX (3)) {
    val i18n : Internationalization = newFrench ()
    for name <- List ("Alice", "Bob") do
      assert (i18n.greet (name) === "Bonjour" + " " + name)
  }
