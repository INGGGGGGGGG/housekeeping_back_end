package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DomesticWorker {
    private Integer id;
    private String name;
    private Integer serviceCategory; // 服务分类(1家庭保洁,2宠物护理,3母婴护理,4老人护理,5服装护理服务,6节日装饰服务)
    private String profilePicture;   // 头像
    private String introduction;     // 简介
    private Double hourlyRate;       // 小时价格
    private String phoneNumber;      // 电话号码（正则）
    private Integer age;
    private Integer gender;          // 性别（0男1女）
    private String region;           // 所在地区
    private Integer status;          // 状态（0正常1异常2已被预约）
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
