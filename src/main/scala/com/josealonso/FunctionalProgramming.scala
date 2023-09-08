package com.josealonso

object FunctionalProgramming extends App {
  // Scala is OO
  class Person(name: String) {
     def apply(age: Int) = println(s"I am $age years old")
  }

  val bob = new Person("bob")
  bob.apply(24)
  bob(24)  // invoking bob as a function is equivalent to bob.apply()

  /*
    Scala runs on the JVM, which was not built for functional programming.
    How to overcome this limitation:
    Creating instances of the FunctionX trait, where X goes from 1 to 22.
   */
  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(5)
  simpleIncrementer(5)    // Both lines are equivalent

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }
  stringConcatenator("Hello", " Scala")

  // Conclusion: ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES
}
