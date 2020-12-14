package scala.com.demo.usesql.getStart

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

object HelloSparkSql {
  def main(args: Array[String]): Unit = {
    val stuSsAndDF: (SparkSession, DataFrame) = getDFFromJsonFile
    //可以有多个返回值。
    stuSsAndDF._2.show()
    stuSsAndDF._1.close()
  }

  /**
   * 创建DF。
   * 1、创建sparksession
   * 2、sparksession读取json文件直接获取DF。
   * 3、df的show方法展示查询到的数据。
   *
   * @return
   */
  def getDFFromJsonFile: (SparkSession, DataFrame) = {
    //1、创建sparkconf
    val conf: SparkConf = new SparkConf().setMaster("local")
    //2、创建sparksession
    val sparkSession: SparkSession = SparkSession.builder()
      .appName("helloSql")
      .config(conf)
      .getOrCreate()
    //3、读取文件
    //json文件是按行读取的：1、所以文件不能格式化,因为会换行2、每行后边不需要加逗号分割，和方括号作为一个数组。
    val stuDataFrame: DataFrame = sparkSession.read.json("文档/训练资料/stu.json")
    (sparkSession, stuDataFrame)
  }
}
