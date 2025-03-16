package com.example.mapper;

import com.example.pojo.Category;
import com.example.pojo.PageQueryDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CategoryMapper {
    Page<Category> list(PageQueryDTO pageQueryDTO);

    Page<Category> newList(PageQueryDTO pageQueryDTO);

    void add(Category category);

    @Select("select * from housekeeping.category where id = #{id}")
    Category getById(Integer id);

    void update(Category category);
}
