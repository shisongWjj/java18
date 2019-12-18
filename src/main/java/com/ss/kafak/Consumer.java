package com.ss.kafak;



import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Consumer
 *
 * @author shisong
 * @date 2019/12/18
 */
public class Consumer {

    public static void main(String[] args){
        try {
            Properties properties = new Properties();
            properties.put("bootstrap.servers", "172.16.1.239:9092");
            properties.put("group.id", "group6554654ffff65-1");
            properties.put("enable.auto.commit", "true");
            properties.put("auto.commit.interval.ms", "1000");
            properties.put("auto.offset.reset", "earliest");
            properties.put("session.timeout.ms", "30000");
            properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

            KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
            kafkaConsumer.subscribe(Arrays.asList("interface","yunyingconsole","applog"));
            while (true) {
                ConsumerRecords<String, String> records = kafkaConsumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("offset = %d, value = %s", record.offset(), record.value());
                    System.out.println("=====================>");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*try {
            Properties properties = new Properties();
            properties.put("zookeeper.connect", "172.16.1.239:9092");
            properties.put("auto.commit.enable", "true");
            properties.put("auto.commit.interval.ms", "60000");
            properties.put("group.id", "appserver");
            ConsumerConfig consumerConfig = new ConsumerConfig(properties);
            ConsumerConnector javaConsumerConnector = kafka.consumer.Consumer.createJavaConsumerConnector(consumerConfig);
            // topic的过滤器
            Whitelist whitelist = new Whitelist("test_topic");
            List<KafkaStream<byte[], byte[]>> partitions = javaConsumerConnector.createMessageStreamsByFilter(whitelist);
            if (partitions == null) {
                System.out.println("empty!");
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println("partitions:"+partitions.size());
            // 消费消息
            for (KafkaStream<byte[], byte[]> partition : partitions) {
                ConsumerIterator<byte[], byte[]> iterator = partition.iterator();
                while (iterator.hasNext()) {
                    MessageAndMetadata<byte[], byte[]> next = iterator.next();
                    System.out.println("partiton:" + next.partition());
                    System.out.println("offset:" + next.offset());
                    System.out.println("接收到message:" + new String(next.message(), "utf-8"));
                }
            }
        } catch (Exception e) {
           e.printStackTrace();
        }*/
    }

}
