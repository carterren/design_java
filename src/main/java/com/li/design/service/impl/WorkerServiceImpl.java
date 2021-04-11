package com.li.design.service.impl;

import com.li.design.entity.Worker;
import com.li.design.mapper.WorkerMapper;
import com.li.design.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerMapper workerMapper;
    @Override
    public boolean deleteByPrimaryKey(String id) {
        return workerMapper.deleteByPrimaryKey(id)>0;
    }


    @Override
    public boolean insertSelective(Worker record) {
        return workerMapper.insertSelective(record)>0;
    }

    @Override
    public Worker selectByPrimaryKey(String id) {
        return workerMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Worker record) {
        return workerMapper.updateByPrimaryKeySelective(record)>0;
    }


    @Override
    public List<Worker> allWorker() {
        return workerMapper.allWorker();
    }

    @Override
    public Worker findByUsername(String username) {
        return workerMapper.findByUsername(username);
    }

}
