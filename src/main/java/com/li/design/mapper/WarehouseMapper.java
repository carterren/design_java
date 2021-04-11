package com.li.design.mapper;

import com.li.design.entity.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseMapper {
    int deleteByPrimaryKey(String id);


    int insertSelective(Warehouse record);

    Warehouse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Warehouse record);

    List<Warehouse> allWarehouse();
}