package com.josealonso

import scala.annotation.tailrec

object TailRecursion extends App {

  def factorial1(n: Int): Int =
    if (n == 0) 1 else n * factorial1(n - 1)

  /* factorial(4) is evaluated as follows:

  factorial(4)
  if (4 == 0) 1 else 4 * factorial(4 - 1)
  4 * factorial(3)
  4 * (3 * factorial(2))
  4 * (3 * (2 * factorial(1)))
  4 * (3 * (2 * (1 * factorial(0)))
  4 * (3 * (2 * (1 * 1)))
  24
  */

  /*
  If you have a recursive function that calls itself as its last action, then you can reuse the stack frame of that function.
  This is called tail recursion.

  A tail recursive function can execute in constant stack space, so it's really just
  another formulation of an iterative process. We could say a tail recursive function is the functional form of a loop,
  and it executes just as efficiently as a loop.
  */

  // Let's write the tail-recursive version of factorial
  def factorial(n: Int): Int = {
    @tailrec
    def iter(x: Int, result: Int): Int =
      if (x == 1) result
      else iter(x - 1, result * x)

    iter(n, 1)
  }

  val n = 4
  println(s"Factorial of $n: " + factorial(n).toString)
}
