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

scala> graph.triplets.take(3).foreach(println)
((1,A),(2,B),1800)
((2,B),(3,C),800)
((3,C),(1,A),1400)

scala> val f=graph.inDegrees
val f: org.apache.spark.graphx.VertexRDD[Int] = VertexRDDImpl[27] at RDD at VertexRDD.scala:57

scala> f.collect()
val res5: Array[(org.apache.spark.graphx.VertexId, Int)] = Array((1,1), (2,1), (3,1))

scala> val fv=graph.outDegrees
val fv: org.apache.spark.graphx.VertexRDD[Int] = VertexRDDImpl[31] at RDD at VertexRDD.scala:57

scala> fv.collect()
val res6: Array[(org.apache.spark.graphx.VertexId, Int)] = Array((1,1), (2,1), (3,1))

scala> val totaldeg=graph.degrees
val totaldeg: org.apache.spark.graphx.VertexRDD[Int] = VertexRDDImpl[35] at RDD at VertexRDD.scala:57

scala> totaldeg.collect()
val res7: Array[(org.apache.spark.graphx.VertexId, Int)] = Array((1,2), (2,2), (3,2))

scala> val verti=Array((3L,("rxin","student")),(7L,("igonzal","postdoc")),(5L,("franklin","prof")),(2L,("isoica","prof")))
val verti: Array[(Long, (String, String))] = Array((3,(rxin,student)), (7,(igonzal,postdoc)), (5,(franklin,prof)), (2,(isoica,prof)))

scala> val ede=Array(Edge(3L,7L,"collab"),Edge(5L,3L,"advisor"),Edge(2L,5L,"colleague"),Edge(5L,7L,"pi"))
val ede: Array[org.apache.spark.graphx.Edge[String]] = Array(Edge(3,7,collab), Edge(5,3,advisor), Edge(2,5,colleague), Edge(5,7,pi))

scala> val v1rdd=sc.parallelize(verti)
warning: 1 deprecation (since 2.13.0); for details, enable `:setting -deprecation` or `:replay -deprecation`
val v1rdd: org.apache.spark.rdd.RDD[(Long, (String, String))] = ParallelCollectionRDD[36] at parallelize at <console>:1

scala> val e1rdd=sc.parallelize(ede)
warning: 1 deprecation (since 2.13.0); for details, enable `:setting -deprecation` or `:replay -deprecation`
val e1rdd: org.apache.spark.rdd.RDD[org.apache.spark.graphx.Edge[String]] = ParallelCollectionRDD[37] at parallelize at <console>:1

scala> val defaultu=("john doe","missing")
val defaultu: (String, String) = (john doe,missing)

scala> val graph1=Graph(v1rdd,e1rdd,defaultu)
val graph1: org.apache.spark.graphx.Graph[(String, String),String] = org.apache.spark.graphx.impl.GraphImpl@2b463d89

scala> graph1.vertices.filter{case (id,(name,pos))=>pos=="postdoc"}.count
warning: 1 deprecation (since 2.13.3); for details, enable `:setting -deprecation` or `:replay -deprecation`
val res8: Long = 1

scala> graph1.vertices.filter{case (id,(name,pos))=>pos=="prof"}.count
warning: 1 deprecation (since 2.13.3); for details, enable `:setting -deprecation` or `:replay -deprecation`
val res9: Long = 2

scala> graph1.edges.filter{case Edge(src,dst,prop)=>src>dst}.count
warning: 1 deprecation (since 2.13.3); for details, enable `:setting -deprecation` or `:replay -deprecation`
val res10: Long = 1

scala> graph1.edges.filter{e=>e.srcId>e.dstId).count
                                             ^
       error: ';' expected but ')' found.

scala> graph1.edges.filter(e=>e.srcId>e.dstId).count
warning: 1 deprecation (since 2.13.3); for details, enable `:setting -deprecation` or `:replay -deprecation`
val res11: Long = 1

scala> val rank=graph1.pageRank(0.0001).vertices
val rank: org.apache.spark.graphx.VertexRDD[Double] = VertexRDDImpl[911] at RDD at VertexRDD.scala:57

scala> println(rank.collect().mkString("\n"))
(2,0.5037267911816329)
(3,0.8997819807481918)
(5,0.9318945636860209)
(7,1.6645966643841548)                           
