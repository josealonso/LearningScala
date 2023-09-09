package com.josealonso

object PatternMatching extends App {
 val anInteger = 20
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  // Pattern Matching is an expression

  // Case class decomposition
  case class Person(name: String, age:Int)
  val alice = Person("Alice", 25)

  val personGreeting = alice match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old."
    case _ => "something else"
  }
  println(personGreeting)

  // deconstructing tuples
  val aTuple = ("Queen", "Rock")
  val bandDescription =aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre."
    case _ => "unknown band"
  }

  // decomposing lists
  val aList = List(1, 2, 3)
  val listDescription = aList match {
    case List(_, 2, _) => "List containing 2 on its second position"
    case _ => "unknown list"
  }

}
