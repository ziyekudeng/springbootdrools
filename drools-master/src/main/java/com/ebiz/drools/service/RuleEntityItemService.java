package com.ebiz.drools.service;

import com.ebiz.drools.model.BaseRuleEntityItemInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.RuleEntityItemService
 * VERSION:   1.0
 * Created by gaowei
 *
 */
public interface RuleEntityItemService {

    /**
     * Date 2017/7/20
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 根据实体id获取规则引擎实体属性信息
     *
     * @param baseRuleEntityItemInfo 参数
     */
    List<BaseRuleEntityItemInfo> findBaseRuleEntityItemInfoList(BaseRuleEntityItemInfo baseRuleEntityItemInfo);

    /**
     * Date 2017/7/26
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 根据id获取对应的属性信息
     *
     * @param id 属性Id
     */
    BaseRuleEntityItemInfo findBaseRuleEntityItemInfoById(final Long id);
}
