package com.josealonso.scalaforbeginners.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 30) {
    def likes(movie: String) = movie == favoriteMovie
    def isAlive = true
    def apply() = s"Hi, my name is $name and I like $favoriteMovie"

    //===================================================
    def +(nickname: String) = s"$name ( $nickname )"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def +(years: Int) = new Person(name, favoriteMovie, age+years)
    def learns(what: String) = s"$name learns $what"
    def learnsScala = learns("Scala")
    def apply(numOfTimes: Int) = s"$name watched $favoriteMovie $numOfTimes times"
  }

  val alice = new Person("Alice", "Gone with the wind")
  println(alice.likes("Gone with the wind"))
  println(alice likes "Gone with the wind")   // equivalent
  // infix or operator notation. It can be used where the function has only one parameter.

  println(1 + 2)
  println(1.+(2))
  // equivalent, because all operators are methods

  // prefix notation
  val x = -1
  val y = 1.unary_-  // equivalent
  // "unary_" prefix only works with - + ~ !

  // postfix notation --> only for methods without parameters
  alice.isAlive
  alice isAlive

  // apply
  println(alice.apply())
  println(alice())   // equivalent

  //=====================================================
  println(alice.+("the lover"))
  println(alice + "the lover")
  println((+alice).age)  // This extra parentheses pair is required
  println(alice learns("Scala"))
  println(alice learns "Scala")
  println(alice.apply(4))
  println(alice(4))

}
