scala> var m="Saiful Rahman"
var m: String = Saiful Rahman

scala> println(s"My name is $s")
                             ^
       error: not found: value s

scala> println(s"My name is $m")
My name is Saiful Rahman

scala> :paste
// Entering paste mode (ctrl-D to finish)

import scala.io.StdIn.readInt
var a=readInt()
var b=readInt()
var c=readInt()
println(s"a+b+c= ${a+b+c}")


// Exiting paste mode, now interpreting.

a+b+c= 99
import scala.io.StdIn.readInt
var a: Int = 34
var b: Int = 56
var c: Int = 9

scala> import scala.io.StdIn.readInt
import scala.io.StdIn.readInt

scala> var x=readInt("Enter the number")
                     ^
       error: no arguments allowed for nullary method readInt: (): Int

scala> :paste
// Entering paste mode (ctrl-D to finish)

import scala.io.StdIn.readInt
val pi=3.14159F
println(f"the value of is $pi%.2f")


// Exiting paste mode, now interpreting.

the value of is 3.14
import scala.io.StdIn.readInt
val pi: Float = 3.14159

scala> :paste
// Entering paste mode (ctrl-D to finish)

import scala.io.StdIn.readFloat
var y=readFloat()
println(f"the value of y is = $y%.3f")


// Exiting paste mode, now interpreting.

the value of y is = 89.321
import scala.io.StdIn.readFloat
var y: Float = 89.32144

scala> println("without raw:\nFirst\nsecond")
without raw:
First
second

scala> pritnln(raw"with raw:\nFrist\nsecond ${3+4}")
       ^
       error: not found: value pritnln

scala> println(raw"with raw:\nFrist\nsecond ${3+4}")
with raw:\nFrist\nsecond 7
