package com.jama

case class RawUser(username: String, age: String)

/**************************************************/
case class User(person: Person, age: Int)
case class Person(first: String, last: String)
/**************************************************/
case class CalculationResult(success: Int, fails: Int)

object Main extends App {
  def calculate(rawUsers: Seq[RawUser]): CalculationResult = {
    rawUsers.map(parseSingle).map {
      case Right(value) => CalculationResult(1, 0)
      case Left(err) => CalculationResult(0, 1)
    }.reduce((a, b) => CalculationResult(a.success + b.success, a.fails + b.fails))
  }

  def parseSingle(raw: RawUser): Either[String, User] = {
    for {
      age <- Age.getAge(raw.age)
      person <- Person.getPerson(raw.username)
    } yield User (person, age)
  }

  println(
    calculate(RawData.generateData)
  )
}



object Age {
  def getAge(age: String): Either[String, Int] = age.toIntOption.toRight(s"Error during parsing $age")
}

object Person {
  def getPerson(username: String): Either[String, Person] = {
    username.split(' ') match {
      case array if array.length == 2 => Right(Person(array.head, array.last))
      case _ => Left(s"Error during parsing $username")
    }
  }
}
