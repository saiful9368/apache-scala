scala> :paste
// Entering paste mode (ctrl-D to finish)

import scala.collection.mutable.ArrayBuffer
var myy_arraybuff=new ArrayBuffer[Int]()
myy_arraybuff+=6
myy_arraybuff+=15
myy_arraybuff+=78
myy_arraybuff+=4
myy_arraybuff.foreach(println)


// Exiting paste mode, now interpreting.

6
15
78
4
import scala.collection.mutable.ArrayBuffer
var myy_arraybuff: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(6, 15, 78, 4)

scala> //+= to add element at last

scala> //-= to remove element from last

scala> // .remove(index) to remove the element from index

scala> // .clear() to clear whole array

scala>

scala> :paste
// Entering paste mode (ctrl-D to finish)

import scala.collection.mutable.ArrayBuffer
var myy_arraybuff=new ArrayBuffer[Int]()
myy_arraybuff+=6
myy_arraybuff+=15
myy_arraybuff+=78
myy_arraybuff+=4
myy_arraybuff.foreach(println)
myy_arraybuff-=4
myy_arraybuff.foreach(println)


// Exiting paste mode, now interpreting.

6
15
78
4
6
15
78
import scala.collection.mutable.ArrayBuffer
var myy_arraybuff: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(6, 15, 78)
