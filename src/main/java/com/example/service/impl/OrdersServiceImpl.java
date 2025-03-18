package com.example.service.impl;

import com.example.mapper.AppointmentMapper;
import com.example.mapper.OrdersMapper;
import com.example.pojo.*;
import com.example.service.AppointmentService;
import com.example.service.DomesticWorkerService;
import com.example.service.OrdersService;
import com.example.utils.OrderUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private DomesticWorkerService domesticWorkerService;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Autowired
    private OrderUtils orderUtils;

    @Override
    public void add(OrdersQueryDTO ordersQueryDTO) {
        DomesticWorker domesticWorker = domesticWorkerService.getById(ordersQueryDTO.getStaffId());
        Orders orders = new Orders();
        orders.setOrderNumber(orderUtils.generateOrderId());
        orders.setStaffId(ordersQueryDTO.getStaffId());
        orders.setStaffName(domesticWorker.getName());
        orders.setStaffImage(domesticWorker.getProfilePicture());
        orders.setHourlyRate(domesticWorker.getHourlyRate());
        orders.setPaymentMethod("现场支付");
        orders.setStatus(1);
        orders.setOrderTime(LocalDateTime.now());
        orders.setUpdateTime(LocalDateTime.now());
        orders.setAppointmentId(ordersQueryDTO.getAppointmentId());
        ordersMapper.add(orders);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Integer id) {
        Orders orders = new Orders();
        orders.setId(id);
        orders.setUpdateTime(LocalDateTime.now());
        ordersMapper.update(orders);

        Integer appointmentId = ordersMapper.getAppointmentIdById(id);
        appointmentMapper.delete(appointmentId);
    }

    @Override
    public PageBean list(PageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());
        Page<Orders> page = ordersMapper.list(pageQueryDTO);
        return new PageBean(page.getTotal(), page.getResult());
    }
}
