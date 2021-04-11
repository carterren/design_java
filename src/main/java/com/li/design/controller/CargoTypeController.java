package com.li.design.controller;

import com.alibaba.fastjson.JSONObject;
import com.li.design.entity.CargoType;
import com.li.design.entity.WorkerType;
import com.li.design.service.CargoService;
import com.li.design.service.CargoTypeService;
import com.li.design.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/cargoType")
public class CargoTypeController {

    @Autowired
    private CargoTypeService cargoTypeService;
    @RequestMapping("/allCargoType")
    public Object allCargoType(HttpServletRequest request) {
        return cargoTypeService.allCargoType();
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addCargoType(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String cargoNum = request.getParameter("cargoNum").trim();
        String cargoTypeName = request.getParameter("cargoType").trim();

        CargoType cargoType = new CargoType();
        cargoType.setCargoNum(cargoNum);
        cargoType.setCargoType(cargoTypeName);
        boolean flag = cargoTypeService.insertSelective(cargoType);
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
    public Object updateCargoType(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String cargoNum = request.getParameter("cargoNum").trim();
        String cargoTypename = request.getParameter("cargoType").trim();

        CargoType cargoType = new CargoType();
        cargoType.setId(id);
        cargoType.setCargoNum(cargoNum);
        cargoType.setCargoType(cargoTypename);

        boolean flag = cargoTypeService.updateByPrimaryKeySelective(cargoType);
        if (flag) {
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
    public Object deleteCargoType(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        boolean flag = cargoTypeService.deleteByPrimaryKey(id);
        return flag;
    }
}
