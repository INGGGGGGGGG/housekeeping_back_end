package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private Integer id;
    private String orderNumber;      // 订单号(18位)
    private Integer staffId;         // 员工ID
    private String staffName;        // 员工姓名
    private String staffImage;       // 员工头像
    private Double hourlyRate;       // 小时价格
    private String paymentMethod;    // 支付方式
    private Integer status;          // 状态(0已取消1已预约2已完成)
    private LocalDateTime orderTime; // 下单日期
    private LocalDateTime updateTime;// 修改日期
    private Integer appointmentId;   // 预约表ID
}