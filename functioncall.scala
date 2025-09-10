//calling function within function 
def square (x:Double)={x*x}
val result=square(5)
print(result)

def squareSum(x:Double, y:Double)={square(x)+square(y)}
val result = squareSum(2,5)
print(result)


scala> :paste
// Entering paste mode (ctrl-D to finish)

def factorial(n: Int): Int = {
  if (n == 1) {
    1
  } else {
    n * factorial(n - 1)
  }
}
println(factorial(5)) // Output: 120


// Exiting paste mode, now interpreting.

120
def factorial(n: Int): Int
