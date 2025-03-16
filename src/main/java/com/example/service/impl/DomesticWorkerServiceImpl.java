package com.example.service.impl;

import com.example.mapper.DomesticWorkerMapper;
import com.example.pojo.DomesticWorker;
import com.example.pojo.PageBean;
import com.example.pojo.PageQueryDTO;
import com.example.service.DomesticWorkerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DomesticWorkerServiceImpl implements DomesticWorkerService {

    @Autowired
    private DomesticWorkerMapper domesticWorkerMapper;

    @Override
    public PageBean list(PageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());
        Page<DomesticWorker> page = domesticWorkerMapper.list(pageQueryDTO);
        return new PageBean(page.getTotal(), page.getResult());
    }

    @Override
    public void deleteById(Integer id) {
        domesticWorkerMapper.deleteById(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        domesticWorkerMapper.deleteByIds(ids);
    }

    @Override
    public void add(DomesticWorker domesticWorker) {
        domesticWorker.setCreateTime(LocalDateTime.now());
        domesticWorker.setUpdateTime(LocalDateTime.now());
        domesticWorkerMapper.add(domesticWorker);
    }

    @Override
    public DomesticWorker getById(Integer id) {
        return domesticWorkerMapper.getById(id);
    }

    @Override
    public void update(DomesticWorker domesticWorker) {
        domesticWorker.setUpdateTime(LocalDateTime.now());
        domesticWorkerMapper.update(domesticWorker);
    }

    @Override
    public PageBean newList(PageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());
        Page<DomesticWorker> page = domesticWorkerMapper.newList(pageQueryDTO);
        return new PageBean(page.getTotal(), page.getResult());
    }

    @Override
    public PageBean getByServiceCategory(PageQueryDTO pageQueryDTO) {
        if (pageQueryDTO.getServiceCategory() != null && pageQueryDTO.getServiceCategory() == 0) {
            pageQueryDTO.setServiceCategory(null);
        }
        PageHelper.startPage(pageQueryDTO.getPage(), pageQueryDTO.getPageSize());
        Page<DomesticWorker> page = domesticWorkerMapper.getByServiceCategory(pageQueryDTO);
        return new PageBean(page.getTotal(), page.getResult());
    }
}
