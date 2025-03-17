package com.example.pojo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class AppointmentQueryDTO  implements Serializable {
    private Integer staffId;
    private LocalDate appointmentDate;
}
