package com.sunlights.core.vo;


import com.sunlights.common.service.CommonService;
import models.Fund;
import models.ProductManage;
import models.ProductRecommend;

import java.math.BigDecimal;

/**
 * Created by Yuan on 2014/9/1.
 */
public class FundVo extends ProductVo {
    private Long peopleOfPurchased;//已申购人数
    private BigDecimal sevenDaysIncome;//七日年化收益率
    private BigDecimal millionIncome;//万分收益
    private String purchasedMethod;//买卖方式，比如:随买随卖
    private BigDecimal purchasedAmount;//起购金额

    public FundVo() {

    }

    public FundVo(Fund fund, ProductRecommend pr, ProductManage pm) {
        inFund(fund);
        inProductRecommend(pr);
        inProductManage(pm);
    }

    public FundVo(Fund fund) {
        inFund(fund);
    }

    public FundVo(Object[] columns) {
        this.setType(columns[0] == null ? "" : columns[0].toString());
        this.setId(columns[1] == null ? null : Long.valueOf(columns[1].toString()));
        this.setName(columns[2] == null ? null : columns[2].toString());
        this.setCode(columns[3] == null ? null : columns[3].toString());
        this.sevenDaysIncome = columns[4] == null ? BigDecimal.ZERO : (BigDecimal) columns[4];//七日年化
        this.millionIncome = columns[5] == null ? BigDecimal.ZERO : (BigDecimal) columns[5];
        this.purchasedAmount = columns[6] == null ? BigDecimal.ZERO : (BigDecimal) columns[6];//起购金额
        this.peopleOfPurchased = columns[7] == null ? 0L : Long.valueOf(columns[7].toString());
        this.purchasedMethod = columns[8] == null ? null : (String) columns[8];
    }

    public void inProductManage(ProductManage pm) {
        super.setType(pm.getProductType());
        super.setTypeDesc(new CommonService().findValueByCatPointKey(pm.getProductType()));
    }

    public void inProductRecommend(ProductRecommend pr) {
        super.setTag(pr.getRecommendFlag());
        super.setTagDesc(new CommonService().findValueByCatPointKey(pr.getRecommendFlag()));
        super.setGroup(pr.getRecommendType());
        super.setGroupDesc(new CommonService().findValueByCatPointKey(pr.getRecommendType()));
    }

    public void inFund(Fund fund) {
        super.setId(fund.getId());
        super.setName(fund.getChiName());
        super.setCategory(fund.getFundType());
        super.setCategoryDesc(new CommonService().findValueByCatPointKey(fund.getFundType()));
        super.setCode(fund.getFundCode());
        this.sevenDaysIncome = fund.getOneWeekProfit();
        this.millionIncome = fund.getMillionOfProfit();
        this.purchasedAmount = fund.getMinApplyAmount();
        this.peopleOfPurchased = fund.getInitBuyedCount();
        this.purchasedMethod = new CommonService().findValueByCatPointKey(fund.getInvestPeriod());
    }

    public Long getPeopleOfPurchased() {
        return peopleOfPurchased;
    }

    public void setPeopleOfPurchased(Long peopleOfPurchased) {
        this.peopleOfPurchased = peopleOfPurchased;
    }

    public BigDecimal getSevenDaysIncome() {
        return sevenDaysIncome;
    }

    public void setSevenDaysIncome(BigDecimal sevenDaysIncome) {
        this.sevenDaysIncome = sevenDaysIncome;
    }


    public BigDecimal getMillionIncome() {
        return millionIncome;
    }

    public void setMillionIncome(BigDecimal millionIncome) {
        this.millionIncome = millionIncome;
    }

    public String getPurchasedMethod() {
        return purchasedMethod;
    }

    public void setPurchasedMethod(String purchasedMethod) {
        this.purchasedMethod = purchasedMethod;
    }

    public BigDecimal getPurchasedAmount() {
        return purchasedAmount;
    }

    public void setPurchasedAmount(BigDecimal purchasedAmount) {
        this.purchasedAmount = purchasedAmount;
    }
}
