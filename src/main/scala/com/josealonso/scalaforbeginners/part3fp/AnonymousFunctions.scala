package com.josealonso.scalaforbeginners.part3fp

object AnonymousFunctions extends App {

  val doubler: Int => Int = x => x * 2

  // multiple params
  val adder: (Int, Int) => Int = (x, y) => x + y

  // no params
  val doSomething: () => Int = () => 3

  // be careful with the parentheses
  println(doSomething)    // function itself
  println(doSomething())  // call

  // curly braces with lambdas
  val sringToInt = { (str: String) =>
    str.toInt
  }

  // more syntactic sugar
  val adder2: (Int, Int) => Int = _ + _  // useful notation in HOF calls

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))
}
