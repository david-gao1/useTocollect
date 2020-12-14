package scala.com.demo.usesql.getStart.DFAndDS

import org.apache
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.apache.spark.{SparkConf, SparkContext, sql}

/**
 * 创建df的几种方式
 *
 *
 */
object TheWayOfGetDF {
  def main(args: Array[String]): Unit = {
    val sparkSession: SparkSession = getSparkSession
    val fileDF: DataFrame = getDFFromFileAndCaseClass(sparkSession)
    //TODO：从hive文件中
    fileDF.show()
    sparkSession.close()
  }


  def getSparkSession: SparkSession = {
    val conf: SparkConf = new SparkConf().setMaster("local")
    val sparkSession: SparkSession = new apache.spark.sql.SparkSession.Builder()
      .appName("创建df")
      .config(conf)
      .getOrCreate()
    sparkSession
  }

  /**
   * 从文件中1
   * 为DF传字段
   *
   * @param sparkSession
   * @return
   */
  def getDFFromFile(sparkSession: SparkSession): DataFrame = {
    import sparkSession.implicits._
    val fileRDD: Dataset[String] = sparkSession.read.textFile("文档/训练资料/todf")
    val fileDF: DataFrame = fileRDD
      .map(line => {
        val words: Array[String] = line.split(",")
        (Integer.parseInt(words(0)), words(1))
      })
      .toDF("id", "name")
    fileDF
  }

  /**
   * 从文件中2
   * 使用样例类
   *
   * @param sparkSession
   * @return
   */
  def getDFFromFileAndCaseClass(sparkSession: SparkSession): DataFrame = {
    import sparkSession.implicits._
    val fileRDD: Dataset[String] = sparkSession.read.textFile("文档/训练资料/todf")
    val fileDF: DataFrame = fileRDD
      .map(line => {
        val words: Array[String] = line.split(",")
        Stu(Integer.parseInt(words(0)), words(1))
      })
      .toDF
    fileDF
  }

  case class Stu(id: Int, name: String)

}


