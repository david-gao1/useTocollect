#Getting Started

##Starting Point: SparkSession

```html
sqpark所有功能的入口点是SparkSession
使用SparkSession.builder() 创建一个基础的SparkSession
```

```html
The entry point into all functionality in Spark is the SparkSession class. 
To create a basic SparkSession, just use SparkSession.builder():
```
```scala
import org.apache.spark.sql.SparkSession

val spark = SparkSession
  .builder()
  .appName("Spark SQL basic example")
  .config("spark.some.config.option", "some-value")
  .getOrCreate()

// For implicit conversions like converting RDDs to DataFrames
import spark.implicits._
```
```html
Spark 2.0中的SparkSession提供了对Hive特性的内置支持，
包括使用HiveQL编写查询的能力、对Hive udf的访问以及从Hive表读取数据的能力。
要使用这些特性，您不需要现有的Hive设置。
```

```html
Find full example code at 
"examples/src/main/scala/org/apache/spark/examples/sql/SparkSQLExample.scala" in the Spark repo.
SparkSession in Spark 2.0 provides builtin support for Hive features 
including the ability to write queries using HiveQL, access to Hive UDFs, 
and the ability to read data from Hive tables. 
To use these features, you do not need to have an existing Hive setup.
```



##Creating DataFrames
```html
通过SparkSession可以从一个rdd，hive或是spark数据源创建DataFrames
下面的例子是从json file中创建DataFrame
```
```html
With a SparkSession, applications can create DataFrames from an existing RDD, 
from a Hive table, or from Spark data sources.
As an example, the following creates a DataFrame based on the content of a JSON file:
```
```shell script
val df = spark.read.json("examples/src/main/resources/people.json")

// Displays the content of the DataFrame to stdout
df.show()
// +----+-------+
// | age|   name|
// +----+-------+
// |null|Michael|
// |  30|   Andy|
// |  19| Justin|
// +----+-------+
```
```html
Find full example code at "examples/src/main/scala/org/apache/spark/examples/sql/SparkSQLExample.scala" in the Spark repo.
```


##Untyped Dataset Operations (aka DataFrame Operations)
非类型化的数据操作(又名dataframe操作)

```html
DataFrames provide a domain-specific language for structured data manipulation in Scala, Java, Python and R.
As mentioned above, in Spark 2.0, DataFrames are just Dataset of Rows in Scala and Java API. 
These operations are also referred as “untyped transformations” in contrast to “typed transformations” come with strongly typed Scala/Java Datasets.
Here we include some basic examples of structured data processing using Datasets:
```
```html
在spark 2.0 中，DataFrames是Dataset的行
这些操作称为无类型化的操作
```
```shell script
// This import is needed to use the $-notation
import spark.implicits._
// Print the schema in a tree format
df.printSchema()
// root
// |-- age: long (nullable = true)
// |-- name: string (nullable = true)

// Select only the "name" column
df.select("name").show()
// +-------+
// |   name|
// +-------+
// |Michael|
// |   Andy|
// | Justin|
// +-------+

// Select everybody, but increment the age by 1
df.select($"name", $"age" + 1).show()
// +-------+---------+
// |   name|(age + 1)|
// +-------+---------+
// |Michael|     null|
// |   Andy|       31|
// | Justin|       20|
// +-------+---------+

// Select people older than 21
df.filter($"age" > 21).show()
// +---+----+
// |age|name|
// +---+----+
// | 30|Andy|
// +---+----+

// Count people by age
df.groupBy("age").count().show()
// +----+-----+
// | age|count|
// +----+-----+
// |  19|    1|
// |null|    1|
// |  30|    1|
// +----+-----+
```

```html
Find full example code at "examples/src/main/scala/org/apache/spark/examples/sql/SparkSQLExample.scala" in the Spark repo.
For a complete list of the types of operations that can be performed on a Dataset, refer to the API Documentation.
In addition to simple column references and expressions, 
Datasets also have a rich library of functions including string manipulation, date arithmetic, common math operations and more. 
The complete list is available in the DataFrame Function Reference.
```



##Running SQL Queries Programmatically
```html
以编程的方式运行sql查询
SparkSession可以通过编程的方式执行sql并以DataFrame的形式返回。
```
```html
The sql function on a SparkSession enables applications to run SQL queries programmatically and returns the result as a DataFrame.
```
```shell script
// Register the DataFrame as a SQL temporary view
df.createOrReplaceTempView("people")

val sqlDF = spark.sql("SELECT * FROM people")
sqlDF.show()
// +----+-------+
// | age|   name|
// +----+-------+
// |null|Michael|
// |  30|   Andy|
// |  19| Justin|
// +----+-------+
```

```html
Find full example code at "examples/src/main/scala/org/apache/spark/examples/sql/SparkSQLExample.scala" in the Spark repo.
```


