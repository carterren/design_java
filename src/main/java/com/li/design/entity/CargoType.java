package com.li.design.entity;

import java.io.Serializable;
import java.util.Date;

public class CargoType implements Serializable {
    private String id;

    private String cargoNum;

    private String cargoType;

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

    public String getCargoNum() {
        return cargoNum;
    }

    public void setCargoNum(String cargoNum) {
        this.cargoNum = cargoNum;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType == null ? null : cargoType.trim();
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