package com.example.mapper;

import com.example.pojo.Orders;
import com.example.pojo.PageQueryDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrdersMapper {
    void add(Orders orders);

    @Update("update housekeeping.orders set status = 0 , update_time = #{updateTime} where id = #{id}")
    void update(Orders orders);

    Page<Orders> list(PageQueryDTO pageQueryDTO);
}
