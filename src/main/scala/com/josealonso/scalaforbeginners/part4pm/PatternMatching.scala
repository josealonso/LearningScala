package com.josealonso.scalaforbeginners.part4pm

import scala.util.Random

object PatternMatching extends App {

  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "one"
    case 2 => "two"
    case 3 => "three"
    case _ => "something else"    // _ = wildcard
  }

  println(x)
  println(description)

  // 1.- Decompose values
  case class Person(name: String, age: Int)
  val alice = Person("Alice", 25)

  val greetings = alice match {
    case Person(n, a) if a < 30 => s"Hi, my name is $n and I am in my twenties."
    case Person(n, a) => s"Hi, my name is $n and I am $a years old."
    case _ => "........."
  }
  println(greetings)

  /*
    1. cases are matched in order
    2. what if no cases match ? MatchError
    3. type of the PM expression ? unified type of all the types in all the cases
    4. PM works really well with case classes
   */

  // 2.- PM on sealed hierarchies
  sealed class Animal
  case class Dog(greeting: String) extends Animal
  case class Cat(greeting: String) extends Animal

  val animal: Animal = Dog("bark")
  animal match {
    case Dog(greeting2) => println(s"It is a dog that says $greeting2")
  }    // warning: match may not be exhaustive

  // PM abusing
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  /*
    Exercise
   */
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(el: Expr, e2: Expr) extends Expr
  case class Prod(el: Expr, e2: Expr) extends Expr

  // takes an Expr => human readable form
  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => {
      def maybeShowParentheses(exp: Expr) = exp match {
        case Prod(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }

      maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
    }
  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(1)), Sum(Number(3), Number(4)))))
}













