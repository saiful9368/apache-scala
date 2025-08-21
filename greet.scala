import scala.io.StdIn._
var name=readLine()
def greet(a:Int):String={
if(a<=19){
return "You are a teenager"
}else if(a>19 & a<60){
return "You are a adult"
}else{
return "you are a senior"
}}
var a=readInt()
println(s"Hello $name ,"+greet(a))


scala> val splitpizza="Pizza Dough, Tomato sauce, Cheese, Topping of choice".split(",")
val splitpizza: Array[String] = Array(Pizza Dough, " Tomato sauce", " Cheese", " Topping of choice")

scala> splitPizza.foreach(println)
       ^
       error: not found: value splitPizza

scala> splitpizza.foreach(println)
Pizza Dough
 Tomato sauce
 Cheese
 Topping of choice
