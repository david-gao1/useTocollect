package scala.com.demo.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Action {
  def main(args: Array[String]): Unit = {
    val sc: SparkContext = getSparkContext
    countByKeyOp(sc)
  }

  /**
   *
   * 当使用foreach的时候注意闭包的问题
   * Run a function func on each element of the dataset.
   * This is usually done for side effects such as updating an Accumulator or interacting with external storage systems.
   * Note: modifying variables other than Accumulators outside of the foreach() may result in undefined behavior.
   * See Understanding closures for more details.
   *
   * @param sc
   */
  def foreachOp(sc: SparkContext): Unit = {
    val dataRDD: RDD[Int] = sc.parallelize(Array(1, 2, 3, 4, 5))
    dataRDD.foreach(println(_))
  }

  /**
   *Only available on RDDs of type (K, V).
   * Returns a hashmap of (K, Int) pairs with the count of each key.
   * 返回（key,times）的rdd
   *
   * @param sc
   */
  def countByKeyOp(sc: SparkContext): Unit = {
    val dataRDD: RDD[(String, Int)] = sc.parallelize(Array(("A", 1001), ("B", 1002), ("A", 1003), ("C", 1004)))
    val res: collection.Map[String, Long] = dataRDD.countByKey()
    for ((k, v) <- res) {
      println(k + "," + v)
    }
  }

  /**
   * Write the elements of the dataset as a text file (or set of text files) in a given directory
   * in the local filesystem, HDFS or any other Hadoop-supported file system.
   * Spark will call toString on each element to convert it to a line of text in the file.
   * rdd转换为text file，转换为每一个元素为一行。
   * @param sc
   */
  def saveAsTextFileOp(sc: SparkContext): Unit = {
    val dataRDD = sc.parallelize(Array(1, 2, 3, 4, 5))
    //指定HDFS的路径信息即可，需要指定一个不存在的目录
    dataRDD.saveAsTextFile("hdfs://bigdata01:9000/out0524")
  }


  /**
   * Return the number of elements in the dataset.
   * @param sc
   */
  def countOp(sc: SparkContext): Unit = {
    val dataRDD = sc.parallelize(Array(1, 2, 3, 4, 5))
    val res = dataRDD.count()
    println(res)
  }

  /**
   * Return an array with the first n elements of the dataset.
   * @param sc
   */
  def takeOp(sc: SparkContext): Unit = {
    val dataRDD = sc.parallelize(Array(1, 2, 3, 4, 5))
    //从RDD中获取前2个元素
    val res = dataRDD.take(2)
    for (item <- res) {
      println(item)
    }
  }

  /**
   * Return all the elements of the dataset as an array at the driver program.
   * This is usually useful after a filter or other operation that returns a sufficiently small subset of the data.
   * 将所有的元素转为数组给driver
   * //注意：如果RDD中数据量过大，不建议使用collect，因为最终的数据会返回给Driver进程所在的节点
   * 可以使用take(n)获取一定的数据
   *
   * @param sc
   */
  def collectOp(sc: SparkContext): Unit = {
    val dataRDD = sc.parallelize(Array(1, 2, 3, 4, 5))
    val res = dataRDD.collect()
    for (item <- res) {
      println(item)
    }
  }

  /**
   *
   * Aggregate the elements of the dataset using a function func (which takes two arguments and returns one).
   * The function should be commutative and associative so that it can be computed correctly in parallel.
   * @param sc
   */
  def reduceOp(sc: SparkContext): Unit = {
    val dataRDD = sc.parallelize(Array(1, 2, 3, 4, 5))
    val num = dataRDD.reduce(_ + _)
    println(num)
  }

  /**
   * 获取SparkContext
   *
   * @return
   */
  private def getSparkContext = {
    val conf = new SparkConf()
    conf.setAppName("ActionOpScala")
      .setMaster("local")
    new SparkContext(conf)
  }
}
