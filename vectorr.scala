scala> //vector

scala> //:+ for append

scala> //+: prepend

scala> //++ vector concatenation

scala> val vct1=Vector(1,2,3,4,5)
val vct1: scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4, 5)

scala> val vct2=Vector.empty //initializa empty vector
val vct2: scala.collection.immutable.Vector[Nothing] = Vector()

scala> val vdt3=Vector("a","b","c","d")    //same syntax for ArrayBuffer(),Array(),List()
val vdt3: scala.collection.immutable.Vector[String] = Vector(a, b, c, d)

scala> val vct4=vct1:+6
val vct4: scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4, 5, 6)

scala> val vct5="Z"+:vdt3
val vct5: scala.collection.immutable.Vector[String] = Vector(Z, a, b, c, d)

scala> vct.foreach(println)
       ^
       error: not found: value vct

scala> vct5.foreach(println)
Z
a
b
c
d

scala> val vct6=vct1++vct5
val vct6: scala.collection.immutable.Vector[Any] = Vector(1, 2, 3, 4, 5, Z, a, b, c, d)
