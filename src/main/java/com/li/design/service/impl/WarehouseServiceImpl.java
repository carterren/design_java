package com.li.design.service.impl;

import com.li.design.entity.Warehouse;
import com.li.design.mapper.WarehouseMapper;
import com.li.design.mapper.WorkerMapper;
import com.li.design.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;
    @Override
    public boolean deleteByPrimaryKey(String id) {
        return warehouseMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean insertSelective(Warehouse record) {
        return warehouseMapper.insertSelective(record)>0;
    }

    @Override
    public Warehouse selectByPrimaryKey(String id) {
        return warehouseMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Warehouse record) {
        return warehouseMapper.updateByPrimaryKeySelective(record)>0;
    }

    @Override
    public List<Warehouse> allWarehouse() {
        return warehouseMapper.allWarehouse();
    }
}
