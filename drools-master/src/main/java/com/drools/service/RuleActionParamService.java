package com.drools.service;

import com.drools.model.BaseRuleActionParamInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.drools.service.RuleActionParamService
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface RuleActionParamService {

    /**
     * DATE:
     * Author gaowei
     *
     * 方法说明: 获取动作参数信息
     * @param baseRuleActionParamInfo 参数
     * @param page 分页参数
     */
    PageInfo<BaseRuleActionParamInfo> findBaseRuleActionParamInfoPage(BaseRuleActionParamInfo baseRuleActionParamInfo, PageInfo page);

    /**
     * DATE:
     * Author gaowei
     *
     * 方法说明: 根据动作id获取动作参数信息
     * @param actionId 参数
     */
    List<BaseRuleActionParamInfo> findRuleActionParamByActionId(final Long actionId);
}
