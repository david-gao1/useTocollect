package com.gao.redis;


import redis.clients.jedis.Jedis;

/**
 * 单连接方式操作redis
 * 注意：此代码能够正常执行的前提是
 *      * 1：redis所在服务器的防火墙需要关闭
 *      * 2：redis.conf中的bind参数需要指定192.168.229.104
 */
public class RedisSingle {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.229.104",6379); //获取jedis连接
        jedis.set("imooc","hello bigdata!");        //向redis中添加数据，key=imooc，value=hello bigdata!
        String value = jedis.get("imooc");        //从redis中查询key=imooc的value的值
        System.out.println(value);
        jedis.close();        //关闭jedis连接

    }
}
