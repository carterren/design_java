package com.li.design.mapper;

import com.li.design.entity.WorkerType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerTypeMapper {
    int deleteByPrimaryKey(String id);


    int insertSelective(WorkerType record);

    WorkerType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WorkerType record);


    List<WorkerType> allWorkerType();
}