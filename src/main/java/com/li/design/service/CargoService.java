package com.li.design.service;

import com.li.design.entity.Cargo;

import java.util.List;

public interface CargoService {
    boolean deleteByPrimaryKey(String id);


    boolean insertSelective(Cargo record);

    Cargo selectByPrimaryKey(String id);

    boolean updateByPrimaryKeySelective(Cargo record);

    List<Cargo> allCargo();
}
