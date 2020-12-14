package scala.com.demo.usesql.getStart.useUDF

import org.apache
import org.apache.spark.sql.{Dataset, SparkSession, TypedColumn}
import org.apache.spark.SparkConf


object UseUDAF {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local")
    val sparkSession: SparkSession = new apache.spark.sql.SparkSession.Builder()
      .appName("UDAF")
      .config(conf)
      .getOrCreate()
    import sparkSession.implicits._
    val empDataset: Dataset[Employee] = sparkSession
      .read
      .json("/Users/gaoliang/001软件开发/003工程/useTocollect/sparkdemo/文档/训练资料/emp")
      .as[Employee]
    val result: Dataset[Double] = useUDAF(empDataset)
    result.show()
    sparkSession.close()
  }

  /**
   * 使用udaf
   *
   * 将聚合函数转为TypedColumn，并命名
   * dataset使用select将函数加入进去。
   *
   * @param empDataset
   * @return
   */
  private def useUDAF(empDataset: Dataset[Employee]): Dataset[Double] = {

    val averageSalary: TypedColumn[Employee, Double] = MyAverage.toColumn.name("average_salary")

    val result: Dataset[Double] = empDataset.select(averageSalary)
    result
  }
}
