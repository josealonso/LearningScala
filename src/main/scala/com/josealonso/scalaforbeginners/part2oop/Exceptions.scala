package com.josealonso.scalaforbeginners.part2oop

object Exceptions extends App {

  // How to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  // throw exception

  // Crash your program with an OutOfMemoryError
  // val array = Array.ofDim(Int.MaxValue)
  // Crash your program with an StackOverflowError
  def infinite: Int = 1 + infinite
  // val noLimit = infinite

  /*
    Calculator
   */
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object Calculator {
    def add(x: Int, y: Int) = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def substract(x: Int, y: Int) = {
      val result = x - y

      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }

  }

  println(Calculator.divide(2, 0))  // causes a MathCalculationException
}
