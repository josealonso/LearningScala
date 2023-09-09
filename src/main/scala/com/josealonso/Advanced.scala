package com.josealonso

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import  scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {

  /**
   * lazy evaluation
   */
  lazy val lazyValueWithSideEffect = {
    println("This is a lazy block")
    25
  }

  val eagerValue = lazyValueWithSideEffect + 1  // Nothing is printed if this line is commented
  // useful in infinite collections

  /**
   *  pseudo-collections: Option, Try
   */
  def methodWhichCanReturnNull() = "Hello, Scala"
  val anOption = Option(methodWhichCanReturnNull())  // Some(value) or None
  // option = "collection" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }
  // map, flatMap, filter

  def methodWhichCanThrowException(): String = throw new RuntimeException
  val aTry = Try(methodWhichCanThrowException())
  // a try = "collection" with either a value if the code went well, or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(value) => s"I have obtained a valid string: $value"
    case Failure(ex) =>  s"I have obtained an exception: $ex"
  }
  // map, flatMap, filter

  /**
   * Evaluates something on another thread
   * (asynchronous programming)
   */
  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1200)
    println("I have computed a value.")
    65
  }
  // future is a "collection" which contains a value when it's evaluated
  // future is composable with map, flatMap and filter

  // The Future, Try and Option types are called monads

}















