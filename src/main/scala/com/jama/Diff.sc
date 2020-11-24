val o1: Option[Int] = Some(1)
val o2: Option[Int] = None

o1.map(v => v + 1).filter(v => v < 1000)
o2.map(v => v + 1).filter(v => v < 1000)

o1 match {
  case Some(value) => println("Success")
  case None => println("Fail")
}

o2 match {
  case Some(value) => println("Success")
  case None => println("Fail")
}

val e1: Either[String, Int] = Right(1)
val e2: Either[String, Int] = Left("Error during parsing")

e1.map(v => v + 1)
e2.map(v => v + 1)

e1 match {
  case Right(value) => println("Success")
  case Left(err) => println(err)
}
