package com.example.service;

import com.example.pojo.PageBean;
import com.example.pojo.PageQueryDTO;

public interface OrdersService {
    void add(Integer staffId);

    void update(Integer id);

    PageBean list(PageQueryDTO pageQueryDTO);
}
