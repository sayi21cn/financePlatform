package com.sunlights.customer.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sunlights.common.AppConst;
import com.sunlights.common.models.IdEntity;

/**
 * Created by Administrator on 2014/9/10.
 */
@Entity
@Table(name = "c_customer_session")
public class CustomerSession extends IdEntity {
    @Column(length = 30,name = "CUSTOMER_ID")
    private String customerId;
    @Column(length = 400)
    private String token;
    @Column(length = 40,name = "DEVICE_NO")
    private String deviceNo; // 设备号
    @Column(length = 40,name = "DEVICE_NAME")
    private String deviceName; // 设备名称
    @Column(length = 40,name = "CLIENT_ADDRESS")
    private String clientAddress; // 客户端IP地址
    @Column(name = "UPDATED_DATETIME")
    private Timestamp updatedDatetime;
    @Column(name = "CREATED_DATETIME")
    private Timestamp createdDatetime;
    @Column(name = "STATUS", length = 1)
    private String status = AppConst.VERIFY_CODE_STATUS_INVALID;

    public CustomerSession() {
    }

    public Timestamp getUpdatedDatetime() {
        return updatedDatetime;
    }

    public void setUpdatedDatetime(Timestamp updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }

    public Timestamp getCreatedDatetime() {
        return createdDatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedDatetime(Timestamp createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }
}