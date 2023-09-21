package com.josealonso.scalaforbeginners.part2oop

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
//  protected def printElements: String
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: Nothing = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements = ""

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h2: A, t2: MyList[A]) extends MyList[A] {
  override def head: A = h2
  override def tail: MyList[A] = t2
  override def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements =
    if (t2.isEmpty) "" + h2
    else h2 + " " + t2.printElements  // In Scala 3 a string interpolator must be used

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(head), tail.map(transformer))
  }
  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(head) ++ tail.flatMap(transformer)
  override def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(head)) new Cons(head, tail.filter(predicate))
    else tail.filter(predicate)

  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(head, tail ++ list)
}

trait MyPredicate[-T] {
  def test(predicate: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, new Cons(6, Empty)))
  val listOfStrings: MyList[String] = new Cons("hello", new Cons("Scala", new Cons("users", Empty)))
  println(listOfIntegers.toString)
  println(listOfStrings.toString)
  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)
  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(predicate: Int): Boolean = predicate % 2 == 0
  }).toString)
  println(listOfIntegers ++ anotherListOfIntegers).toString
  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem+1, Empty))
  }).toString)

}












