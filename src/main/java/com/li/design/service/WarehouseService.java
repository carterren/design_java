package com.li.design.service;

import com.li.design.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
    boolean deleteByPrimaryKey(String id);


    boolean insertSelective(Warehouse record);

    Warehouse selectByPrimaryKey(String id);

    boolean updateByPrimaryKeySelective(Warehouse record);

    List<Warehouse> allWarehouse();
}
