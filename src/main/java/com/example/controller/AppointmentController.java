package com.example.controller;

import com.example.pojo.Appointment;
import com.example.pojo.Result;
import com.example.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    通过员工ID删除数据
     */
    @DeleteMapping("/{staffId}")
    public Result deleteByStaffId(@PathVariable Integer staffId) {
        log.info("根据员工ID删除数据:{}", staffId);
        appointmentService.deleteByStaffId(staffId);
        return Result.success();
    }

}
