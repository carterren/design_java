package com.li.design.service.impl;

import com.li.design.entity.Cargo;
import com.li.design.mapper.CargoMapper;
import com.li.design.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CargoServiceImpl implements CargoService {
    @Autowired
    private CargoMapper cargoMapper;
    @Override
    public boolean deleteByPrimaryKey(String id) {
        return cargoMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean insertSelective(Cargo record) {
        return cargoMapper.insertSelective(record)>0;
    }

    @Override
    public Cargo selectByPrimaryKey(String id) {
        return cargoMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Cargo record) {
        return cargoMapper.updateByPrimaryKeySelective(record)>0;
    }

    @Override
    public List<Cargo> allCargo() {
        return cargoMapper.allCargo();
    }
}
