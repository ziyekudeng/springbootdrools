package com.drools.service;

import com.drools.model.BaseRuleActionRuleRelInfo;
import com.github.pagehelper.PageInfo;

/**
 * 描述：
 * CLASSPATH: com.drools.service.RuleActionRelService
 * VERSION:   1.0
 * Created by gaowei
 * DATE:      2017/7/24
 */
public interface RuleActionRelService {

    /**
     * Date 2017/7/24
     * Author gaowei
     *
     * 方法说明: 获取规则与动作关系集合信息
     * @param baseRuleActionRuleRelInfo 参数
     * @param page 分页参数
     */
    PageInfo<BaseRuleActionRuleRelInfo> findBaseRuleActionRuleRelInfoPage(BaseRuleActionRuleRelInfo baseRuleActionRuleRelInfo, PageInfo page);
}
