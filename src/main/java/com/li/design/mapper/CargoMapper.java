package com.li.design.mapper;

import com.li.design.entity.Cargo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoMapper {
    int deleteByPrimaryKey(String id);


    int insertSelective(Cargo record);

    Cargo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Cargo record);

    List<Cargo> allCargo();
}