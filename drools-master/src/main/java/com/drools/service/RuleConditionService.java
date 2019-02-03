package com.drools.service;

import com.drools.model.BaseRuleConditionInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.drools.service.RuleConditionService
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface RuleConditionService {

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据规则获取规则条件信息
     *
     * @param baseRuleConditionInfo 参数
     * @param page                  分页参数
     */
    PageInfo<BaseRuleConditionInfo> findBaseRuleConditionInfoPage(BaseRuleConditionInfo baseRuleConditionInfo, PageInfo page);

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据规则id获取规则条件信息
     *
     * @param ruleId 规则id
     */
    List<BaseRuleConditionInfo> findRuleConditionInfoByRuleId(final Long ruleId);
}
