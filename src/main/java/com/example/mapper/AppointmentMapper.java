package com.example.mapper;

import com.example.pojo.Appointment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppointmentMapper {
    void add(Appointment appointment);

    @Delete("delete from housekeeping.appointment where staff_id = #{staffId}")
    void deleteByStaffId(Integer staffId);
}
