package com.josealonso.scalaforbeginners.part2oop

object AbstractDataTypes extends App {

  abstract class Animal {
    val creatureType: String
    def eat
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat = println("crunch crunch")
  }

  trait Carnivore {
    def eat(animal: Animal)
    val preferredMeal = "fresh meat"
  }

  class Lion extends Animal with Carnivore {
    override val creatureType: String = "feline"
    override def eat: Unit = println("grgrgr")
    override def eat(animal: Animal): Unit = println(s"I'm a lion and I'm eating ${animal.creatureType}....")
  }

  val dog = new Dog
  val lion = new Lion
  lion.eat(dog)

  /*
  Traits vs. abstract classes (in Scala 2)
  1.- traits do not have constructor parameters
  2.- multiple traits may be inherited by the same class
  3.- traits for behavior, abstract classes for entities
   */
}












