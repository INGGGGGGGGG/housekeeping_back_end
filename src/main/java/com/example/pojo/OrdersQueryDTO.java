package com.example.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrdersQueryDTO implements Serializable {
    private Integer staffId;
    private Integer appointmentId;
}
