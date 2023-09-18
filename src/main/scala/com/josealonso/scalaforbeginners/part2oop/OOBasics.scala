package com.josealonso.scalaforbeginners.part2oop

object OOBasics extends App {

  val person = new Person("Alice", 35)
  println(person.age)
  println(person.x)
  person.greet("Alice2")
  person.greet()
  val person2 = new Person("John")
  person2.greet()

  val myWriter = new Writer("John", "Williams", 1970)
  val myNovel = new Novel("Living with cats", 2010, myWriter)
  println(myNovel.isWrittenBy(myWriter))
  val revisedNovel = myNovel.copy(2018)
  println(revisedNovel.isWrittenBy(myWriter))

  val counter = new Counter
  counter.increment.print
  counter.increment.increment.increment.print
  counter.increment(10).print
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

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName(): String = s"$firstName $surname"
}

class Novel(val name: String, val yearOfRelease: Int, val author: Writer) {
  def authorAge() = yearOfRelease - author.year

  def isWrittenBy(author: Writer) = author == this.author

  def copy(yearOfRelease: Int) = {
    new Novel(this.name, yearOfRelease, this.author)
  }

}

class Counter(val count: Int = 0) {
  def increment = {
    println("incrementing")
    new Counter(count + 1)  // immutability
  }
  def increment(n: Int): Counter = {
    if (n <= 0) this
//    else new Counter(n)   // This causes a stack overflow error
    else increment.increment(n-1)
  }
   def print = println(count)

}