##Global Temporary View
```html
全局临时视图
Spark sql中的临时视图时会话范围的，如果创建它的会话消失，视图也会消失。
可以创建一个全局的临时会话，用来分享到所有的session，直到spark应用结束的时候才会终止。
全局的临时会话存储在global_temp数据库中。
必须使用类似于global_temp.people的限定名来引用它
```
```html
Temporary views in Spark SQL are session-scoped and will disappear if the session that creates it terminates. 
If you want to have a temporary view that is shared among all sessions and keep alive until the Spark application terminates, 
you can create a global temporary view. 
Global temporary view is tied to a system preserved database global_temp, 
and we must use the qualified name to refer it, e.g. SELECT * FROM global_temp.view1.
```
```shell script
// Register the DataFrame as a global temporary view
df.createGlobalTempView("people")

// Global temporary view is tied to a system preserved database `global_temp`
spark.sql("SELECT * FROM global_temp.people").show()
// +----+-------+
// | age|   name|
// +----+-------+
// |null|Michael|
// |  30|   Andy|
// |  19| Justin|
// +----+-------+

// Global temporary view is cross-session
spark.newSession().sql("SELECT * FROM global_temp.people").show()
// +----+-------+
// | age|   name|
// +----+-------+
// |null|Michael|
// |  30|   Andy|
// |  19| Justin|
// +----+-------+
```
```html
Find full example code at "examples/src/main/scala/org/apache/spark/examples/sql/SparkSQLExample.scala" in the Spark repo.
```

##Creating Datasets
```html
dataset类似于rdd
它们没有使用Java序列化或Kryo，而是使用专门的编码器来序列化对象，以便在网络上处理或传输。
虽然编码器和标准序列化都负责将对象转换为字节，
但是编码器是动态生成的代码，使用的格式允许Spark执行许多操作，比如filtering，sorting 和hashing，并没有反序列化回对象？？？
```
```html
Datasets are similar to RDDs, however, 
instead of using Java serialization or Kryo they use a specialized Encoder to serialize the objects for processing or transmitting over the network. 
While both encoders and standard serialization are responsible for turning an object into bytes, 
encoders are code generated dynamically and use a format that allows Spark to perform many operations like filtering, 
sorting and hashing without deserializing the bytes back into an object.
```
```shell script
case class Person(name: String, age: Long)

// Encoders are created for case classes
val caseClassDS = Seq(Person("Andy", 32)).toDS()
caseClassDS.show()
// +----+---+
// |name|age|
// +----+---+
// |Andy| 32|
// +----+---+

// Encoders for most common types are automatically provided by importing spark.implicits._
val primitiveDS = Seq(1, 2, 3).toDS()
primitiveDS.map(_ + 1).collect() // Returns: Array(2, 3, 4)

// DataFrames can be converted to a Dataset by providing a class. Mapping will be done by name
val path = "examples/src/main/resources/people.json"
val peopleDS = spark.read.json(path).as[Person]
peopleDS.show()
// +----+-------+
// | age|   name|
// +----+-------+
// |null|Michael|
// |  30|   Andy|
// |  19| Justin|
// +----+-------+

```
```html
Find full example code at "examples/src/main/scala/org/apache/spark/examples/sql/SparkSQLExample.scala" in the Spark repo.
```

##Interoperating with RDDs
```html
RDD抽样
Spark sql支持两种不同的方式将rdd转换为Datasets
1、通过反射来推断rdd（包含特定格式的object）的格式
2、通过编程接口创建一个格式，然后应用于RDD。

```
```html
Spark SQL supports two different methods for converting existing RDDs into Datasets. 
The first method uses reflection to infer the schema of an RDD that contains specific types of objects. 
This reflection-based approach leads to more concise code and works well when you already know the schema while writing your Spark application.
The second method for creating Datasets is through 
a programmatic interface that allows you to construct a schema and then apply it to an existing RDD. 
While this method is more verbose, it allows you to construct Datasets when the columns and their types are not known until runtime.
```
###Inferring the Schema Using Reflection
使用反射推断结构

```html
通过设置一个样例类，spark sql会自动地将rdd转换为dataframe
样例类定义了表的格式.
    使用反射读取case类的参数名，并成为列的名称。
    Case类也可以包含复杂类型，如seq或数组。
这个RDD可以隐式地转换为一个DataFrame，然后注册为一个表。
表可以在后续的SQL语句中使用。
```
```html
The Scala interface for Spark SQL supports automatically converting an RDD containing case classes to a DataFrame. 
The case class defines the schema of the table. 
The names of the arguments to the case class are read using reflection and become the names of the columns. 
Case classes can also be nested or contain complex types such as Seqs or Arrays. 
This RDD can be implicitly converted to a DataFrame and then be registered as a table. 
Tables can be used in subsequent SQL statements.
```

