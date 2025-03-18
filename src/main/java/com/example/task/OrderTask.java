package com.example.task;

import com.example.mapper.AppointmentMapper;
import com.example.mapper.OrdersMapper;
import com.example.pojo.Orders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
public class OrderTask {

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Scheduled(cron = "0 0 23 * * ? ")
//    @Scheduled(cron = "0/10 * * * * ? ")
    public void processCompleteOrder(){
        log.info("定时处理已完成的订单:{}", LocalDateTime.now());
        LocalDate localDate = LocalDate.now();
        List<Integer> idList = appointmentMapper.getByAppointmentDateLT(localDate);
        if (idList != null && !idList.isEmpty()){
            for (Integer id : idList) {
                Orders orders = new Orders();
                orders.setAppointmentId(id);
                orders.setStatus(2);
                orders.setUpdateTime(LocalDateTime.now());
                ordersMapper.updateByAppointmentId(orders);
            }
        }
    }
}
