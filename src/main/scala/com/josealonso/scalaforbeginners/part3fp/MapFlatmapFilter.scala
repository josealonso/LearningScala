package com.josealonso.scalaforbeginners.part3fp

object MapFlatmapFilter extends App {

  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // print all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
  } yield "" + c + n
  println(forCombinations)

  for {   // This block is equivalent to the forEach method
    n <- numbers
  } println(n)

  numbers.foreach(n => println(n))
}
