package com.li.design.mapper;

import com.li.design.entity.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(Worker record);

    Worker selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Worker record);

    List<Worker> allWorker();

    Worker findByUsername(String username);

}