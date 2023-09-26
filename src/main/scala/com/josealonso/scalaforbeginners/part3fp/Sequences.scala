package com.josealonso.scalaforbeginners.part3fp

import scala.util.Random

object Sequences extends App {

  // Seq
  val aSequence = Seq(1,3,2,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(7,5,6))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 until 10
  aRange.foreach(println)
  (1 to 10).foreach(x => println("Hola"))

  // lists
  val aList = List(1,2,3)
  val prepended = 42 +: aList :+ 50
  println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-[-"))

  /*
   ARRAYS
   */
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[String](3)
  threeElements.foreach(println)

  // mutation
  numbers(2) = 9  // syntax sugar for numbers.update(2, 9)
  println(numbers.mkString("-"))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers   // implicit conversion
  println(numbersSeq)

  // vectors: it is the default implementation for immutable sequences
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vector vs lists
  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random()
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tail
  // updating an element in the middle takes a long time
  println("With a list: " + getWriteTime(numbersList))
  // depth of the tree is small
  // needs to replace an entire 32-element chunk
  println("With a vector: " + getWriteTime(numbersVector))
  // CONCLUSION: a vector is much faster
}
