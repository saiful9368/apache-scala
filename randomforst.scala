C:\Windows\System32>pyspark
Python 3.9.13 (tags/v3.9.13:6de2ca5, May 17 2022, 16:36:42) [MSC v.1929 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license" for more information.
Setting default log level to "WARN".
To adjust logging level use sc.setLogLevel(newLevel). For SparkR, use setLogLevel(newLevel).
Welcome to
      ____              __
     / __/__  ___ _____/ /__
    _\ \/ _ \/ _ `/ __/  '_/
   /__ / .__/\_,_/_/ /_/\_\   version 3.5.6
      /_/

Using Python version 3.9.13 (tags/v3.9.13:6de2ca5, May 17 2022 16:36:42)
Spark context Web UI available at http://10.35.162.87:4040
Spark context available as 'sc' (master = local[*], app id = local-1762929889099).
SparkSession available as 'spark'.
>>> df=spark.read("'C:\Users\HP\Downloads\iris.csv'",header=True, inferSchema=True)
  File "<stdin>", line 1
    df=spark.read("'C:\Users\HP\Downloads\iris.csv'",header=True, inferSchema=True)
                                                    ^
SyntaxError: (unicode error) 'unicodeescape' codec can't decode bytes in position 3-4: truncated \UXXXXXXXX escape
>>> df=spark.read("C:/Users/HP/Downloads/iris.csv",header=True, inferSchema=True)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
TypeError: 'DataFrameReader' object is not callable
>>> df=spark.read.csv("C:/Users/HP/Downloads/iris.csv",header=True, inferSchema=True)
>>> df.show(2)
+---+-------------+------------+-------------+------------+-----------+
| Id|SepalLengthCm|SepalWidthCm|PetalLengthCm|PetalWidthCm|    Species|
+---+-------------+------------+-------------+------------+-----------+
|  1|          5.1|         3.5|          1.4|         0.2|Iris-setosa|
|  2|          4.9|         3.0|          1.4|         0.2|Iris-setosa|
+---+-------------+------------+-------------+------------+-----------+
only showing top 2 rows

>>>
>>>
>>>
>>>
>>>
>>> from pyspark.sql import SparkSession
>>> from pyspark.ml.feature import VectorAssembler
>>> from pyspark.ml.feature import StringIndexer
>>> from pyspark.ml.classification import RandomForestClassifier
>>> from pyspark.ml.evaluation import MultiClassClassificationEvaluator
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
ImportError: cannot import name 'MultiClassClassificationEvaluator' from 'pyspark.ml.evaluation' (C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\ml\evaluation.py)
>>> from pyspark.ml.evaluation import MulticlassClassificationEvaluator
>>>
>>> vector_assembler=VectorAssembler(inputCols=df.columns[:-1],outputCol="features")
>>> df1=vector_assembler.transform(df)
>>> df1.show(2)
+---+-------------+------------+-------------+------------+-----------+--------------------+
| Id|SepalLengthCm|SepalWidthCm|PetalLengthCm|PetalWidthCm|    Species|            features|
+---+-------------+------------+-------------+------------+-----------+--------------------+
|  1|          5.1|         3.5|          1.4|         0.2|Iris-setosa|[1.0,5.1,3.5,1.4,...|
|  2|          4.9|         3.0|          1.4|         0.2|Iris-setosa|[2.0,4.9,3.0,1.4,...|
+---+-------------+------------+-------------+------------+-----------+--------------------+
only showing top 2 rows

>>> l_indexer=StringIndexer(inputCol="species",outputCol="labelIndex")
>>> df1=l_indexer.fit(df1).transform(df1)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\ml\base.py", line 205, in fit
    return self._fit(dataset)
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\ml\wrapper.py", line 381, in _fit
    java_model = self._fit_java(dataset)
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\ml\wrapper.py", line 378, in _fit_java
    return self._java_obj.fit(dataset._jdf)
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\lib\py4j-0.10.9.7-src.zip\py4j\java_gateway.py", line 1322, in __call__
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\errors\exceptions\captured.py", line 179, in deco
    return f(*a, **kw)
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\lib\py4j-0.10.9.7-src.zip\py4j\protocol.py", line 326, in get_return_value
py4j.protocol.Py4JJavaError: An error occurred while calling o61.fit.
: org.apache.spark.SparkException: Input column species does not exist.
        at org.apache.spark.ml.feature.StringIndexerBase.$anonfun$validateAndTransformSchema$2(StringIndexer.scala:128)
        at scala.collection.ArrayOps$.flatMap$extension(ArrayOps.scala:964)
        at org.apache.spark.ml.feature.StringIndexerBase.validateAndTransformSchema(StringIndexer.scala:123)
        at org.apache.spark.ml.feature.StringIndexerBase.validateAndTransformSchema$(StringIndexer.scala:115)
        at org.apache.spark.ml.feature.StringIndexer.validateAndTransformSchema(StringIndexer.scala:145)
        at org.apache.spark.ml.feature.StringIndexer.transformSchema(StringIndexer.scala:252)
        at org.apache.spark.ml.PipelineStage.transformSchema(Pipeline.scala:71)
        at org.apache.spark.ml.feature.StringIndexer.fit(StringIndexer.scala:237)
        at org.apache.spark.ml.feature.StringIndexer.fit(StringIndexer.scala:145)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at py4j.reflection.MethodInvoker.invoke(MethodInvoker.java:244)
        at py4j.reflection.ReflectionEngine.invoke(ReflectionEngine.java:374)
        at py4j.Gateway.invoke(Gateway.java:282)
        at py4j.commands.AbstractCommand.invokeMethod(AbstractCommand.java:132)
        at py4j.commands.CallCommand.execute(CallCommand.java:79)
        at py4j.ClientServerConnection.waitForCommands(ClientServerConnection.java:182)
        at py4j.ClientServerConnection.run(ClientServerConnection.java:106)
        at java.lang.Thread.run(Thread.java:748)

>>> df1.printSchema()
root
 |-- Id: integer (nullable = true)
 |-- SepalLengthCm: double (nullable = true)
 |-- SepalWidthCm: double (nullable = true)
 |-- PetalLengthCm: double (nullable = true)
 |-- PetalWidthCm: double (nullable = true)
 |-- Species: string (nullable = true)
 |-- features: vector (nullable = true)

>>> l_indexer=StringIndexer(inputCol="Species",outputCol="labelIndex")
>>> df1=l_indexer.fit(df1).transform(df1)
>>> df1.show(2)
+---+-------------+------------+-------------+------------+-----------+--------------------+----------+
| Id|SepalLengthCm|SepalWidthCm|PetalLengthCm|PetalWidthCm|    Species|            features|labelIndex|
+---+-------------+------------+-------------+------------+-----------+--------------------+----------+
|  1|          5.1|         3.5|          1.4|         0.2|Iris-setosa|[1.0,5.1,3.5,1.4,...|       0.0|
|  2|          4.9|         3.0|          1.4|         0.2|Iris-setosa|[2.0,4.9,3.0,1.4,...|       0.0|
+---+-------------+------------+-------------+------------+-----------+--------------------+----------+
only showing top 2 rows

>>> (trainingData, testData)=df1.randomSplit([0.7,0.3])
>>> rf=RandomForestClassifier(labelCol="labelIndex",featuresCol="features",numTrees=10)
>>> model=rf.fit(trainingData)
>>> predictions=model.transform(testData)
>>> predictions.show(2)
+---+-------------+------------+-------------+------------+-----------+--------------------+----------+--------------+-------------+----------+
| Id|SepalLengthCm|SepalWidthCm|PetalLengthCm|PetalWidthCm|    Species|            features|labelIndex| rawPrediction|  probability|prediction|
+---+-------------+------------+-------------+------------+-----------+--------------------+----------+--------------+-------------+----------+
|  4|          4.6|         3.1|          1.5|         0.2|Iris-setosa|[4.0,4.6,3.1,1.5,...|       0.0|[10.0,0.0,0.0]|[1.0,0.0,0.0]|       0.0|
|  5|          5.0|         3.6|          1.4|         0.2|Iris-setosa|[5.0,5.0,3.6,1.4,...|       0.0|[10.0,0.0,0.0]|[1.0,0.0,0.0]|       0.0|
+---+-------------+------------+-------------+------------+-----------+--------------------+----------+--------------+-------------+----------+
only showing top 2 rows

>>> predictions.select("predictions","labelIndex").show(2)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\sql\dataframe.py", line 3229, in select
    jdf = self._jdf.select(self._jcols(*cols))
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\lib\py4j-0.10.9.7-src.zip\py4j\java_gateway.py", line 1322, in __call__
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\errors\exceptions\captured.py", line 185, in deco
    raise converted from None
pyspark.errors.exceptions.captured.AnalysisException: [UNRESOLVED_COLUMN.WITH_SUGGESTION] A column or function parameter with name `predictions` cannot be resolved. Did you mean one of the following? [`prediction`, `rawPrediction`, `Species`, `features`, `Id`].;
'Project ['predictions, labelIndex#136]
+- Project [Id#17, SepalLengthCm#18, SepalWidthCm#19, PetalLengthCm#20, PetalWidthCm#21, Species#22, features#63, labelIndex#136, rawPrediction#294, probability#307, UDF(rawPrediction#294) AS prediction#324]
   +- Project [Id#17, SepalLengthCm#18, SepalWidthCm#19, PetalLengthCm#20, PetalWidthCm#21, Species#22, features#63, labelIndex#136, rawPrediction#294, UDF(rawPrediction#294) AS probability#307]
      +- Project [Id#17, SepalLengthCm#18, SepalWidthCm#19, PetalLengthCm#20, PetalWidthCm#21, Species#22, features#63, labelIndex#136, UDF(features#63) AS rawPrediction#294]
         +- Sample 0.7, 1.0, false, 2673564593945573188
            +- Sort [Id#17 ASC NULLS FIRST, SepalLengthCm#18 ASC NULLS FIRST, SepalWidthCm#19 ASC NULLS FIRST, PetalLengthCm#20 ASC NULLS FIRST, PetalWidthCm#21 ASC NULLS FIRST, Species#22 ASC NULLS FIRST, features#63 ASC NULLS FIRST, labelIndex#136 ASC NULLS FIRST], false
               +- Project [Id#17, SepalLengthCm#18, SepalWidthCm#19, PetalLengthCm#20, PetalWidthCm#21, Species#22, features#63, UDF(cast(Species#22 as string)) AS labelIndex#136]
                  +- Project [Id#17, SepalLengthCm#18, SepalWidthCm#19, PetalLengthCm#20, PetalWidthCm#21, Species#22, UDF(struct(Id_double_VectorAssembler_6a8e2ec16a9d, cast(Id#17 as double), SepalLengthCm, SepalLengthCm#18, SepalWidthCm, SepalWidthCm#19, PetalLengthCm, PetalLengthCm#20, PetalWidthCm, PetalWidthCm#21)) AS features#63]
                     +- Relation [Id#17,SepalLengthCm#18,SepalWidthCm#19,PetalLengthCm#20,PetalWidthCm#21,Species#22] csv

>>> predictions.select("prediction","labelIndex").show(2)
+----------+----------+
|prediction|labelIndex|
+----------+----------+
|       0.0|       0.0|
|       0.0|       0.0|
+----------+----------+
only showing top 2 rows

>>> evalutor=MulticlassClassificationEvalutor(labelCol="labelIndex",predictionCol="prediction",metricName="accurancy")
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
NameError: name 'MulticlassClassificationEvalutor' is not defined
>>> evalutor=MulticlassClassificationEvaluator(labelCol="labelIndex",predictionCol="prediction",metricName="accurancy")
>>> accuracy=evalutor.evaluate(predictions)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\ml\evaluation.py", line 111, in evaluate
    return self._evaluate(dataset)
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\ml\evaluation.py", line 146, in _evaluate
    self._transfer_params_to_java()
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\ml\wrapper.py", line 171, in _transfer_params_to_java
    pair = self._make_java_param_pair(param, self._paramMap[param])
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\ml\wrapper.py", line 160, in _make_java_param_pair
    return java_param.w(java_value)
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\lib\py4j-0.10.9.7-src.zip\py4j\java_gateway.py", line 1322, in __call__
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\errors\exceptions\captured.py", line 185, in deco
    raise converted from None
pyspark.errors.exceptions.captured.IllegalArgumentException: MulticlassClassificationEvaluator_f7ade3fad359 parameter metricName given invalid value accurancy.
>>> accuracy=evaluator.evaluate(predictions)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
NameError: name 'evaluator' is not defined
>>> accuracy=evalutor.evaluate(predictions)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\ml\evaluation.py", line 111, in evaluate
    return self._evaluate(dataset)
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\ml\evaluation.py", line 146, in _evaluate
    self._transfer_params_to_java()
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\ml\wrapper.py", line 171, in _transfer_params_to_java
    pair = self._make_java_param_pair(param, self._paramMap[param])
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\ml\wrapper.py", line 160, in _make_java_param_pair
    return java_param.w(java_value)
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\lib\py4j-0.10.9.7-src.zip\py4j\java_gateway.py", line 1322, in __call__
  File "C:\spark\spark-3.5.6-bin-hadoop3-scala2.13\python\pyspark\errors\exceptions\captured.py", line 185, in deco
    raise converted from None
pyspark.errors.exceptions.captured.IllegalArgumentException: MulticlassClassificationEvaluator_f7ade3fad359 parameter metricName given invalid value accurancy.
>>> evaluator = MulticlassClassificationEvaluator(
...     labelCol="labelIndex",
...     predictionCol="prediction",
...     metricName="accuracy"
... )
>>> accuracy = evaluator.evaluate(predictions)
>>> print(accuracy)
1.0
>>>


