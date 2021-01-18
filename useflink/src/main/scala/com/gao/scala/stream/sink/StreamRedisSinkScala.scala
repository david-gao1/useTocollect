package com.gao.scala.stream.sink

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.connectors.redis.RedisSink
import org.apache.flink.streaming.connectors.redis.common.config.FlinkJedisPoolConfig
import org.apache.flink.streaming.connectors.redis.common.mapper.{RedisCommand, RedisCommandDescription, RedisMapper}

/**
 * 接收socket传输过来的数据，把数据保存到redis的list队列中
 */
object StreamRedisSinkScala {
  def main(args: Array[String]): Unit = {
    //source输入：source
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val text: DataStream[String] = env.socketTextStream("hadoop04", 9001)

    //transformation
    //组装数据：第一个元素指的是list对列key名称，第二个是想list队列中添加的元素。
    import org.apache.flink.api.scala._
    val listaData: DataStream[(String, String)] = text.map(word => ("l_words_scala", word))
    //sink：输出到redis
    val conf = new FlinkJedisPoolConfig.Builder().setHost("hadoop04").setPort(6379).build()
    val redisSink = new RedisSink[Tuple2[String, String]](conf, new MyRedisMapper)
    listaData.addSink(redisSink)
    //执行
    env.execute("StreamRedisSinkScala")

  }

  /**
   * 指定对数据的操作，以及获取怎样从数据中（数据源中）获取key和value
   */
  class MyRedisMapper extends RedisMapper[Tuple2[String, String]] {
    /**
     * 指定具体的操作：
     * 1、针对list数据类型，使用RedisCommand.LPUSH
     * 2、针对Hash数据类型，使用(RedisCommand.HSET,"hashKey"),在构造函数中需要指定hash类型key的名称。
     * @return
     */
    override def getCommandDescription: RedisCommandDescription = {
      new RedisCommandDescription(RedisCommand.LPUSH)
    }

    /**
     * 获取key
     * @param data
     * @return
     */
    override def getKeyFromData(data: (String, String)): String = {
      data._1
    }

    /**
     * 获取value
     * @param data
     * @return
     */
    override def getValueFromData(data: (String, String)): String = {
      data._2
    }
  }

}
