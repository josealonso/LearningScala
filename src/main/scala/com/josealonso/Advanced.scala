package com.josealonso

object Advanced extends App {

  // lazy evaluation
  lazy val lazyValueWithSideEffect = {
    println("This is a lazy block")
    25
  }

  val eagerValue = lazyValueWithSideEffect + 1  // Nothing is printed if this line is commented
  // useful in infinite collections


}
