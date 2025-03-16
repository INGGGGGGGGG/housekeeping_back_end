package com.example.mapper;

import com.example.pojo.Category;
import com.example.pojo.DomesticWorker;
import com.example.pojo.PageQueryDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DomesticWorkerMapper {

    Page<DomesticWorker> list(PageQueryDTO pageQueryDTO);

    @Delete("delete from domestic_workers where id = #{id}")
    void deleteById(Integer id);

    void deleteByIds(List<Integer> ids);

    void add(DomesticWorker domesticWorker);

    @Select("select * from domestic_workers where id = #{id}")
    DomesticWorker getById(Integer id);

    void update(DomesticWorker domesticWorker);

    Page<DomesticWorker> newList(PageQueryDTO pageQueryDTO);

    void updateStatus(Category category);

    Page<DomesticWorker> getByServiceCategory(PageQueryDTO pageQueryDTO);
}
