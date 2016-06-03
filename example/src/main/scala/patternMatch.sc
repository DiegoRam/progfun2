val f: String => String = {case "ping" => "pong"}

f("ping")
val fp: PartialFunction[String, String] = {case "ping" => "pong"}
val fp2: PartialFunction[String, String] = {case "ping" => "pong2"}
val fp3: PartialFunction[String, String] = {case "pong" => "hola"}
//(fp andThen fp2 orElse fp3)("ping")

def id: Int = 5



case class A(name: String, id: () => Int)

A("roly", id _)

def str(x: String) = x.toString

def concat(x: String, y: String)(block: (String, String) => String) = block(x,y)

val concatWithComnma = (concat _)(_: String, _: String)((a,b) => a + b)

concatWithComnma("1","2")

def sum(x: Int, y: Int): Int = x + y

sum(1,2)

val sumCurried = (sum _).curried
val sum10 = sum(_: Int, 10)

sumCurried(1)(2)

val plus1 = sumCurried(1)

plus1(4)