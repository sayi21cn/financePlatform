package com.sunlights.account.vo;

import com.sunlights.account.AccountConstant;

import java.io.Serializable;

/**
 * <p>Project: fsp</p>
 * <p>Title: TotalCapitalVo.java</p>
 * <p>Description: 持有产品信息</p>
 * <p>Copyright (c) 2014 Sunlights.cc</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:jiaming.wang@sunlights.cc">wangJiaMing</a>
 */
public class Capital4Product implements Serializable {
    private static final long serialVersionUID = 8471977226403621283L;

    private String prdCode;

    private String prdName;

    private String totalProfit = AccountConstant.DEFAULT_MONEY;

    private String marketValue = AccountConstant.DEFAULT_MONEY;

    private String prdType;


    public Capital4Product() {

    }


    public String getPrdCode() {
        return prdCode;
    }

    public void setPrdCode(String prdCode) {
        this.prdCode = prdCode;
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    public String getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(String totalProfit) {
        this.totalProfit = totalProfit;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public String getPrdType() {
        return prdType;
    }

    public void setPrdType(String prdType) {
        this.prdType = prdType;
    }
}
