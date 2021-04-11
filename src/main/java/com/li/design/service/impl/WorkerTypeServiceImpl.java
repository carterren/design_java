package com.li.design.service.impl;

import com.li.design.entity.WorkerType;
import com.li.design.mapper.WorkerTypeMapper;
import com.li.design.service.WorkerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkerTypeServiceImpl implements WorkerTypeService {
    @Autowired
    private WorkerTypeMapper workerTypeMapper;
    @Override
    public boolean deleteByPrimaryKey(String id) {
        return workerTypeMapper.deleteByPrimaryKey(id)>0;
    }


    @Override
    public boolean insertSelective(WorkerType record) {
        return workerTypeMapper.insertSelective(record)>0;
    }

    @Override
    public WorkerType selectByPrimaryKey(String id) {
        return workerTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateByPrimaryKeySelective(WorkerType record) {
        return workerTypeMapper.updateByPrimaryKeySelective(record)>0;
    }


    @Override
    public List<WorkerType> allWorkerType() {
        return workerTypeMapper.allWorkerType();
    }
}
