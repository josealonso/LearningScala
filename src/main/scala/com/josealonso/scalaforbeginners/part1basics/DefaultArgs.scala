package com.josealonso.scalaforbeginners.part1basics

object DefaultArgs extends App {

  // The second argument is (almost) always equals to 1
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n-1, n*acc)

  val fact10 = trFact(10, 1)

  // Named parameters allows to change the parameters order
  def greet(name: String = "Jose", age: Int = 25): String =
    s"Hi, I am $name and I am $age years old."

  println(greet(age = 32))

}


