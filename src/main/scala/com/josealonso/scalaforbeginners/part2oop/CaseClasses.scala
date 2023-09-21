package com.josealonso.scalaforbeginners.part2oop

object CaseClasses extends App {

  /*
    equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // 1.- class param are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2.- sensible toString
  // println(instance) = println(instance.toString)  // syntactic sugar
  println(jim)

  // 3.- equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)  // true

  // 4.- handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5.- companion objects
  val thePerson = Person
  val alice = Person("Mary", 23)

  // 6.- They are serializable
  // Widely used in Akka

  // 7.- They have extractor patterns. This is related to pattern matching.

  case object Animal {
    def name: String = "......."
  }


}
