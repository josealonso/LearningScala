package com.josealonso.scalaforbeginners.part4pm

// Scala 3 adds "significant indentation"
object BracelessSyntax {

  // compact
  val anIfExpression_v3 =
    if (2 > 3) "bigger"
    else "smaller"

  // scala 3
  val anIfExpression_v4 =
    if 2 > 3 then
      "bigger"
    else
      "smaller"

  // scala 3 one-liner
  val anIfExpression_v5 = if 2 > 3 then "bigger" else "smaller"

  // for comprehensions
  val aForComprehension = for {
    n <- List(1,2,3)
    s <- List("black", "red")
  } yield s"$n$s"

  // scala 3
  val aForComprehension =
    for
      n <- List(1, 2, 3)
      s <- List("black", "red")
    yield s"$n$s"

  // the same for pattern matching blocks

  // methods without braces

  // class definition with significant indentation (same for traits, objects, enums, etc.)

  class Animal:  // compiler expects the body of Animal
    def eat(): Unit =
      println("I'm eating")
    end eat

  end Animal  // The "end" tokens are optional

  /*
    Significant indentation means strictly larger indentation,
    therefore do NOT mix tabs and spaces
   */
}

















