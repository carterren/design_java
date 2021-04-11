package com.li.design.controller;

import com.alibaba.fastjson.JSONObject;
import com.li.design.entity.Warehouse;
import com.li.design.service.WarehouseService;
import com.li.design.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    
    @Autowired
    private WarehouseService warehouseService;
    @RequestMapping("/allWarehouse")
    public Object allCargoType(HttpServletRequest request) {
        return warehouseService.allWarehouse();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addWarehouse(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String type = request.getParameter("type").trim();
        String name = request.getParameter("name").trim();
        String temp = request.getParameter("temp").trim();
        String address = request.getParameter("address").trim();
        Warehouse warehouse = new Warehouse();
        warehouse.setType(type);
        warehouse.setName(name);
        warehouse.setTemp(temp);
        warehouse.setAddress(address);
        boolean flag = warehouseService.insertSelective(warehouse);
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
    public Object updateWarehouse(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String type = request.getParameter("type").trim();
        String name = request.getParameter("name").trim();
        String temp = request.getParameter("temp").trim();
        String address = request.getParameter("address").trim();
        Warehouse warehouse = new Warehouse();
        warehouse.setId(id);
        warehouse.setType(type);
        warehouse.setName(name);
        warehouse.setTemp(temp);
        warehouse.setAddress(address);


        boolean flag = warehouseService.updateByPrimaryKeySelective(warehouse);
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
    public Object deleteWarehouse(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        boolean flag = warehouseService.deleteByPrimaryKey(id);
        return flag;
    }
}
