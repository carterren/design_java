package com.li.design.mapper;

import com.li.design.entity.Vehicle;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleMapper {
    int deleteByPrimaryKey(String id);


    int insertSelective(Vehicle record);

    Vehicle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Vehicle record);

    List<Vehicle> allVehicle();
}