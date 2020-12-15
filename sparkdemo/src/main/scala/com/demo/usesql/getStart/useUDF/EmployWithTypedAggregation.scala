package scala.com.demo.usesql.getStart.useUDF

import org.apache.spark.sql.{Encoder, Encoders}
import org.apache.spark.sql.expressions.Aggregator

case class Employee(name: String, salary: Long)

case class Average(var sum: Long, var count: Long)

/**
 * in:Employee
 * buf:Average:有两个值（sum、count）
 * out:
 */
object EmployWithTypedAggregation extends Aggregator[Employee, Average, Double] {

  override def zero: Average = Average(0, 0)

  // 聚合：对中间值的操作:sum求和，count数数
  override def reduce(buffer: Average, employee: Employee): Average = {
    buffer.sum += employee.salary
    buffer.count += 1
    buffer
  }

  //合并：合并两个中间值
  override def merge(b1: Average, b2: Average): Average = {
    b1.sum += b2.sum
    b1.count += b2.count
    b1
  }

  //求最后的值
  override def finish(reduction: Average): Double = {
    reduction.sum.toDouble / reduction.count
  }

  //中间值的类型
  override def bufferEncoder: Encoder[Average] = Encoders.product

  //输出值的类型
  override def outputEncoder: Encoder[Double] = Encoders.scalaDouble


}
