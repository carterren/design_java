package com.li.design.service;

import com.li.design.entity.Worker;

import java.util.List;

public interface WorkerService {

    boolean deleteByPrimaryKey(String id);


    boolean insertSelective(Worker record);

    Worker selectByPrimaryKey(String id);

    boolean updateByPrimaryKeySelective(Worker record);

    List<Worker> allWorker();

    Worker findByUsername(String username);

}
