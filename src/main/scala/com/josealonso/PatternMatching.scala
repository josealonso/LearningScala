package com.josealonso

object PatternMatching extends App {
 val anInteger = 20
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  // Pattern Matching is an expression
}
