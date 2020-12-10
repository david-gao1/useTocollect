package scala.com.demo.rdd

import org.apache.spark.SparkContext
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator

object UseSharedVariables {
  def main(args: Array[String]): Unit = {
    val sc: SparkContext = CreateRdd.getSparkContext
    //useBroadcast(sc)

    useAccumulator(sc)


    sc.stop()
  }

  /**
   * 使用累加器
   * 使用longAccumulator定义累加器
   * add进行累加
   * @param sc
   */
  private def useAccumulator(sc: SparkContext): Unit = {
    val dataRDD: RDD[Int] = sc.parallelize(Array(1, 2, 3, 4, 5))

    //这种写法是错误的，因为foreach代码是在worker节点上执行的
    // var total = 0和println("total:"+total)是在Driver进程中执行的
    //所以无法实现累加操作
    //并且foreach算子可能会在多个task中执行，这样foreach内部实现的累加也不是最终全局累加的结果
    /*var total = 0
    dataRDD.foreach(num=>total += num)
    println("total:"+total)*/


    val sumAccumulator: LongAccumulator = sc.longAccumulator
    dataRDD.foreach(num => sumAccumulator.add(num))
    //注意：只能在Driver进程中获取累加变量的结果，其他地方是看不到的
    println(sumAccumulator.value)

  }

  /**
   * 使用：Broadcast
   * 1、sc.broadcast创建
   * 2、使用value使用广播变量
   *
   * @param sc
   */
  private def useBroadcast(sc: SparkContext): Unit = {
    val dataRDD: RDD[Int] = sc.parallelize(Array(1, 2, 3, 4, 5))
    val varableBroadcast: Broadcast[Int] = sc.broadcast(12)
    dataRDD.map(_ * varableBroadcast.value).foreach(println(_))
  }
}

