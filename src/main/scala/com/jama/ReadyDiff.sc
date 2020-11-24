import cats.implicits._

import scala.annotation.tailrec

val a1: Option[Int] = Some(1)
val a2: Option[Int] = None

a1 match {
  case Some(value) => println("There is a value")
  case None => println("None is here")
}

a2 match {
  case Some(value) => println("There is a value")
  case None => println("None is here")
}

println(
  a1.map(value => value + 1).filter(_ > 1)
)
println(
  a2.map(value => value + 1).filter(_ > 1)
)


val e1: Either[String, Int] = Right(5)
val e3: Either[String, Int] = Right(7)
val e2: Either[String, Int] = Left("Error 1")
val e4: Either[String, Int] = Left("Error 2")


println(
  e1.map(value => value + 1).filterOrElse(_ > 60, "Should be <=60")
)
println(
  e2.map(value => value + 1)
)


e1 |+| e2

e1 |+| e3

e4 |+| e2


//@tailrec
def fib(i: Int): Int =  {
  if (i == 0) i
  else if(i == 1) i
  else fib(i - 1) + fib(i - 2)
}

@tailrec
def fibTail(i: Int, res: Int = 0): Int = {
  if (i == 0) res
  else (fibTail(i - 1, res + i))

}
