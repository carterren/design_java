package com.li.design.mapper;

import com.li.design.entity.CargoType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoTypeMapper {
    int deleteByPrimaryKey(String id);


    int insertSelective(CargoType record);

    CargoType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CargoType record);

    List<CargoType> allCargoType();
}