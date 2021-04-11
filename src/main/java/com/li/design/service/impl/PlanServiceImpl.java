package com.li.design.service.impl;

import com.li.design.entity.Plan;
import com.li.design.mapper.PlanMapper;
import com.li.design.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanMapper planMapper;
    @Override
    public boolean deleteByPrimaryKey(String id) {
        return planMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean insertSelective(Plan record) {
        return planMapper.insertSelective(record)>0;
    }

    @Override
    public Plan selectByPrimaryKey(String id) {
        return planMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Plan record) {
        return planMapper.updateByPrimaryKeySelective(record)>0;
    }

    @Override
    public List<Plan> allPlan() {
        return planMapper.allPlan();
    }
}
