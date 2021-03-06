package com.drools.service;

import com.drools.model.BaseRuleEntityInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: RuleEntityService
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface RuleEntityService {

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 获取规则引擎实体信息
     *
     * @param baseRuleEntityInfo 参数
     */
    List<BaseRuleEntityInfo> findBaseRuleEntityInfoList(BaseRuleEntityInfo baseRuleEntityInfo);

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据实体id获取实体信息
     *
     * @param id 实体id
     */
    BaseRuleEntityInfo findBaseRuleEntityInfoById(final Long id);
}
