package com.li.design.controller;

import com.alibaba.fastjson.JSONObject;
import com.li.design.entity.Vehicle;
import com.li.design.service.VehicleService;
import com.li.design.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @RequestMapping("/allVehicle")
    public Object allCargoType(HttpServletRequest request) {
        return vehicleService.allVehicle();
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addVehicle(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String type = request.getParameter("type").trim();
        String carryingCapacity = request.getParameter("carryingCapacity").trim();//载重
        String license = request.getParameter("license").trim(); //车牌号
        String engineNumber = request.getParameter("engineNumber").trim();//发动机编号
        String state = request.getParameter("state").trim();
        String text = request.getParameter("text").trim();

        Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setCarryingCapacity(carryingCapacity);
        vehicle.setLicense(license);
        vehicle.setEngineNumber(engineNumber);
        vehicle.setState(state);
        vehicle.setText(text);
        boolean flag = vehicleService.insertSelective(vehicle);
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
    public Object updateVehicle(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String type = request.getParameter("type").trim();
        String carryingCapacity = request.getParameter("carryingCapacity").trim();//载重
        String license = request.getParameter("license").trim(); //车牌号
        String engineNumber = request.getParameter("engineNumber").trim();//发动机编号
        String state = request.getParameter("state").trim();
        String text = request.getParameter("text").trim();

        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setType(type);
        vehicle.setCarryingCapacity(carryingCapacity);
        vehicle.setLicense(license);
        vehicle.setEngineNumber(engineNumber);
        vehicle.setState(state);
        vehicle.setText(text);

        boolean flag = vehicleService.updateByPrimaryKeySelective(vehicle);
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
    public Object deleteVehicle(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        boolean flag = vehicleService.deleteByPrimaryKey(id);
        return flag;
    }
}
