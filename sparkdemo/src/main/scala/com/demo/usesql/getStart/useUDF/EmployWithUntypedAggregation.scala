package scala.com.demo.usesql.getStart.useUDF


import org.apache.spark.sql.Row
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, DoubleType, LongType, StructField, StructType}


object EmployWithUntypedAggregation extends UserDefinedAggregateFunction {
  // Data types of input arguments of this aggregate function
  //输入数据的类型，可以输入为null
  //"::":连接两个值,形成一个数组
  override def inputSchema: StructType = StructType(StructField("inputColumn", LongType) :: Nil)


  //中间值的数据类型
  override def bufferSchema: StructType = {
    StructType(StructField("sum", LongType) :: StructField("count", LongType) :: Nil)
  }

  //返回值的数据类型
  override def dataType: DataType = DoubleType

  //输入和输出总是相同的
  override def deterministic: Boolean = true

  // Initializes the given aggregation buffer. The buffer itself is a `Row` that in addition to
  // standard methods like retrieving a value at an index (e.g., get(), getBoolean()), provides
  // the opportunity to update its values. Note that arrays and maps inside the buffer are still
  // immutable.
  //初始化中间值，中间值本身是row，设定值的时候通过索引
  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = 0L
    buffer(1) = 0L
  }

  //更新中间值
  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    if (!input.isNullAt(0)) { //检查第一个值是否为0
      buffer(0) = buffer.getLong(0) + input.getLong(0)
      buffer(1) = buffer.getLong(1) + 1
    }

  }

  //合并两个中间值
  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)
    buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
  }

  //计算最终解
  override def evaluate(buffer: Row): Any = buffer.getLong(0).toDouble / buffer.getLong(1)
}
