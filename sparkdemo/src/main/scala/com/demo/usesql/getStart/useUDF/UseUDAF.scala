package scala.com.demo.usesql.getStart.useUDF

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession, TypedColumn, functions}


object UseUDAF {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local")
    val sparkSession: SparkSession = new SparkSession.Builder()
      .appName("UDAF")
      .config(conf)
      .getOrCreate()
    //useUDAFWithUntypied(sparkSession)
    //useUserDefineTypedAggregation(sparkSession)
    useUDAFWithAnonymity(sparkSession)


    sparkSession.close()
  }

  /**
   * 使用匿名函数
   * 可以使用sql
   *
   * @param sparkSession
   */
  private def useUDAFWithAnonymity(sparkSession: _root_.org.apache.spark.sql.SparkSession): Unit = {
    val fileDF: DataFrame = sparkSession
      .read
      .json("/Users/gaoliang/001软件开发/003工程/useTocollect/sparkdemo/文档/训练资料/emp")
    sparkSession.udf.register("increaseSalary", (x: Long) => x + 100)
    fileDF.createOrReplaceTempView("emp")
    sparkSession.sql("select increaseSalary(salary) from emp").show()
  }

  /**
   * 使用df的udaf
   * 可以使用sql
   *
   * @param sparkSession
   */
  private def useUDAFWithUntypied(sparkSession: _root_.org.apache.spark.sql.SparkSession): Unit = {
    val fileDF: DataFrame = sparkSession
      .read
      .json("/Users/gaoliang/001软件开发/003工程/useTocollect/sparkdemo/文档/训练资料/emp")
    sparkSession.udf.register("myAve", EmployWithUntypedAggregation)
    fileDF.createOrReplaceTempView("emp")
    sparkSession.sql("select myAve(salary) from emp").show()
  }

  /**
   * * 使用安全类型的udaf
   * *
   * * 将聚合函数转为TypedColumn，并命名
   * * dataset使用select将函数加入进去。
   * * 不能使用sql的方式。
   *
   * @param sparkSession
   * @return
   */
  private def useUserDefineTypedAggregation(sparkSession: SparkSession) = {
    import sparkSession.implicits._
    val empDataset: Dataset[Employee] = sparkSession
      .read
      .json("/Users/gaoliang/001软件开发/003工程/useTocollect/sparkdemo/文档/训练资料/emp")
      .as[Employee]
    val averageSalary: TypedColumn[Employee, Double] = EmployWithTypedAggregation.toColumn.name("average_salary")

    val result: Dataset[Double] = empDataset.select(averageSalary)
    result.show()
  }
}
