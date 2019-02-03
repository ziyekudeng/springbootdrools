package com.drools.service;

import com.drools.model.BaseRuleEntityItemInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.drools.service.RuleEntityItemService
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface RuleEntityItemService {

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据实体id获取规则引擎实体属性信息
     *
     * @param baseRuleEntityItemInfo 参数
     */
    List<BaseRuleEntityItemInfo> findBaseRuleEntityItemInfoList(BaseRuleEntityItemInfo baseRuleEntityItemInfo);

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据id获取对应的属性信息
     *
     * @param id 属性Id
     */
    BaseRuleEntityItemInfo findBaseRuleEntityItemInfoById(final Long id);
}
