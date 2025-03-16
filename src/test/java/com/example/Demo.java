package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Demo {

    private String name;
    private Integer age;

    public static void main(String[] args) {
        Demo demo = new Demo("red", 18);
        System.out.println(demo.generateOrderId());
        System.out.println(demo.getAge());
    }

    public String generateOrderId() {
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        int randomNum = ThreadLocalRandom.current().nextInt(1000, 10000);
        return formattedDate + String.format("%04d", randomNum);
    }
}
