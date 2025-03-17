package com.example.controller;

import com.example.pojo.Appointment;
import com.example.pojo.AppointmentQueryDTO;
import com.example.pojo.Result;
import com.example.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RequestMapping("/appointment")
@RestController
@CrossOrigin(origins = "http://localhost:7000")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    /*
    新增数据
     */
    @PostMapping
    public Result add(@RequestBody Appointment appointment) {
        log.info("新增数据:{}", appointment);
        appointmentService.add(appointment);
        return Result.success();
    }

    /*
    通过员工ID查询员工的空闲日期，返回空闲的日期列表
     */
    @GetMapping("/{staffId}")
    public Result queryByStaffId(@PathVariable Integer staffId) {
        log.info("通过员工ID查询日期列表:{}", staffId);
        List<Date> list = appointmentService.queryByStaffId(staffId);
        return Result.success(list);
    }

    /*
    查询员工某一天的上午或者下午是否空闲
     */
    @GetMapping("/session")
    public Result queryByAppointmentQueryDTO(AppointmentQueryDTO appointmentQueryDTO) {
        log.info("查询员工某一天的上午或者下午是否空闲:{}", appointmentQueryDTO);
        List<Integer> list = appointmentService.queryByAppointmentQueryDTO(appointmentQueryDTO);
        return Result.success(list);
    }

}
