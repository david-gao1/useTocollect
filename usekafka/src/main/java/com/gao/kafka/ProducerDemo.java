package com.gao.kafka;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * 需求：Java代码实现生产者代码
 */
public class ProducerDemo {
    private final static String TOPIC_NAME = "hello";//指定topic

    public static void main(String[] args) {

        //配置produce的参数
        Properties prop = new Properties();
        prop.put("bootstrap.servers", "hadoop01:9092,hadoop02:9092,hadopp03:9092"); //指定kafka的broker地址
        prop.put("key.serializer", StringSerializer.class.getName());  //指定key数据的序列化格式
        prop.put("value.serializer", StringSerializer.class.getName());  //指定value数据的序列化格式


        //创建kafka生产者
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(prop);
        producer.send(new ProducerRecord<String, String>(TOPIC_NAME, "hello kafka"));        //向topic中生产数据


        //关闭链接
        producer.close();
    }

}
