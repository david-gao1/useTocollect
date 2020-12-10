package scala.com.demo.rdd

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
 * 1、transformation：lazy特性，转换操作，会返回一个新的rdd
 * 2、action：为触发执行，并把action的操作结果返回给driver
 *
 */
object Transformation {
  def main(args: Array[String]): Unit = {
    val sc: SparkContext = CreateRdd.getSparkContext
    //计算有多少个国家
    //countCountry(sc)
    //useJoin(sc)
    //useSortBy(sc)
    groupByKeyOp2(sc)
  }

  /**
   * 使用distinct：去重
   * Return a new dataset that contains the distinct elements of the source dataset.
   *
   * @param sc
   */
  private def countCountry(sc: SparkContext): Unit = {
    val numAndCountryPairArrayRdd: RDD[(Int, String)] =
      sc.parallelize(
        Array((150001, "US"), (150002, "CN"), (15003, "AUS"), (15004, "CN"), (5005, "cn")))
    numAndCountryPairArrayRdd
      .map(_._2.toUpperCase)
      .distinct()
      .foreach(println(_))
  }


  /**
   *
   * 相同的key会集合到一起。不同的key将不会组成新的rdd
   * When called on datasets of type (K, V) and (K, W), returns a dataset of (K, (V, W)) pairs with all pairs of elements for each key.
   * Outer joins are supported through leftOuterJoin, rightOuterJoin, and fullOuterJoin.
   *
   * @param sc
   */
  private def useJoin(sc: SparkContext): Unit = {
    val numAndCountryPairArrayRdd: RDD[(Int, String)] =
      sc.parallelize(
        Array((150001, "US"), (150002, "CN"), (15003, "AUS"), (15004, "CN"), (5005, "cn")))
    val numAndPaymentPairArrayRdd: RDD[(Int, Int)] =
      sc.parallelize(
        Array((150001, 400), (150002, 500), (15003, 600), (15004, 400), (5006, 300)))
    val numToCountryAndPayment: RDD[(Int, (String, Int))] = numAndCountryPairArrayRdd.join(numAndPaymentPairArrayRdd)
    numToCountryAndPayment.foreach(
      nup => {
        val uid: Int = nup._1
        val area: String = nup._2._1
        val gold: Int = nup._2._2
        println("uid:" + uid + ",area:" + area + ",gold:" + gold)
      }
    )
  }

  /**
   * 可以指定排序的元素
   * 第二个参数为降序或是升序
   *
   * @param sc
   */
  def useSortBy(sc: SparkContext) {
    val numAndPaymentPairArrayRdd: RDD[(Int, Int)] =
      sc.parallelize(
        Array((150001, 400), (150002, 500), (15003, 600), (15004, 400), (5006, 300)))
    numAndPaymentPairArrayRdd
      .sortBy(_._2, false)
      .foreach(println(_))
  }

  /**
   * tuple列数大于2时，使用reduceBykey的处理
   * 将数据格式(key,(tuple))
   *
   * @param sc
   */
  def groupByKeyOp2(sc: SparkContext): Unit = {
    val dataRDD = sc.parallelize(Array((150001, "US", "male"), (150001, "CN", "female"), (150003, "CN", "male"), (150004, "IN", "female")))
    dataRDD.map(tup => (tup._2, (tup._1, tup._3))).groupByKey().foreach(tup => {
      //获取国家（组）信息
      val area = tup._1
      print(area + ":")
      //同一个国家下（组）的数据
      val it = tup._2
      for ((uid, sex) <- it) {
        print("<" + uid + "," + sex + "> ")
      }
      println()
    })
  }

}


