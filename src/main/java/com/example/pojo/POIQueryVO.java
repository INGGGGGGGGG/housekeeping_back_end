package com.example.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class POIQueryVO implements Serializable {
    private String name;
    private String category;
    private String introduction;
    private Double hourlyRate;
    private String phoneNumber;
    private Integer age;
    private String gender;
    private String region;
}
