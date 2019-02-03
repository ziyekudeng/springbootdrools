package com.drools.service;

import com.drools.model.BaseRuleConditionInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.RuleConditionService
 * VERSION:   1.0
 * Created by gaowei
 * DATE:      2017/7/24
 */
public interface RuleConditionService {

    /**
     * Date 2017/7/24
     * Author gaowei
     * <p>
     * 方法说明: 根据规则获取规则条件信息
     *
     * @param baseRuleConditionInfo 参数
     * @param page                  分页参数
     */
    PageInfo<BaseRuleConditionInfo> findBaseRuleConditionInfoPage(BaseRuleConditionInfo baseRuleConditionInfo, PageInfo page);

    /**
     * Date 2017/7/26
     * Author gaowei
     * <p>
     * 方法说明: 根据规则id获取规则条件信息
     *
     * @param ruleId 规则id
     */
    List<BaseRuleConditionInfo> findRuleConditionInfoByRuleId(final Long ruleId);
}
