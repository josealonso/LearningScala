package com.josealonso.scalaforbeginners.part2oop

object OOBasics extends App {

  val person = new Person("Alice", 35)
  println(person.age)
  println(person.x)
  person.greet("Alice2")
  person.greet()
  val person2 = new Person("John")
  person2.greet()
}

// constructor
class Person(name: String, val age: Int = 25) {
  /*
   BODY
   */
  val x = 2  // this is a Person field.

  println(1 + 3)

  // methods
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name and I am $age years old.")

  // multiple constructors
  //  def this(name: String) = this(name, 0)   // better too use default arguments in the constructor
}
// class parameters are not fields. They have to be prepended with "val"