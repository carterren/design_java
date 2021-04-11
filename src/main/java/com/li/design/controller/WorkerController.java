package com.li.design.controller;

import com.alibaba.fastjson.JSONObject;
import com.li.design.entity.Worker;
import com.li.design.service.WorkerService;
import com.li.design.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @RequestMapping("/allWorker")
    public Object allWorker(HttpServletRequest request) {
        return workerService.allWorker();
    }

    /**
     * 添加员工
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addWorker(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String roleId = request.getParameter("roleId").trim();
        String realName = request.getParameter("realName").trim();
        String sex = request.getParameter("sex").trim();
        String province = request.getParameter("province").trim();
        String addr = request.getParameter("addr").trim();
        String phone = request.getParameter("phone").trim();
        Worker worker = new Worker();
        worker.setUsername(username);
        worker.setPassword(password);
        worker.setProvince(province);
        worker.setAddr(addr);
        worker.setRoleId(roleId);
        worker.setRealname(realName);
        worker.setSex(sex);
        worker.setPhone(phone);
        boolean flag = workerService.insertSelective(worker);
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
    public Object updateWorker(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String roleId = request.getParameter("roleId").trim();
        String realName = request.getParameter("realName").trim();
        String sex = request.getParameter("sex").trim();
        String addr = request.getParameter("addr").trim();
        String province = request.getParameter("province").trim();
        String phone = request.getParameter("phone").trim();
        Worker worker = new Worker();
        worker.setId(id);
        worker.setUsername(username);
        worker.setPassword(password);
        worker.setProvince(province);
        worker.setAddr(addr);
        worker.setRoleId(roleId);
        worker.setRealname(realName);
        worker.setSex(sex);
        worker.setPhone(phone);

        boolean flag = workerService.updateByPrimaryKeySelective(worker);
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
    public Object deleteWorker(HttpServletRequest request) {
        String id = request.getParameter("id").trim();
        boolean flag = workerService.deleteByPrimaryKey(id);
        return flag;
    }

}
