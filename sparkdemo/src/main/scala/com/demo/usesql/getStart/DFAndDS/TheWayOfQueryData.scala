package scala.com.demo.usesql.getStart.DFAndDS

import com.demo.usesql.getStart.StartingPoint.HelloSparkSql
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
 * sql编程的两种方式
 * 1、按照非类型化的数据操作的方式
 * 2、创建临时视图
 *
 */
object TheWayOfQueryData {
  def main(args: Array[String]): Unit = {
    val stuSsAndDF: (SparkSession, DataFrame) = HelloSparkSql.getDFFromJsonFile
    // This import is needed to use the $-notation
    import stuSsAndDF._1.implicits._
    stuSsAndDF._2.show()
    stuSsAndDF._2.printSchema()

    /**
     * 第一种方式：通过df（非类型化的数据操作）的方式
     */
    /**
     * 1.1、选择字段进行展示
     *
     */
    stuSsAndDF._2.select($"name").show()
    stuSsAndDF._2.select($"name",$"age").show()

    /**
     * 1.2、
     * 按照字段条件进行过滤
     * 整行字段展示
     */
    stuSsAndDF._2.filter($"age">10).show()

    /**
     * 1.3、
     * 分组之后需要做聚合运算,展示的是分组字段和聚合后的结果。
     */
    stuSsAndDF._2.groupBy("age").count().show()

    /**
     * 创建临时视图，通过sql进行查询
     * 总体的方式：
     * 1、使用df创建临时视图
     * 2、使用sparksession执行sql语句
     * 全局视图需要在表名前添加（global_temp.）
     */
    /**
     * 2.1、创建临时视图（会话结束视图就消失）
     */
    stuSsAndDF._2.createOrReplaceTempView("stu")
    val frame: DataFrame = stuSsAndDF._1.sql("select * from stu")
    frame.show()

    /**
     * 2.2、创建全局视图（应用结束，视图才消失。是跨会话的）
     */
    stuSsAndDF._2.createGlobalTempView("stu2")
    stuSsAndDF._1.sql("select count(*) from global_temp.stu2").show()

    stuSsAndDF._1.close()
  }

}
