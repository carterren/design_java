package com.li.design.service;

import com.li.design.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    boolean deleteByPrimaryKey(String id);


    boolean insertSelective(Vehicle record);

    Vehicle selectByPrimaryKey(String id);

    boolean updateByPrimaryKeySelective(Vehicle record);

    List<Vehicle> allVehicle();
}
