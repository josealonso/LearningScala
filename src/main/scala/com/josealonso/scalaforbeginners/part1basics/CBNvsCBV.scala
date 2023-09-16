package com.josealonso.scalaforbeginners.part1basics

object CBNvsCBV extends App {

  // When called by value, the expression is computed before the function is called.
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // When called by name, the expression is evaluated every time the function is called.
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

}
