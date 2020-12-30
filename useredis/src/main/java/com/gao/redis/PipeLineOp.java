package com.gao.redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * pipeline(管道)的使用
 * Created by xuwei
 */
public class PipeLineOp {
    public static void main(String[] args) {
        Jedis jedis = RedisUtils.getJedis();

        //1：不使用管道
        long start_time = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            jedis.set("a"+i,"a"+i);
        }
        long end_time = System.currentTimeMillis();
        System.out.println("不使用管道，耗时："+(end_time-start_time));

        //2：使用管道
        Pipeline pipelined = jedis.pipelined();
        start_time = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            pipelined.set("b"+i,"b"+i);
        }
        pipelined.sync();
        end_time = System.currentTimeMillis();
        System.out.println("使用管道，耗时："+(end_time-start_time));

        RedisUtils.returnResource(jedis);
    }

}
