scala> //LIST

scala> val lst=List.range(1,10)
val lst: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

scala> //list is immutable collection

scala> var mlist=List.fill(3)("ABC")
var mlist: List[String] = List(ABC, ABC, ABC)

scala> mlist.foreach(prinltn)
                     ^
       error: not found: value prinltn

scala> mlist.foreach(println)
ABC
ABC
ABC

scala> val list1="a"::"b"::"c"::"d"::"e"::Nil
val list1: List[String] = List(a, b, c, d, e)

scala> val list2=list1:+"p"
val list2: List[String] = List(a, b, c, d, e, p)

scala> val list3="f"::list2
val list3: List[String] = List(f, a, b, c, d, e, p)

scala> // add eleemt at head "f"::list2

scala> val getHead=list3.head
val getHead: String = f

scala> val getHead=list3.tail
val getHead: List[String] = List(a, b, c, d, e, p)

scala> //Lazy List

scala> val lst1=LazyList.from(1 to 1000000)
val lst1: scala.collection.immutable.LazyList[Int] = LazyList(<not computed>)

scala> :paste
// Entering paste mode (ctrl-D to finish)



// Nothing pasted, nothing gained.


scala> val lst1=LazyList.from(1 to 1000)
val lst1: scala.collection.immutable.LazyList[Int] = LazyList(<not computed>)

scala> val lst1=LazyList.from(1 to 100)
val lst1: scala.collection.immutable.LazyList[Int] = LazyList(<not computed>)