```shell script
// 1、For implicit conversions from RDDs to DataFrames
import spark.implicits._

// 2、Create an RDD of Person objects from a text file, convert it to a Dataframe
val peopleDF = spark.sparkContext
  .textFile("examples/src/main/resources/people.txt")
  .map(_.split(","))
  .map(attributes => Person(attributes(0), attributes(1).trim.toInt))
  .toDF()
// 3、Register the DataFrame as a temporary view
peopleDF.createOrReplaceTempView("people")

// 4、SQL statements can be run by using the sql methods provided by Spark
val teenagersDF = spark.sql("SELECT name, age FROM people WHERE age BETWEEN 13 AND 19")

// 5、The columns of a row in the result can be accessed by field index
teenagersDF.map(teenager => "Name: " + teenager(0)).show()
// +------------+
// |       value|
// +------------+
// |Name: Justin|
// +------------+

// 5、or by field name
teenagersDF.map(teenager => "Name: " + teenager.getAs[String]("name")).show()
// +------------+
// |       value|
// +------------+
// |Name: Justin|
// +------------+

// No pre-defined encoders for Dataset[Map[K,V]], define explicitly
implicit val mapEncoder = org.apache.spark.sql.Encoders.kryo[Map[String, Any]]
// Primitive types and case classes can be also defined as
// implicit val stringIntMapEncoder: Encoder[Map[String, Any]] = ExpressionEncoder()

// row.getValuesMap[T] retrieves multiple columns at once into a Map[String, T]
teenagersDF.map(teenager => teenager.getValuesMap[Any](List("name", "age"))).collect()
// Array(Map("name" -> "Justin", "age" -> 19))
```
```html
Find full example code at "examples/src/main/scala/org/apache/spark/examples/sql/SparkSQLExample.scala" in the Spark repo.
```

###Programmatically Specifying the Schema
编程的方式指定格式
当case类不能提前定义时(例如，记录的结构被编码为字符串，
或者文本数据集将被解析，字段将针对不同的用户进行不同的投影)，
可以通过三个步骤以编程方式创建一个DataFrame。


```html
When case classes cannot be defined ahead of time (for example, the structure of records is encoded in a string, 
or a text dataset will be parsed and fields will be projected differently for different users), 
a DataFrame can be created programmatically with three steps.

Create an RDD of Rows from the original RDD;
Create the schema represented by a StructType matching the structure of Rows in the RDD created in Step 1.
Apply the schema to the RDD of Rows via createDataFrame method provided by SparkSession.
For example:

```
```shell script
import org.apache.spark.sql.Row
import org.apache.spark.sql.types._

// 1、Create an RDD
val peopleRDD = spark.sparkContext.textFile("examples/src/main/resources/people.txt")

// 2.1、The schema is encoded in a string
val schemaString = "name age"

// 2.2、 Generate the schema based on the string of schema
val fields = schemaString.split(" ")
  .map(fieldName => StructField(fieldName, StringType, nullable = true))
val schema = StructType(fields)

// 2.3、Convert records of the RDD (people) to Rows
val rowRDD = peopleRDD
  .map(_.split(","))
  .map(attributes => Row(attributes(0), attributes(1).trim))

// 2.4、Apply the schema to the RDD
val peopleDF = spark.createDataFrame(rowRDD, schema)

// 3、Creates a temporary view using the DataFrame
peopleDF.createOrReplaceTempView("people")

// 4、SQL can be run over a temporary view created using DataFrames
val results = spark.sql("SELECT name FROM people")

// The results of SQL queries are DataFrames and support all the normal RDD operations
// The columns of a row in the result can be accessed by field index or by field name
//通过字段名或字段索引可以获取列
results.map(attributes => "Name: " + attributes(0)).show()
// +-------------+
// |        value|
// +-------------+
// |Name: Michael|
// |   Name: Andy|
// | Name: Justin|
// +-------------+
```

```html
Find full example code at "examples/src/main/scala/org/apache/spark/examples/sql/SparkSQLExample.scala" in the Spark repo.
```

##Scalar Functions
标量函数
返回每行一个单一的值
相对于，聚合函数返回一组行的值
spark sql内置了标量函数
也支持用户自定义

```html
Scalar functions are functions that return a single value per row, 
as opposed to aggregation functions, which return a value for a group of rows. 
Spark SQL supports a variety of Built-in Scalar Functions. 
It also supports User Defined Scalar Functions.
```



##Aggregate Functions
聚合函数
提供了count(), countDistinct(), avg(), max(), min()等函数
用户可以创建自己的聚合函数
详见用户自定义函数页
```html
Aggregate functions are functions that return a single value on a group of rows. 
The Built-in Aggregation Functions provide common aggregations such as count(), countDistinct(), avg(), max(), min(), etc. 
Users are not limited to the predefined aggregate functions and can create their own. 
For more details about user defined aggregate functions, please refer to the documentation of User Defined Aggregate Functions.
```
