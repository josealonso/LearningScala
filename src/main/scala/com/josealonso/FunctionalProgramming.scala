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
  val pairs = List(1, 2, 3).flatMap(number => List("A", "B", "C").map(letter => s"$number-$letter"))
  println(pairs)

  // for comprehensions
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List("A", "B", "C")
  } yield s"$number-$letter"
  println(alternativePairs)
  // equivalent to the map/flatMap chain above

  /*
   * Collections:
   * Lists, seq, vectors, sets, ranges, tuples and maps
   */

  // lists

  val aList = List(1, 2, 3, 4, 5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependList = 0 :: aList  // List(0, 1, 2, 3, 4, 5)
  val anExtendedList = 0 +: aList :+ 6  // List(0, 1, 2, 3, 4, 5, 6)

  // sequences
  val aSequence: Seq[Int] = Seq(1, 2, 3)  // Seq.apply(1, 2, 3)
  val accessedElement = aSequence(1)

  // vectors: fast Seq implementation
  val aVector = Vector(1, 2, 3, 4, 5)

  // sets = no duplicates
  val aSet = Set(1, 2, 3, 4, 1, 2, 3)   // Set(1, 2, 3, 4)
  val setHas5 = aSet.contains(10)    // false
  val anAddedSet = aSet + 5
  val aRemovedSet = aSet - 2

  // ranges
  val aRange = 1 to 100
  val byTwo = aRange.map(2 * _).toList  // List(2, 4, 6...., 100)
  println(byTwo.last)

  // tuples = groups of values under the same value
  val aTuple = ("Elvis", "Bon Jovi", "Frankie")

  // maps
  val aPhoneBook = Map(
    ("Ana", 972345672),
    "Alice" -> 656566787
  )
}



















