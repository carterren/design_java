package com.li.design.controller;

import com.alibaba.fastjson.JSONObject;
import com.li.design.entity.Worker;
import com.li.design.entity.WorkerType;
import com.li.design.service.WorkerTypeService;
import com.li.design.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/workerType")
public class WorkerTypeController {
    @Autowired
    private WorkerTypeService workerTypeService;

    @RequestMapping("/allWorkerType")
    public Object allWorkType(HttpServletRequest request) {
        return workerTypeService.allWorkerType();
    }

    /**
     * 添加员工
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addWorker(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String roleNum = request.getParameter("roleNum").trim();
        String roleName = request.getParameter("roleName").trim();

        WorkerType workerType = new WorkerType();
        workerType.setRoleNum(roleNum);
        workerType.setRoleName(roleName);
        boolean flag = workerTypeService.insertSelective(workerType);
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
        String roleNum = request.getParameter("roleNum").trim();
        String roleName = request.getParameter("roleName").trim();

        WorkerType workerType = new WorkerType();
        workerType.setId(id);
        workerType.setRoleNum(roleNum);
        workerType.setRoleName(roleName);

        boolean flag = workerTypeService.updateByPrimaryKeySelective(workerType);
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
        boolean flag = workerTypeService.deleteByPrimaryKey(id);
        return flag;
    }
}
