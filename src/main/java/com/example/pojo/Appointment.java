package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    private int id;
    private int staffId;                // 员工ID
    private LocalDate appointmentDate;  // 预约日期
    private int appointmentSession;     // 预约时间段(0上午、2下午)
    private String clientName;          // 客户姓名
    private String clientPhone;         // 客户联系电话
    private String clientAddress;       // 客户地址
    private LocalDateTime createTime;   // 创建时间
    private LocalDateTime updateTime;   // 修改时间
}
