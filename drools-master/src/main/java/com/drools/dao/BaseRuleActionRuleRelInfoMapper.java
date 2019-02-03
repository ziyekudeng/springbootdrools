package com.drools.dao;

import com.drools.model.BaseRuleActionRuleRelInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleActionRuleRelInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface BaseRuleActionRuleRelInfoMapper {

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 获取规则与动作关系集合信息
     *
     * @param baseRuleActionRuleRelInfo 参数
     */
    List<BaseRuleActionRuleRelInfo> findBaseRuleActionRuleRelInfoList(BaseRuleActionRuleRelInfo baseRuleActionRuleRelInfo);
}
