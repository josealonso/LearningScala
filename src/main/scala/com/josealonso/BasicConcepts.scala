package com.josealonso

object BasicConcepts extends App {
  /*
   * EVALUATION
   */
  val x = 2

  def square(x: Int) = x * x  // The right hand side of a def definition is evaluated on each use.
  val y = square(x)   // y refers to 4, not square(2).
  // The right hand side of a val definition is evaluated at the point of the definition itself.
  // Afterwards, the name refers to the value.
  /*
    The scheme of expression evaluation is called the substitution model.
    The idea underlying this model is that all evaluation does is reduce an expression to a value.
    It can be applied to all expressions, as long as they have no side effects.

    The substitution model is formalized in the λ-calculus, which gives a foundation for functional programming.
   */
  def loop: Int = loop  // This definition is fine,
  def x2 = loop
  val y2 = loop   // but this line will lead to an infinite loop, since this evaluation does NOT terminate.
  println("Hi !!")

  /*
   EVALUATION STRATEGIES
   There are two: call-by-value and call-by-name.

    Both strategies reduce to the same final values as long as
    the reduced expression consists of pure functions, and both evaluations terminate.
    - Call-by-value has the advantage that it evaluates every function argument only once.

    - Call-by-name has the advantage that a function argument is not evaluated if the corresponding parameter
    is unused in the evaluation of the function body.

    Scala normally uses call-by-value.
  */

  // Recursive methods need an explicit return type in Scala.
  // For non-recursive methods, the return type is optional.
  def factorial(n: Int): Int =
    if (n == 1) 1
    else factorial(n - 1) * n

}
