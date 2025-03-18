package com.example.service.impl;

import com.example.mapper.AppointmentMapper;
import com.example.pojo.Appointment;
import com.example.pojo.AppointmentQueryDTO;
import com.example.pojo.OrdersQueryDTO;
import com.example.service.AppointmentService;
import com.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired
    private OrdersService ordersService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(Appointment appointment) {
        appointment.setCreateTime(LocalDateTime.now());
        appointment.setUpdateTime(LocalDateTime.now());
        appointmentMapper.add(appointment);

        int id = appointment.getId();
        int staffId = appointment.getStaffId();
        OrdersQueryDTO ordersQueryDTO = new OrdersQueryDTO();
        ordersQueryDTO.setStaffId(staffId);
        ordersQueryDTO.setAppointmentId(id);
        ordersService.add(ordersQueryDTO);
    }

    @Override
    public List<Date> queryByStaffId(Integer staffId) {
        return appointmentMapper.queryByStaffId(staffId);
    }

    @Override
    public List<Integer> queryByAppointmentQueryDTO(AppointmentQueryDTO appointmentQueryDTO) {
        return appointmentMapper.queryByAppointmentQueryDTO(appointmentQueryDTO);
    }

//    @Override
//    public void delete(Integer id) {
//        appointmentMapper.delete(id);
//    }

}
