package com.josealonso

object FunctionalProgramming extends App {
  // Scala is OO
  class Person(name: String) {
     def apply(age: Int) = println(s"I am $age years old")
  }

  val bob = new Person("bob")
  bob.apply(24)
  bob(24)  // invoking bob as a function is equivalent to bob.apply()

}
