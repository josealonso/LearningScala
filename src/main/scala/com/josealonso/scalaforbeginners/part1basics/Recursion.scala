package com.josealonso.scalaforbeginners.part1basics

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println(s"Computing factorial of $n. I first need factorial of ${n-1}")
      val result = n * factorial(n-1)
      println(s"Computing factorial of $n")
      result
    }

  val n = 4
  println(s"Factorial of $n: " + factorial(n))

  // The factorial written as a tail recursive function
  def anotherFactorial(n: Int): BigInt = {
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x-1, x * accumulator)

    factHelper(n, 1)
  }

}
