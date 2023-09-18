package com.josealonso.scalaforbeginners.part2oop

object inheritanceAndTraits extends App {

  // single class inheritance
  class Animal {
    val creatureType = "wild"
//    protected def eat =  println("nomnom")
    def eat =  println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }
  val dog = new Dog("K5")
  dog.eat
  println(dog.creatureType)

  // type substitution (polymorphism)
  val anotherDog: Animal = new Dog("dalmata")
  anotherDog.eat

  // Overriding vs. overloading

  // super

  // preventing overrides:
  /*
  1.- use final on member
  2.- use final on the entire class
  3.- seal the class = extend classes in this file, prevent extension in other files.
   */
}
