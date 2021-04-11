package com.li.design.service.impl;

import com.li.design.entity.Vehicle;
import com.li.design.mapper.VehicleMapper;
import com.li.design.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleMapper vehicleMapper;
    @Override
    public boolean deleteByPrimaryKey(String id) {
        return vehicleMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean insertSelective(Vehicle record) {
        return vehicleMapper.insertSelective(record)>0;
    }

    @Override
    public Vehicle selectByPrimaryKey(String id) {
        return vehicleMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Vehicle record) {
        return vehicleMapper.updateByPrimaryKeySelective(record)>0;
    }

    @Override
    public List<Vehicle> allVehicle() {
        return vehicleMapper.allVehicle();
    }
}
