package com.example.controller;

import com.example.pojo.Category;
import com.example.pojo.PageBean;
import com.example.pojo.PageQueryDTO;
import com.example.pojo.Result;
import com.example.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// TODO 上架数据地区查找处理(功能概率删除)，AI智能推荐实现数据库表数据上传云端，商家入驻成功后跳转或者回显实现，用户登录实现
@Slf4j
@RequestMapping("/category")
@RestController
@CrossOrigin(origins = "http://localhost:7000")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /*
    后台管理页面分页查询所有数据
     */
    @GetMapping("/page")
    public Result list(PageQueryDTO pageQueryDTO){
        log.info("获取所有服务类别列表:{}",pageQueryDTO);
        PageBean pageBean = categoryService.list(pageQueryDTO);
        return Result.success(pageBean);
    }

    /*
    分页查询有效数据
     */
    @GetMapping("/newPage")
    public Result newList(PageQueryDTO pageQueryDTO){
        log.info("获取有效服务类别列表:{}",pageQueryDTO);
        PageBean pageBean = categoryService.newList(pageQueryDTO);
        return Result.success(pageBean);
    }

    /*
    新增数据
     */
    @PostMapping
    public Result add(@RequestBody Category category){
        log.info("新增数据:{}",category);
        categoryService.add(category);
        return Result.success();
    }

    /*
    根据ID查询数据
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询数据:{}",id);
        Category category = categoryService.getById(id);
        return Result.success(category);
    }

    /*
    根据ID修改数据
     */
    @PutMapping
    public Result update(@RequestBody Category category){
        log.info("根据ID修改数据:{}",category);
        categoryService.update(category);
        return Result.success();
    }
}
