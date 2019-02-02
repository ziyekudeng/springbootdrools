package com.ebiz.drools.dao;

import com.ebiz.drools.model.BaseRuleActionRuleRelInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleActionRuleRelInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 *
 */
public interface BaseRuleActionRuleRelInfoMapper {

    /**
     * Date 2017/7/24
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 获取规则与动作关系集合信息
     *
     * @param baseRuleActionRuleRelInfo 参数
     */
    List<BaseRuleActionRuleRelInfo> findBaseRuleActionRuleRelInfoList(BaseRuleActionRuleRelInfo baseRuleActionRuleRelInfo);
}
