package com.josealonso.scalaforbeginners.part3fp

object WhatsAFunction extends  App {

  val adder2 = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  val adder = new ((Int, Int) => Int) {
    override def apply(a: Int, b: Int): Int = a + b
  }

  val result = adder(2, 3)
  println(s"Result: $result")

  // ALL SCALA FUNCTIONS ARE OBJECTS
  // function traits, up to 22 params

//  def superAdder(a: Int, b: Int): (Int) => Int = {
//    def myInnerFunction(b: Int): Int = a + b
//    myInnerFunction
//  }

  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  println(superAdder(3)(4))   // curried function
}
