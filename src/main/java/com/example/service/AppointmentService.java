package com.example.service;

import com.example.pojo.Appointment;
import com.example.pojo.AppointmentQueryDTO;

import java.util.Date;
import java.util.List;

public interface AppointmentService {
    void add(Appointment appointment);

    List<Date> queryByStaffId(Integer staffId);

    List<Integer> queryByAppointmentQueryDTO(AppointmentQueryDTO appointmentQueryDTO);

//    void delete(Integer id);
}
