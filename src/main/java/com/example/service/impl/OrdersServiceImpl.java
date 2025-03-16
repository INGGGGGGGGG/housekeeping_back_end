package com.example.service.impl;

import com.example.mapper.OrdersMapper;
import com.example.pojo.DomesticWorker;
import com.example.pojo.Orders;
import com.example.pojo.PageBean;
import com.example.pojo.PageQueryDTO;
import com.example.service.DomesticWorkerService;
import com.example.service.OrdersService;
import com.example.utils.OrderUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private DomesticWorkerService domesticWorkerService;

    @Autowired
    private OrderUtils orderUtils;

    @Override
    public void add(Integer staffId) {
        DomesticWorker domesticWorker = domesticWorkerService.getById(staffId);
        Orders orders = new Orders();
        orders.setOrderNumber(orderUtils.generateOrderId());
        orders.setStaffId(staffId);
        orders.setStaffName(domesticWorker.getName());
        orders.setStaffImage(domesticWorker.getProfilePicture());
        orders.setHourlyRate(domesticWorker.getHourlyRate());
        orders.setPaymentMethod("现场支付");
        orders.setStatus(1);
        orders.setOrderTime(LocalDateTime.now());
        orders.setUpdateTime(LocalDateTime.now());
        orders.setUserId(1);
        ordersMapper.add(orders);
    }

    @Override
    public void update(Integer id) {
        Orders orders = new Orders();
        orders.setId(id);
        orders.setUpdateTime(LocalDateTime.now());
        ordersMapper.update(orders);
    }

    @Override
    public PageBean list(PageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());
        Page<Orders> page = ordersMapper.list(pageQueryDTO);
        return new PageBean(page.getTotal(), page.getResult());
    }
}
