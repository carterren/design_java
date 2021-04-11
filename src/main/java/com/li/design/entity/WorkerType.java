package com.li.design.entity;

import java.io.Serializable;
import java.util.Date;

public class WorkerType implements Serializable {
    private String id;

    private String roleNum;

    private String roleName;

    private Date createTime;

    private Date updateTime;

    private Short deleted;

    private Short version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(String roleNum) {
        this.roleNum = roleNum;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getDeleted() {
        return deleted;
    }

    public void setDeleted(Short deleted) {
        this.deleted = deleted;
    }

    public Short getVersion() {
        return version;
    }

    public void setVersion(Short version) {
        this.version = version;
    }
}