package com.li.design.service;

import com.li.design.entity.CargoType;

import java.util.List;

public interface CargoTypeService {
    boolean deleteByPrimaryKey(String id);


    boolean insertSelective(CargoType record);

    CargoType selectByPrimaryKey(String id);

    boolean updateByPrimaryKeySelective(CargoType record);

    List<CargoType> allCargoType();
}
