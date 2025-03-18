package com.example.controller;

import com.example.pojo.OrdersQueryDTO;
import com.example.pojo.PageBean;
import com.example.pojo.PageQueryDTO;
import com.example.pojo.Result;
import com.example.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/orders")
@RestController
@CrossOrigin(origins = "http://localhost:7000")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    /*
    修改订单状态为取消预约
     */
    @PutMapping
    public Result update(Integer id) {
        log.info("修改订单状态为取消预约:{}", id);
        ordersService.update(id);
        return Result.success();
    }

    /*
    分页查询数据
     */
    @GetMapping("/page")
    public Result list(PageQueryDTO pageQueryDTO) {
        log.info("分页查询数据:{}", pageQueryDTO);
        PageBean pageBean = ordersService.list(pageQueryDTO);
        return Result.success(pageBean);
    }
}
