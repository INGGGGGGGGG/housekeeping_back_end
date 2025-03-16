package com.example.service.impl;

import com.example.mapper.AppointmentMapper;
import com.example.pojo.Appointment;
import com.example.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public void add(Appointment appointment) {
        appointment.setCreateTime(LocalDateTime.now());
        appointment.setUpdateTime(LocalDateTime.now());
        appointmentMapper.add(appointment);
    }

    @Override
    public void deleteByStaffId(Integer staffId) {
        appointmentMapper.deleteByStaffId(staffId);
    }
}
