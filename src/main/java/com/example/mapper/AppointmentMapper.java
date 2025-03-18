package com.example.mapper;

import com.example.pojo.Appointment;
import com.example.pojo.AppointmentQueryDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Mapper
public interface AppointmentMapper {
    void add(Appointment appointment);

    List<Date> queryByStaffId(Integer staffId);

    List<Integer> queryByAppointmentQueryDTO(AppointmentQueryDTO appointmentQueryDTO);

    @Delete("delete from housekeeping.appointment where id = #{id}")
    void delete(Integer id);

    @Select("select id from housekeeping.appointment where appointment_date <= #{appointmentDate}")
    List<Integer> getByAppointmentDateLT(LocalDate appointmentDate);
}
