package com.jama.imperative

case class RawUser(username: String, age: String)

/**************************************************/
case class User(person: Person, age: Int)
case class Person(first: String, last: String)
/**************************************************/
case class CalculationResult(success: Int, fails: Int)

object Main extends App {

  var successCount = 0
  var failsCount = 0


  def calculate(rawUsers: Seq[RawUser]): CalculationResult = {
    synchronized {
      for (user <- rawUsers) {
        try {
          val age = Age.getAge(user.age)
          val person = Person.getPerson(user.username)
          User(person, age)
          successCount = successCount + 1
        } catch {
          case _@Exception => failsCount = failsCount + 1
        }
      }
      CalculationResult(successCount, failsCount)
    }
  }
}


object Age {

  case class WrongAgeException() extends RuntimeException

  def getAge(age: String): Int =
    try {
      Integer.parseInt(age)
    } catch {
      case _ @ Exception => throw WrongAgeException()
    }
}

object Person {
  case class WrongUsernameException() extends RuntimeException
  case class LotOfWordsException() extends RuntimeException

  def getPerson(username: String): Person = {
    try {
      val array = username.split(' ')
      if (array.length > 2) {
        throw LotOfWordsException()
      } else {
        Person(array.head, array.last)
      }
    } catch {
      case e @ Exception  => throw WrongUsernameException()
    }
  }
}
