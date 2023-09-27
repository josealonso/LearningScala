package com.josealonso.scalaforbeginners.part4pm

object PatternsEverywhere extends App {

  // Idea #1 => catches are actually MATCHES
  try {
    // code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }

  // Idea #2 => Generators are also based on PATTERN MATCHING
  val list = List(1,2,3,4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield 10 * x
  println(evenOnes)

  val tuples = List((1,2), (3,4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  print(filterTuples)
  // case classes, :: operators, ...

  // Idea #3 => Multiple value definitions based on PATTERN MATCHING
  val tuple = (1,2,3)
  val (a,b,c) = tuple
  println(b)

  val head :: tail = list
  println(head)
  println(tail)

  // Idea #4 => Partial functions are also based on PATTERN MATCHING
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
  }  // partial function literal

  // These two blocks are equivalent
  val mappedList2 = list.map { x => x match {
      case v if v % 2 == 0 => v + " is even"
      case 1 => "the one"
      case _ => "something else"
    }
  }
  println(mappedList)
  println(mappedList2)


}
