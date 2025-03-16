package com.example.service;

import com.example.pojo.Appointment;

public interface AppointmentService {
    void add(Appointment appointment);

    void deleteByStaffId(Integer staffId);
}
