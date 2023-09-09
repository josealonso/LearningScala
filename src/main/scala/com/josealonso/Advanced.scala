package com.josealonso

object Advanced extends App {

  // lazy evaluation
  lazy val lazyValueWithSideEffect = {
    println("This is a lazy block")
    25
  }

  val eagerValue = lazyValueWithSideEffect + 1  // Nothing is printed if this line is commented
  // useful in infinite collections

  // pseudo-collections: Option, Try
  def methodWhichCanReturnNull() = "Hello, Scala"
  val anOption = Option(methodWhichCanReturnNull())  // Some(value) or None
  // option = "collection" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }
  // map, flatMap, filter

}
