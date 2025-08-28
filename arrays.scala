var val1=new Array[String](3)
var val1: Array[String] = Array(null, null, null)

scala> val1(0)="red"

scala> val1(1)="blue"

scala> val1(2)="black"

scala> val1.foreach(println)
red
blue
black

scala> val arr1=Array.range(0,5)
val arr1: Array[Int] = Array(0, 1, 2, 3, 4)

scala> val arr2=Array.range(0,5,2)
val arr2: Array[Int] = Array(0, 2, 4)

scala> arr1.foreach(println)
0
1
2
3
4
