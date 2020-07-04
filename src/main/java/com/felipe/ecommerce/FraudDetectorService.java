package com.felipe.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Properties;

public class FraudDetectorService {

    public static void main(String[] args) {
        FraudDetectorService fraudService = new FraudDetectorService();
        try(KafkaService service = new KafkaService<Order>(
                FraudDetectorService.class.getSimpleName(),"ECOMMERCE_NEW_ORDER", fraudService::parse)) {
            service.run();
        }
    }

    private void parse(ConsumerRecord<String, String> record) {
        System.out.println("-------------------------------------------");
        System.out.println("Processing new order, checking for fraud");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("com.felipe.ecommerce.Order processed");
    }

    private static Properties properties() {

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, FraudDetectorService.class.getSimpleName());
        return properties;
    }
}
