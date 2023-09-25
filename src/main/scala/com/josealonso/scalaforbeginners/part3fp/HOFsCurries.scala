package com.josealonso.scalaforbeginners.part3fp

object HOFsCurries extends App {

  // function that applies an f function n times over a value x
  // nTimes(f, 3, x) = f(f(f(x)))
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => (x + 1)

  /*
    NOTE: we are losing the tail-recursion.
    When we talk about currying and this "better" function, we are referring to this version as "better"
    in terms of API design by "decoupling" the different parameters that go in this definition.
    In practice we often see this pattern, which is often used with functions that are extremely unlikely of risking SOs.
   */
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1) (f(x))

  println(nTimes(x => x+1, 10, 1))
  val plus10 = nTimesBetter(plusOne, 10)
  println(s"AAA: ${plus10(1)}")

  // curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)
  println(add3(10))
  println(superAdder(3)(10))

  // Currying = functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")

  println(standardFormat(Math.PI))

  abstract class MyList[+A] {
    def head: A
    def tail: MyList[A]
    def isEmpty: Boolean
    def printElements: String
    override def toString: String = "[" + printElements + "]"

    def forEach(f: A => Unit): Unit
    def sort(compare: (A, A) => Int): MyList[A]
    def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]
    def fold[B](start: B) (operator: (B, A) => B): B
  }

  case object Empty extends MyList[Nothing] {
    override def head: Nothing = throw new NoSuchElementException
    override def tail: Nothing = throw new NoSuchElementException
    override def isEmpty: Boolean = true

    override def forEach(f: Nothing => Unit): Unit = ()
    override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

    override def printElements: String = ""

    override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
      if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
      else Empty

    override def fold[B](start: B)(operator: (B, Nothing) => B): B = start
  }

  case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
    override def head: A = h
    override def tail: MyList[A] = t
    override def isEmpty: Boolean = false
    override def printElements =
      if (tail.isEmpty) "" + head
      else head + " " + tail.printElements // In Scala 3 a string interpolator must be used

    override def forEach(f: A => Unit): Unit = {
      f(h)
      t.forEach(f)
    }
    override def sort(compare: (A, A) => Int): MyList[A] = { // This f. is not tail recursive
      def insert(x: A, sortedList: MyList[A]): MyList[A] =
        if (sortedList.isEmpty) new Cons(x, Empty)
        else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
        else new Cons(sortedList.head, insert(x, sortedList.tail))

      val sortedTail = t.sort(compare)
      insert(h, sortedTail)
    }
    override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] =
      if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
      else new Cons(zip(head, list.head), tail.zipWith(list.tail, zip))

    /*
      [1,2,3].fold(0) (+) =
      = [2,3].fold(1) (+) =
      = [3].fold(3) (+) =
      = [].fold(6) (+) =
      = 6
     */
    override def fold[B](start: B)(operator: (B, A) => B): B =
      tail.fold(operator(start, head)) (operator)
  }
  /*
  EXERCISES
   */

  //  [1,2,3].forEach(x => println(x))
  val integersList: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  integersList.forEach(x => println(x))
  integersList.forEach(println)   // equivalent to the above line

  //  [1,2,3].sort((x,y) => y - x) => [3,2,1]
  println(integersList.sort((x, y) => y - x))

  //[1,2,3].zipWith([4,5,6], x * y) => [1*4, 2*5, 3*6] = [4,10,18]
  val stringsList: MyList[String] = new Cons("Hola", new Cons("mundo", new Cons("mundial", Empty)))
  println(integersList.zipWith[String, String](stringsList, _ + "-" + _))

  // [1,2,3].fold(0) (x,y) = 6
  println(integersList.fold(0) (_ + _))  // similar to "reduce"

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x, y)

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
//  (x, y) => f(x, y)
    (x, y) => f(x) (y)

  def compose[A,B,T](f: A => B, g: T => A): T => B =
    x => f(g(x))

  def andThen[A,B,C](f: A => B, g: B => C): A => C =
    x => g(f(x))

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)
  def add4 = superAdder2(4)
  println(add4(20))

  val simpleAdder = fromCurry(superAdder2)
  println(simpleAdder(4, 20))

  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3
  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)

  println(composed(5))  // (5*3)+2 = 17
  println(ordered(5))   // (5+2) * 3 = 21










}
