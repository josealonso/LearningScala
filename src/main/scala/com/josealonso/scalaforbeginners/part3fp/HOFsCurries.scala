package com.josealonso.scalaforbeginners.part3fp

object HOFsCurries extends App {

  // function that applies an f function n times over a value x
  // nTimes(f, 3, x) = f(f(f(x)))
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => (x + 1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1) (f(x))

  println(nTimes(x => x+1, 10, 1))
  val plus10 = nTimesBetter(plusOne, 10)
  println(s"AAA: ${plus10(1)}")

  // curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)
  println(add3(10))
  println(superAdder(3)(10))

  // Currying = functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")

  println(standardFormat(Math.PI))
}
