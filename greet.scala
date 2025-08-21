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
