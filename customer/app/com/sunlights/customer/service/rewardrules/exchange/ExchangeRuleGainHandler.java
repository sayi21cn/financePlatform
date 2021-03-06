package com.sunlights.customer.service.rewardrules.exchange;

import com.sunlights.common.MsgCode;
import com.sunlights.common.Severity;
import com.sunlights.common.vo.Message;
import com.sunlights.customer.ActivityConstant;
import com.sunlights.customer.factory.ActivityServiceFactory;
import com.sunlights.customer.service.ExchangeRewardRuleService;
import com.sunlights.customer.service.ExchangeSceneService;
import com.sunlights.customer.service.RewardTypeService;
import com.sunlights.customer.service.impl.ExchangeRewardRuleServiceImpl;
import com.sunlights.customer.service.impl.ExchangeSceneServiceImpl;
import com.sunlights.customer.service.rewardrules.vo.ActivityRequestVo;
import com.sunlights.customer.service.rewardrules.vo.ActivityResponseVo;
import com.sunlights.customer.service.rewardrules.vo.ExchangeSceneRuleVo;
import models.ExchangeRewardRule;
import models.ExchangeScene;
import models.RewardType;
import play.Logger;

/**
 * 兑换奖励功能链上的节点处理类--获取兑换规则（奖励类型）等兑换需要的信息
 * 并将这些信息当作请求的属性往下传，供后续节点使用
 * <p/>
 * 判断场景是否存在，不存在的话则终止流程
 * <p/>
 * Created by tangweiqun on 2014/12/3.
 */
public class ExchangeRuleGainHandler extends AbstractExchangeRuleHandler {
    private RewardTypeService rewardTypeService = ActivityServiceFactory.getRewardTypeService();
    private ExchangeSceneService exchangeSceneService = new ExchangeSceneServiceImpl();
    private ExchangeRewardRuleService exchangeRewardRuleService = new ExchangeRewardRuleServiceImpl();

    public ExchangeRuleGainHandler() {

    }

    public ExchangeRuleGainHandler(ExchangeRuleHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void exchangeInternal(ActivityRequestVo requestVo, ActivityResponseVo responseVo) throws Exception {
        ExchangeScene exchangeScene = requestVo.get("exchangeScene", ExchangeScene.class);
        if (exchangeScene == null) {
            exchangeScene = exchangeSceneService.findById(requestVo.getScene());
            requestVo.set("exchangeScene", exchangeScene);
        }
        requestVo.setScene(exchangeScene.getScene());
        requestVo.setRewardType(exchangeScene.getRewardType());
        if (exchangeScene == null || ActivityConstant.ACTIVITY_CUSTONER_STATUS_FORBIDDEN.equals(exchangeScene.getStatus())) {
            Message message = new Message(Severity.INFO, MsgCode.NOT_CONFIG_ACTIVITY_SCENE);
            responseVo.setMessage(message);
            responseVo.setFlowStop(true);
            Logger.debug("兑换场景不存在或者无效");
            return;
        }

        RewardType rewardType = rewardTypeService.findByTypeCode(requestVo.getRewardType());

        ExchangeRewardRule exchangeRewardRule = exchangeRewardRuleService.findByRewardType(exchangeScene.getRewardType());

        ExchangeSceneRuleVo exchangeSceneRuleVo = new ExchangeSceneRuleVo();
        exchangeSceneRuleVo.setExchangeRewardRule(exchangeRewardRule);
        exchangeSceneRuleVo.setExchangeScene(exchangeScene);
        exchangeSceneRuleVo.setRewardTypeModel(rewardType);

        requestVo.set("rewardType", rewardType);

        requestVo.set("exchangeSceneRuleVo", exchangeSceneRuleVo);

        Logger.debug("获取兑换场景成功");
    }
}
