scala> import org.apache.spark._
import org.apache.spark._

scala> import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD

scala> import org.apache.spark.graphx._
import org.apache.spark.graphx._

scala> val vert=Array((1L,("A")),(2L,("B")),(3L,("C")))
val vert: Array[(Long, String)] = Array((1,A), (2,B), (3,C))

scala> val vrdd=sc.parallelize(vert)
warning: 1 deprecation (since 2.13.0); for details, enable `:setting -deprecation` or `:replay -deprecation`
val vrdd: org.apache.spark.rdd.RDD[(Long, String)] = ParallelCollectionRDD[0] at parallelize at <console>:1

scala> val ed=Array(Edge(1L,2L,1800),Edge(2L,3L,800),Edge(3L,1L,1400))
val ed: Array[org.apache.spark.graphx.Edge[Int]] = Array(Edge(1,2,1800), Edge(2,3,800), Edge(3,1,1400))

scala> val erdd=sc.parallelize(ed)
warning: 1 deprecation (since 2.13.0); for details, enable `:setting -deprecation` or `:replay -deprecation`
val erdd: org.apache.spark.rdd.RDD[org.apache.spark.graphx.Edge[Int]] = ParallelCollectionRDD[1] at parallelize at <console>:1

scala> erdd.take(2)
val res0: Array[org.apache.spark.graphx.Edge[Int]] = Array(Edge(1,2,1800), Edge(2,3,800))

scala> val now="now"
val now: String = now

scala> val graph=Graph(vrdd,erdd,now)
val graph: org.apache.spark.graphx.Graph[String,Int] = org.apache.spark.graphx.impl.GraphImpl@4ab317b6

scala> graph.vertices.collect.foreach(println)
warning: 1 deprecation (since 2.13.3); for details, enable `:setting -deprecation` or `:replay -deprecation`
(1,A)
(2,B)
(3,C)

scala> graph.edges.collect.foreach(println)
warning: 1 deprecation (since 2.13.3); for details, enable `:setting -deprecation` or `:replay -deprecation`
Edge(1,2,1800)
Edge(2,3,800)
Edge(3,1,1400)

scala> val numvert=graph.numVertices
val numvert: Long = 3

scala> val numvert=graph.numEdges
val numvert: Long = 3

scala> graph.edges.filter{case Edge(src,dst,prop)=>prop>1000}.collect.foreach(println)
warning: 1 deprecation (since 2.13.3); for details, enable `:setting -deprecation` or `:replay -deprecation`
Edge(1,2,1800)
Edge(3,1,1400)




