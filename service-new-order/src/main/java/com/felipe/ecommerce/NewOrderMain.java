package com.felipe.ecommerce;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {

        try (KafkaDispatcher orderDspatcher = new KafkaDispatcher<Order>()) {
            try (KafkaDispatcher emailDspatcher = new KafkaDispatcher<Email>()) {
                for (int i = 0; i < 50; i++) {

                    String userId = UUID.randomUUID().toString();
                    String orderId = UUID.randomUUID().toString();
                    BigDecimal amount = new BigDecimal(Math.random() * 5000 + 1);
                    Order order = new Order(userId, orderId, amount);
                    orderDspatcher.send("ECOMMERCE_NEW_ORDER", userId, order);

                    String email = "thank you for your order! we are processing your order!";
                    emailDspatcher.send("ECOMMERCE_SEND_EMAIL", userId, email);
                }
            }
        }
    }

}
