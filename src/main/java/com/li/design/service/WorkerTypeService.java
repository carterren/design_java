package com.li.design.service;

import com.li.design.entity.WorkerType;

import java.util.List;

public interface WorkerTypeService {
    boolean deleteByPrimaryKey(String id);


    boolean insertSelective(WorkerType record);

    WorkerType selectByPrimaryKey(String id);

    boolean updateByPrimaryKeySelective(WorkerType record);


    List<WorkerType> allWorkerType();
}
