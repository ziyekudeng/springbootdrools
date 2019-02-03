package com.drools.dao;

import com.drools.model.BaseRuleActionParamInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleActionParamInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface BaseRuleActionParamInfoMapper {

    /**
     * DATE:
     * Author gaowei
     *
     * 方法说明: 获取动作参数信息
     * @param baseRuleActionParamInfo 参数
     */
    List<BaseRuleActionParamInfo> findBaseRuleActionParamInfoList(BaseRuleActionParamInfo baseRuleActionParamInfo);

    /**
     * DATE:
     * Author gaowei
     *
     * 方法说明: 根据动作id获取动作参数信息
     * @param actionId 参数
     */
    List<BaseRuleActionParamInfo> findRuleActionParamByActionId(@Param("actionId") Long actionId);
}
