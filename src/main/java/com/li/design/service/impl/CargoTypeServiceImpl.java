package com.li.design.service.impl;

import com.li.design.entity.CargoType;
import com.li.design.mapper.CargoTypeMapper;
import com.li.design.service.CargoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CargoTypeServiceImpl implements CargoTypeService {
    @Autowired
    private CargoTypeMapper cargoTypeMapper;

    @Override
    public boolean deleteByPrimaryKey(String id) {
        return cargoTypeMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean insertSelective(CargoType record) {
        return cargoTypeMapper.insertSelective(record)>0;
    }

    @Override
    public CargoType selectByPrimaryKey(String id) {
        return cargoTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateByPrimaryKeySelective(CargoType record) {
        return cargoTypeMapper.updateByPrimaryKeySelective(record)>0;
    }

    @Override
    public List<CargoType> allCargoType() {
        return cargoTypeMapper.allCargoType();
    }
}
