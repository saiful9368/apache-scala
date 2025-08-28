scala> :paste
// Entering paste mode (ctrl-D to finish)

val seqCollection=Seq(2,3,4,5,6,7,8,9,9)
val result=seqCollection.apply(1)
println(result)


// Exiting paste mode, now interpreting.

3
val seqCollection: Seq[Int] = List(2, 3, 4, 5, 6, 7, 8, 9, 9)
val result: Int = 3

scala> //set

scala> :paste
// Entering paste mode (ctrl-D to finish)

val setCollection=Set("apple","Orange","grapes","Banana")
val result=setCollection.apply("Orange")
println(result)


// Exiting paste mode, now interpreting.

true
val setCollection: scala.collection.immutable.Set[String] = Set(apple, Orange, grapes, Banana)
val result: Boolean = true

scala> //Map

scala> val mapColl=Map(("a",97),("b",98),("c",99),("d",100))
val mapColl: scala.collection.immutable.Map[String,Int] = Map(a -> 97, b -> 98, c -> 99, d -> 100)

scala> val result=mapColl.apply("c")
val result: Int = 99

scala> // apply(a) in all three

scala> // in seq a is index and return value

scala> //in set a is value and return true and false

scala> //in map a in key and return value

scala> :paste
// Entering paste mode (ctrl-D to finish)

val seqq=Seq(2,3,4,5,6,67,7)
seqq.foreach(println)


// Exiting paste mode, now interpreting.

2
3
4
5
6
67
7
val seqq: Seq[Int] = List(2, 3, 4, 5, 6, 67, 7)

scala> :paste
// Entering paste mode (ctrl-D to finish)

val mapp=Map(("a",24),("b",25),("c",52),("d",43))
import scala.io.StdIn.readInt
val k=readInt()


// Exiting paste mode, now interpreting.

val mapp: scala.collection.immutable.Map[String,Int] = Map(a -> 24, b -> 25, c -> 52, d -> 43)
import scala.io.StdIn.readInt
val k: Int = 4



scala> :paste
// Entering paste mode (ctrl-D to finish)

import scala.io.StdIn.readLine
val mapp=Map(("a",24),("b",25),("c",52),("d",43))
val k=readLine()
val result = mapp.apply(k)
if(result%2==0){
println(k+" is even")}
else{
println(k+" is odd")}


// Exiting paste mode, now interpreting.

b is odd
import scala.io.StdIn.readLine
val mapp: scala.collection.immutable.Map[String,Int] = Map(a -> 24, b -> 25, c -> 52, d -> 43)
val k: String = b
val result: Int = 25
