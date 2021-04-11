package com.li.design.mapper;

import com.li.design.entity.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(Plan record);

    Plan selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Plan record);

    List<Plan> allPlan();
}