package com.josealonso.scalaforbeginners.part2oop

abstract class MyList[+T] {
  def head: T
  def tail: MyList[T]
  def isEmpty: Boolean
  def add[B >: T](element: B): MyList[B]
//  protected def printElements: String
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: Nothing = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements = ""
}

class Cons[+A](h2: A, t2: MyList[A]) extends MyList[A] {
  override def head: A = h2
  override def tail: MyList[A] = t2
  override def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements =
    if (t2.isEmpty) "" + h2
    else h2 + " " + t2.printElements  // In Scala 3 a string interpolator must be used
}
// A, B are called type parameterss

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("hello", new Cons("Scala", new Cons("users", Empty)))
  println(listOfIntegers.toString)
  print(listOfStrings.toString)
}












