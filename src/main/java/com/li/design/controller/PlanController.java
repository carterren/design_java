package com.li.design.controller;

import com.alibaba.fastjson.JSONObject;
import com.li.design.entity.Plan;
import com.li.design.service.PlanService;
import com.li.design.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private PlanService planService;

    @RequestMapping("/allPlan")
    public Object allPlan(HttpServletRequest request) {
        return planService.allPlan();
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addPlan(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String sProvince = request.getParameter("sProvince").trim();
        String sAddr = request.getParameter("sAddr").trim();
        String eProvince = request.getParameter("eProvince").trim();
        String eAddr = request.getParameter("eAddr").trim();
        String sendDate = request.getParameter("sendDate").trim();
        String vehicle = request.getParameter("vehicle").trim();
        String cargoName = request.getParameter("cargoName").trim();
        String cargoWeight = request.getParameter("cargoWeight").trim();
        String price = request.getParameter("price").trim();

        Plan plan = new Plan();
        plan.setSProvince(sProvince);
        plan.setSaddr(sAddr);
        plan.setEProvince(eProvince);
        plan.setEaddr(eAddr);
        plan.setSendDate(sendDate);
        plan.setVehicle(vehicle);
        plan.setCargoName(cargoName);
        plan.setcargoWeight(cargoWeight);
        plan.setprice(price);

        boolean flag = planService.insertSelective(plan);
        if (flag) {
            //保存成功
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "添加成功");
            return jsonObject;
        }

        //保存失败
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "添加失败");
        return jsonObject;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object updatePlan(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String sProvince = request.getParameter("sProvince").trim();
        String sAddr = request.getParameter("sAddr").trim();
        String eProvince = request.getParameter("eProvince").trim();
        String eAddr = request.getParameter("eAddr").trim();
        String sendDate = request.getParameter("sendDate").trim();
        String vehicle = request.getParameter("vehicle").trim();
        String cargoName = request.getParameter("cargoName").trim();
        String cargoWeight = request.getParameter("cargoWeight").trim();
        String price = request.getParameter("price").trim();

        Plan plan = new Plan();
        plan.setId(id);
        plan.setSProvince(sProvince);
        plan.setSaddr(sAddr);
        plan.setEProvince(eProvince);
        plan.setEaddr(eAddr);
        plan.setSendDate(sendDate);
        plan.setVehicle(vehicle);
        plan.setCargoName(cargoName);
        plan.setcargoWeight(cargoWeight);
        plan.setprice(price);

        boolean flag = planService.updateByPrimaryKeySelective(plan);
        if (flag){
            //保存成功
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "修改成功");
            return jsonObject;

        }
        //保存失败
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "修改失败");
        return jsonObject;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object deletePlan(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        boolean flag = planService.deleteByPrimaryKey(id);
        return flag;
    }
}
