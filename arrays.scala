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


scala> val c=Array.fill(2)("Hello")
val c: Array[String] = Array(Hello, Hello)

scala> val d="Hello".toArray
val d: Array[Char] = Array(H, e, l, l, o)

scala> var ar1=Array.range(0,11)
var ar1: Array[Int] = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

scala> var ar2=ar1.filter(_%2==0)
var ar2: Array[Int] = Array(0, 2, 4, 6, 8, 10)

scala> var ar3=ar2.map(_*2)
var ar3: Array[Int] = Array(0, 4, 8, 12, 16, 20)

scala> var ar4=ar3.reverse
var ar4: Array[Int] = Array(20, 16, 12, 8, 4, 0)
