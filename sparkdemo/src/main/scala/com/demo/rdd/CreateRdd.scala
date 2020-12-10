package scala.com.demo.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * 创建rdd的两种方式
 * 1、通过array
 * 2、通过textfile
 *
 */
object CreateRdd {
  def main(args: Array[String]): Unit = {
    /**
     * array和print操作是由diver执行的
     * rdd的创建和执行都是在work节点上执行的。
     */
    val sc: SparkContext = getSparkContext
    createRddByArray(sc)
    createRddByTextFile(sc)

    sc.stop();
  }


  /**
   * 1、配置环境上下文
   *
   * @return
   */
  def getSparkContext: SparkContext = {
    val conf: SparkConf = new SparkConf()
      .setAppName("arrayRdd")
      .setMaster("local")
    new SparkContext(conf)
  }

  /**
   * 2。1、通过本地文件或是HDFS创建rdd
   *
   * @param sc
   */
  private def createRddByTextFile(sc: SparkContext): Unit = {
    //HDFSPath="hdfs://hadoop01:9000/test/hello/text"
    val localFileRdd: RDD[String] = sc.textFile("文档/训练资料/wc")
    localFileRdd
      .flatMap(_.split(","))
      .map((_, 1))
      .reduceByKey(_ + _)
      .foreach(v => println("key:" + v._1 + ":value" + v._2))
  }

  /**
   * 2。2、通过数组创建rdd
   *
   * @param sc
   */
  private def createRddByArray(sc: SparkContext): Unit = {
    //通过数组创建rdd
    val arrRdd: RDD[Int] = sc.parallelize(Array(0, 1, 2, 3, 4, 5))
    //3、计算
    val sumNum: Double = arrRdd.sum()
    print(sumNum)
  }
}
