package com.josealonso.scalaforbeginners.part1basics

object StringOps extends App {

  val str = "Hello everyone"

  /*
  Java functions
   */
  println(str.charAt(2))
  println(str.substring(7, 11))
  print(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  /*
   Scala-specific functions
   */
  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println("Concatenation: " +: 'a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // S-interpolators
  val name = "Alice"
  val greeting = s"Hello, ny name is ${name.toUpperCase()}"
  // F-interpolators, like Java's printf
  val speed = 120.2
  val speedSentence = f"My car maximum speed is $speed%2.2f km/h"
  println(speedSentence)
  // raw-interpolators
  println(raw"This is a \n newline")   // backlash is not escaped
}
