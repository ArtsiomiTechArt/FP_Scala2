package com.jama.ready

/*
import cats.implicits._

import com.jama.RawData

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}

case class RawUser(username: String, age: String)

case class Person(name: String, surname: String)

case class User(person: Person, age: Int)

case class CalculationResult(success: Int, fails: Int)

object Ready extends App {


  @tailrec
  def getResultRec(list: Seq[Either[String, User]], calculationResult: CalculationResult): CalculationResult = {
    list match {
      case Nil => calculationResult
      case x :: xs => x match {
        case Right(_) => getResultRec(xs, CalculationResult(calculationResult.success + 1, calculationResult.fails))
        case Left(_) => getResultRec(xs, CalculationResult(calculationResult.success, calculationResult.fails + 1))
      }
    }
  }

  def calculate(rawUsers: Seq[RawUser]): CalculationResult = {
    val out: Seq[Either[String, User]] = rawUsers.map {
      user => (Person.getPerson(user.username), Age.getAge(user.age)).mapN(User)
    }

    getResultRec(out, CalculationResult(0, 0))
  }

  println(calculate(RawData.generateData))

}

object Age {
  def getAge(age: String): Either[String, Int] = age.toIntOption.toRight(s"Error during parsing value = $age")
}

object Person {
  def getPerson(username: String): Either[String, Person] =
    Try(username.split(' ')) match {
      case Success(list) if list.length == 2 => Right(Person(list.head, list.last))
      case Success(_) => Left(s"Error during parsing $username")
      case Failure(error) => Left(error.getMessage)
    }
}



 */
