package com.josealonso.scalaforbeginners.part2oop

object Objects extends App {

  // Scala does not have class-level functionality (Java's "static")
  // Scala is more OO than Java.
  object Person {
    val N_EYES = 2
    def canFly = false

    // factory methods
    def apply(mother: Person, father: Person) = new Person("child2")
  }
  class Person(val name:String) {
    // instance-level functionality
  }
  // COMPANION: the design pattern of having an object and a class with the same name
  // under the same scope.

  print(Person.N_EYES)
  println(Person.canFly)

  // Scala object = Singleton instance. An object is also a type.
  val alice = new Person("Alice")
  val bob = new Person("Bob")

  val person1 = Person
  val person2 = Person
  person1 == person2  // This will always be true

  val littleBob = Person(alice, bob)  // It seems a constructor, but it is the apply method

}
