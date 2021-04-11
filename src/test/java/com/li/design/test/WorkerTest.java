package com.li.design.test;

import com.li.design.DesignApplication;
import com.li.design.entity.Worker;
import com.li.design.mapper.WorkerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DesignApplication.class)
public class WorkerTest {
    @Autowired
    private WorkerMapper workerMapper;
    @Test
    public void allWorker(){
        List<Worker> workers = workerMapper.allWorker();
        System.out.println("allWorker!");
        for (Worker worker:workers) {
            System.out.println(worker.toString());
        }
    }
    @Test
    public void insertSelective(){
        Worker worker = new Worker();
        worker.setUsername("admin1");
        worker.setPassword("admin1");
        workerMapper.insertSelective(worker);
    }

    @Test
    public void selectById(){
        Worker worker = workerMapper.selectByPrimaryKey("7AC5B7362C514798B121FF6EEC72F6EF");
        System.out.println(worker.toString());
    }

    @Test
    public void update(){
        Worker worker = new Worker();
        worker.setId("E16CDF4AC30D43249648802D2E3F6AB2");
        worker.setPhone("12414");
        worker.setPassword("5325");
        worker.setUsername("5325");
        worker.setRealname("zhang");
        worker.setRoleId("1");
        worker.setSex("0");
        worker.setAddr("FC62D9E69222");
        int i = workerMapper.updateByPrimaryKeySelective(worker);
        System.out.println(i);

    }
    @Test
    public void delete(){
        int i = workerMapper.deleteByPrimaryKey("7AC5B7362C514798B121FF6EEC72F6EF");
        System.out.println(i);
    }
}
