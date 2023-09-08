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

  // syntax sugars
  val doubler: Int => Int = (x: Int) => 2 * x
  doubler(5)   // 25
  /*
    equivalent to:

  val doubler = new Function1[Int, Int] {
    override def apply(x: Int): Int = 2 * x
  }
   */

  // higher-order functions: take functions as args and return functions as results
  val aMappedList = List(1, 2, 3).map(x => x + 1)
  val aFlatMapped = List(1, 2, 3).flatMap(x => List(x, 2 * x))
  println(aFlatMapped)    //  [1, 2, 2, 4, 3, 6]
  val aFilteredList = List(1, 2, 3, 4).filter(_ % 2 == 0)
  println(aFilteredList)

  // all combinations between the numbers 1, 2, 3 and the letters A, B, C
  val combinedLists = List(1, 2, 3).flatMap(number => List("A", "B", "C").map(letter => s"$number-$letter"))
  println(combinedLists)
}
