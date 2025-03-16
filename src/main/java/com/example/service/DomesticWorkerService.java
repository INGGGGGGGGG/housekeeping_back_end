package com.example.service;

import com.example.pojo.DomesticWorker;
import com.example.pojo.PageBean;
import com.example.pojo.PageQueryDTO;

import java.util.List;

public interface DomesticWorkerService {
    PageBean list(PageQueryDTO pageQueryDTO);

    void deleteById(Integer id);

    void deleteByIds(List<Integer> ids);

    void add(DomesticWorker domesticWorker);

    DomesticWorker getById(Integer id);

    void update(DomesticWorker domesticWorker);

    PageBean newList(PageQueryDTO pageQueryDTO);

    PageBean getByServiceCategory(PageQueryDTO pageQueryDTO);
}
