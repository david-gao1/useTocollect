package scala.com.demo.usesql.getStart.DFAndDS

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

object TheWayOfGetDS {
  def main(args: Array[String]): Unit = {
    val sparkSession: SparkSession = TheWayOfGetDF.getSparkSession
    //val dataSet: Dataset[Stu] = getDSFromFile(sparkSession)
    //val dataSet: Dataset[Stu] = GetDSFromSeq(sparkSession)
    val dataSet: Dataset[Stu] = getDSFromDF(sparkSession)

    dataSet.show()
    sparkSession.close()
  }

  /**
   * 3、从DF->DS
   *
   * @param sparkSession
   * @return
   */
  private def getDSFromDF(sparkSession: SparkSession): Dataset[Stu] = {
    import sparkSession.implicits._
    val dfFromFile: DataFrame = sparkSession.read.json("文档/训练资料/stu.json")
    val dataSet: Dataset[Stu] = dfFromFile.as[Stu]
    dataSet
  }

  /**
   * 2、seq->ds
   *
   * @param sparkSession
   * @return
   */
  private def GetDSFromSeq(sparkSession: SparkSession): Dataset[Stu] = {
    import sparkSession.implicits._
    val dataSet: Dataset[Stu] = Seq(Stu(1, "haha"), Stu(2, "xiaoxiao")).toDS()
    dataSet
  }

  /**
   * 1、从（rdd）文件中创建ds
   * a、从sparksession中创建sparkcontext并读取文件
   * b、使用样例类赋予数据结构，转为DS
   *
   * @param sparkSession
   * @return
   */
  private def getDSFromFile(sparkSession: SparkSession): Dataset[Stu] = {
    val fileRDD: RDD[String] = sparkSession.sparkContext.textFile("文档/训练资料/todf")
    import sparkSession.implicits._
    val dataSet: Dataset[Stu] = fileRDD.map(line => {
      val words: Array[String] = line.split(",")
      Stu(Integer.parseInt(words(0)), words(1))
    }).toDS
    dataSet
  }

  case class Stu(id: BigInt, name: String)

}
