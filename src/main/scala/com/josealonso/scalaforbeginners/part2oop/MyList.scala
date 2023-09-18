package com.josealonso.scalaforbeginners.part2oop

abstract class MyList {
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
//  protected def printElements: String
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  override def head: Int = throw new NoSuchElementException
  override def tail: MyList = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add(element: Int): MyList = new Cons(element, Empty)
  def printElements = ""
}

class Cons(h2: Int, t2: MyList) extends MyList {
  override def head: Int = h2
  override def tail: MyList = t2
  override def isEmpty: Boolean = false
  override def add(element: Int): MyList = new Cons(element, this)
  def printElements =
//    var elementsList = new StringBuilder(this.head)
//    while (this.tail != Empty) {
//      elementsList.append(this.tail.head)
//    }
//    println(s"List: $elementsList")
    if (t2.isEmpty) "" + h2
    else h2 + " " + t2.printElements  // In Scala 3 a string interpolator must be used
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)     // prints 4
  println(list.isEmpty)
  println(list.printElements)
  println(list.toString)
}












