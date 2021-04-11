package com.li.design.service;

import com.li.design.entity.Plan;

import java.util.List;

public interface PlanService {
    boolean deleteByPrimaryKey(String id);

    boolean insertSelective(Plan record);

    Plan selectByPrimaryKey(String id);

    boolean updateByPrimaryKeySelective(Plan record);

    List<Plan> allPlan();
}
