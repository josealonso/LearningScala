package com.josealonso.scalaforbeginners.part1basics

object BasicTour {

  def main(args: Array[String]): Unit = {
    val num1 = 3
    val num2 = 22

    val x = {    // Code Blocks are expressions
      val condition = num1 > num2
      if (condition) 42 else 0
    }

    // Expressions vs. instructions
    // Instructions are executed (think Java), expressions are evaluated.
    // Everything in Scala is a expression, except the definitions.

    println("Hola a todos")  // returns a Unit type, which is similar to Java's void
    // side effects: println, while, reassigning

    /*
    Functions
    */
    def aRepeatedText(text: String, n: Int): String = {
      if (n == 1) text
      else text + aRepeatedText(text, n-1)
    }
    println("Result: " + aRepeatedText("hola", 3))
    // When you need loops, use recursion

    def aBigFunction(a: Int) = {
      def aSmallerFunction(a: Int) = a + 2

      aSmallerFunction(5)
    }

    // Example functions

    def factorial(n: Int): Int = {
      if (n <= 0) 1
      else n * factorial(n-1)
    }
    val n = 4
    println(s"Factorial of $n: " + factorial(n))

    def fibonnaci(n: Int): Int = {
      if (n <= 2) 1
      else fibonnaci(n-1) + fibonnaci(n-2)
    }
    val n2 = 8
    println(s"Fibonacci of $n2: " + fibonnaci(n2))

    def isPrime(n: Int): Boolean = {
      def isPrimeUntil(t: Int): Boolean =
        if (t <= 1) true
        else n % t != 0 && isPrimeUntil(t-1)

        isPrimeUntil(n / 2)
    }
    println(isPrime(37))

  }
}
