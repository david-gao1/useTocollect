package com.gao.kafka;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

/**
 * 需求：Java代码实现消费者代码
 */
public class ConsumerDemo {

    public static void main(String[] args) {

        //配置参数
        Properties prop = new Properties();
        prop.put("bootstrap.servers", "hadoop01:9092,hadoop02:9092,hadoop03:9092");  //指定kafka的broker地址
        prop.put("key.deserializer", StringDeserializer.class.getName());        //指定key-value的反序列化类型
        prop.put("value.deserializer", StringDeserializer.class.getName());
        prop.put("auto.offset.reset","earliest"); //从最开始的位置进行消费，但是再次重启的时候，是根据上次保存的offset来消费数据，因为没有新的数据产生所以就消费不到了
        prop.put("group.id", "con-2");        //指定消费者组

        //创建消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(prop);
        Collection<String> topics = new ArrayList<String>();
        topics.add("hello");
        consumer.subscribe(topics); //订阅指定的topic

        //消费数据
        while (true) {
            ConsumerRecords<String, String> poll = consumer.poll(Duration.ofSeconds(1));//【注意：需要修改jdk编译级别为1.8，否则Duration.ofSeconds(1)会语法报错】
            for (ConsumerRecord<String, String> consumerRecord : poll) {
                System.out.println(consumerRecord);
            }
        }

    }

}
