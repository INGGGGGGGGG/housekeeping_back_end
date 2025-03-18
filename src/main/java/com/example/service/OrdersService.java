package com.example.service;

import com.example.pojo.OrdersQueryDTO;
import com.example.pojo.PageBean;
import com.example.pojo.PageQueryDTO;

public interface OrdersService {
    void add(OrdersQueryDTO ordersQueryDTO);

    void update(Integer id);

    PageBean list(PageQueryDTO pageQueryDTO);
}
