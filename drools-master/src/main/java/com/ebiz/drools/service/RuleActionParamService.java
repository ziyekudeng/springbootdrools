package com.ebiz.drools.service;

import com.ebiz.drools.model.BaseRuleActionParamInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.RuleActionParamService
 * VERSION:   1.0
 * Created by gaowei
 *
 */
public interface RuleActionParamService {

    /**
     * Date 2017/7/24
     * Author gaowei [gaowei@sinosoft.com]
     *
     * 方法说明: 获取动作参数信息
     * @param baseRuleActionParamInfo 参数
     * @param page 分页参数
     */
    PageInfo<BaseRuleActionParamInfo> findBaseRuleActionParamInfoPage(BaseRuleActionParamInfo baseRuleActionParamInfo, PageInfo page);

    /**
     * Date 2017/7/24
     * Author gaowei [gaowei@sinosoft.com]
     *
     * 方法说明: 根据动作id获取动作参数信息
     * @param actionId 参数
     */
    List<BaseRuleActionParamInfo> findRuleActionParamByActionId(final Long actionId);
}
