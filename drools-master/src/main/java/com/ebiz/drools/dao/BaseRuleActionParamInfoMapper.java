package com.ebiz.drools.dao;

import com.ebiz.drools.model.BaseRuleActionParamInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleActionParamInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 *
 */
public interface BaseRuleActionParamInfoMapper {

    /**
     * Date 2017/7/24
     * Author gaowei [gaowei@sinosoft.com]
     *
     * 方法说明: 获取动作参数信息
     * @param baseRuleActionParamInfo 参数
     */
    List<BaseRuleActionParamInfo> findBaseRuleActionParamInfoList(BaseRuleActionParamInfo baseRuleActionParamInfo);

    /**
     * Date 2017/7/24
     * Author gaowei [gaowei@sinosoft.com]
     *
     * 方法说明: 根据动作id获取动作参数信息
     * @param actionId 参数
     */
    List<BaseRuleActionParamInfo> findRuleActionParamByActionId(@Param("actionId") Long actionId);
}
