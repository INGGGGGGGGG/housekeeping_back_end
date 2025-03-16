package com.example.service.impl;

import com.example.mapper.CategoryMapper;
import com.example.mapper.DomesticWorkerMapper;
import com.example.pojo.Category;
import com.example.pojo.PageBean;
import com.example.pojo.PageQueryDTO;
import com.example.service.CategoryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private DomesticWorkerMapper domesticWorkerMapper;

    @Override
    public PageBean list(PageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(),pageQueryDTO.getPageSize());
        Page<Category> page = categoryMapper.list(pageQueryDTO);
        return new PageBean(page.getTotal(),page.getResult());
    }

    @Override
    public PageBean newList(PageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(),pageQueryDTO.getPageSize());
        Page<Category> page = categoryMapper.newList(pageQueryDTO);
        return new PageBean(page.getTotal(),page.getResult());
    }

    @Override
    public void add(Category category) {
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.add(category);
    }

    @Override
    public Category getById(Integer id) {
        return categoryMapper.getById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Category category) {
        category.setUpdateTime(LocalDateTime.now());
        if(category.getStatus()==1){
            domesticWorkerMapper.updateStatus(category);
        }
        categoryMapper.update(category);
    }
}
