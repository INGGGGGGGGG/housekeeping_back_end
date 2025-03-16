package com.example.service;

import com.example.pojo.Category;
import com.example.pojo.PageBean;
import com.example.pojo.PageQueryDTO;

public interface CategoryService {
    PageBean list(PageQueryDTO pageQueryDTO);

    PageBean newList(PageQueryDTO pageQueryDTO);

    void add(Category category);

    Category getById(Integer id);

    void update(Category category);
}
