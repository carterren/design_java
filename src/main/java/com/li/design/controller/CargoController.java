package com.li.design.controller;

import com.alibaba.fastjson.JSONObject;
import com.li.design.entity.Cargo;
import com.li.design.entity.Cargo;
import com.li.design.service.CargoService;
import com.li.design.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/cargo")
public class CargoController {
    @Autowired
    private CargoService cargoService;
    @RequestMapping("/allCargo")
    public Object allCargo(HttpServletRequest request) {
        return cargoService.allCargo();
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addCargo(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String type = request.getParameter("type").trim();
        String name = request.getParameter("name").trim();
        String weight = request.getParameter("weight").trim();
        String temp = request.getParameter("temp").trim();

        Cargo cargo = new Cargo();
        cargo.setType(type);
        cargo.setName(name);
        cargo.setWeight(weight);
        cargo.setTemp(temp);
        boolean flag = cargoService.insertSelective(cargo);
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
    public Object updateCargo(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String type = request.getParameter("type").trim();
        String name = request.getParameter("name").trim();
        String weight = request.getParameter("weight").trim();
        String temp = request.getParameter("temp").trim();

        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setType(type);
        cargo.setName(name);
        cargo.setWeight(weight);
        cargo.setTemp(temp);

        boolean flag = cargoService.updateByPrimaryKeySelective(cargo);
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
    public Object deleteCargo(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        boolean flag = cargoService.deleteByPrimaryKey(id);
        return flag;
    }
}
