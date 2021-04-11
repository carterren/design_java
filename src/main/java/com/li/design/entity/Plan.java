package com.li.design.entity;


import java.io.Serializable;
import java.util.Date;

public class Plan implements Serializable {


    private String id;
    private String sProvince;
    private String sAddr;
    private String eProvince;
    private String eAddr;
    private String sendDate;
    private String vehicle;
    private String cargoName;
    private String cargoWeight;
    private String price;
    private Date createTime;
    private Date updateTime;
    private Short deleted;
    private Short version;

    public String getSProvince() {
        return sProvince;
    }

    public void setSProvince(String sProvince) {
        this.sProvince = sProvince;
    }

    public String getEProvince() {
        return eProvince;
    }

    public void setEProvince(String eProvince) {
        this.eProvince = eProvince;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSaddr() {
        return sAddr;
    }

    public void setSaddr(String saddr) {
        this.sAddr = saddr == null ? null : saddr.trim();
    }

    public String getEaddr() {
        return eAddr;
    }

    public void setEaddr(String eaddr) {
        this.eAddr = eaddr == null ? null : eaddr.trim();
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle == null ? null : vehicle.trim();
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName == null ? null : cargoName.trim();
    }

    public String getcargoWeight() {
        return cargoWeight;
    }

    public void setcargoWeight(String cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getprice() {
        return price;
    }

    public void setprice(String price) {
        this.price = price;
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