package com.josealonso.scalaforbeginners.part3fp

object TuplesAndMaps extends App {

  // tuples = finite ordered "lists"
  val aTuple = (2, "hello")   // Tuple2[Int, String]

  println(aTuple._1)    // 2
  println(aTuple.copy(_2 = "Hola"))
  println(aTuple.swap)

  // Maps = keys -> values
  val aMap = Map()
  val phonebook = Map(("Alice", 22), "Bob" -> 33).withDefaultValue(-1)
  println(phonebook)

  println(phonebook.contains("Bob"))
  println(phonebook.contains("John"))

  // add a pairing
  val newPairing = "Matt" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // map, flatMap, filter
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys and mapValues are commonly used instead of the map, flatMap, filter functions
  // filterKeys
  println(phonebook.view.filterKeys(_.startsWith("A")).toMap)
  println(phonebook.view.filterKeys(x => x.startsWith("A")).toMap)  // equivalent
  // mapValues
  println(phonebook.view.mapValues(number => "093-" + number).toMap)

  // conversion to other collections
  println(phonebook.toList)
  println(List(("Alice", 245)).toMap)
  val names = List("Alice", "James", "Anne", "John", "Peter")
  println(names.groupBy(name => name.charAt(0)))  // This "groupBy" is very used in Spark
}
