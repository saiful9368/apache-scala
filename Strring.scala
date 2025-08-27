var var1="[1-5]+".r
var var2="12 67 93 48 51"
var var3=var1.findAllIn(var2)
var3.foreach(println)


// Exiting paste mode, now interpreting.

12
3
4
51
var var1: scala.util.matching.Regex = [1-5]+
var var2: String = 12 67 93 48 51
var var3: scala.util.matching.Regex.MatchIterator = <iterator>

var var1="[1-5]{2}+".r
var var2="12 67 93 48 51"
var var3=var1.findAllIn(var2)
var3.foreach(println)



// Exiting paste mode, now interpreting.

12
51
var var1: scala.util.matching.Regex = [1-5]{2}+
var var2: String = 12 67 93 48 51
var var3: scala.util.matching.Regex.MatchIterator = <iterator>

scala> :paste
// Entering paste mode (ctrl-D to finish)

var va1="8201530"
var va=va1.replaceFirst("[01]","x")
print(va)


// Exiting paste mode, now interpreting.

82x1530var va1: String = 8201530
var va: String = 82x1530

scala> :paste
// Entering paste mode (ctrl-D to finish)

var v1="H".r
var v2="Hello world"
var v3=v1.replaceFirstIn(v2,"J")
v3.foreach(println)


// Exiting paste mode, now interpreting.

J
e
l
l
o

w
o
r
l
d
var v1: scala.util.matching.Regex = H
var v2: String = Hello world
var v3: String = Jello world

scala>

scala> :paste
// Entering paste mode (ctrl-D to finish)

var v1 = "[a-z]+".r
var v2="dk79rx5c4lj2c8ge"
var replaced=v1.replaceAllIn(v2,"1")
println(replaced)


// Exiting paste mode, now interpreting.

179151412181
var v1: scala.util.matching.Regex = [a-z]+
var v2: String = dk79rx5c4lj2c8ge
var replaced: String = 179151412181




scala> :paste
// Entering paste mode (ctrl-D to finish)

val str1="This is scala"
val st2="Hello scala"
val st3="Hello scala"
val comp=str1.compareTo(st2)
val cmp=st2.compareTo(st3)
val a=st2.equals(st3)
val b="hello scala"
val c=b.equalsIgnoreCase(st3)
println(comp)
println(cmp)
println(a)
println(c)


// Exiting paste mode, now interpreting.

12
0
true
true
val str1: String = This is scala
val st2: String = Hello scala
val st3: String = Hello scala
val comp: Int = 12
val cmp: Int = 0
val a: Boolean = true
val b: String = hello scala
val c: Boolean = true
