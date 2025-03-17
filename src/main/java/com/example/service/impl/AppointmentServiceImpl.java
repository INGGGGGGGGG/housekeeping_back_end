package com.example.service.impl;

import com.example.mapper.AppointmentMapper;
import com.example.pojo.Appointment;
import com.example.pojo.AppointmentQueryDTO;
import com.example.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
    public List<Date> queryByStaffId(Integer staffId) {
        return appointmentMapper.queryByStaffId(staffId);
    }

    @Override
    public List<Integer> queryByAppointmentQueryDTO(AppointmentQueryDTO appointmentQueryDTO) {
        return appointmentMapper.queryByAppointmentQueryDTO(appointmentQueryDTO);
    }

}
