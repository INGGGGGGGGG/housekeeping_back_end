package com.example.controller;

import com.example.pojo.DomesticWorker;
import com.example.pojo.PageBean;
import com.example.pojo.PageQueryDTO;
import com.example.pojo.Result;
import com.example.service.DomesticWorkerService;
import com.example.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequestMapping("/domesticWorker")
@RestController
@CrossOrigin(origins = "http://localhost:7000")
public class DomesticWorkerController {

    @Autowired
    private DomesticWorkerService domesticWorkerService;

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        //调用阿里云OSS工具类，将上传上来的文件存入阿里云
        String url = aliOSSUtils.upload(image);
        //将图片上传完成后的url返回，用于浏览器回显展示
        return Result.success(url);
    }

    /*
    分页查询数据 + 根据姓名检索数据
     */
    @GetMapping("/page")
    public Result list(PageQueryDTO pageQueryDTO) {
        log.info("获取家政人员列表:{}", pageQueryDTO);
        PageBean pageBean = domesticWorkerService.list(pageQueryDTO);
        return Result.success(pageBean);
    }

    /*
    分页查询上架数据
     */
    @GetMapping("/newPage")
    public Result newList(PageQueryDTO pageQueryDTO) {
        log.info("获取家政人员列表:{}", pageQueryDTO);
        PageBean pageBean = domesticWorkerService.newList(pageQueryDTO);
        return Result.success(pageBean);
    }

    /*
    上架数据查询
     */
    @GetMapping("/list")
    public Result getByServiceCategory(PageQueryDTO pageQueryDTO){
        log.info("上架数据查询:{}",pageQueryDTO);
        PageBean pageBean = domesticWorkerService.getByServiceCategory(pageQueryDTO);
        return Result.success(pageBean);
    }

    /*
    通过ID删除数据
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        log.info("根据ID删除数据:{}", id);
        domesticWorkerService.deleteById(id);
        return Result.success();
    }

    /*
    批量删除数据
     */
    @DeleteMapping("/ids")
    public Result deleteByIds(@RequestParam List<Integer> ids) {
        log.info("批量删除数据:{}", ids);
        domesticWorkerService.deleteByIds(ids);
        return Result.success();
    }

    /*
    新增数据
     */
    @PostMapping
    public Result add(@RequestBody DomesticWorker domesticWorker) {
        log.info("新增数据:{}", domesticWorker);
        domesticWorkerService.add(domesticWorker);
        return Result.success();
    }

    /*
    根据ID查询数据
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据ID查询数据:{}", id);
        DomesticWorker domesticWorker = domesticWorkerService.getById(id);
        return Result.success(domesticWorker);
    }

    /*
    根据ID修改数据
     */
    @PutMapping
    public Result update(@RequestBody DomesticWorker domesticWorker){
        log.info("修改数据:{}",domesticWorker);
        domesticWorkerService.update(domesticWorker);
        return Result.success();
    }

}
