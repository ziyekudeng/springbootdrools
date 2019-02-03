package com.drools.dao;

import com.drools.model.BaseRuleActionParamValueInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleActionParamValueInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface BaseRuleActionParamValueInfoMapper {

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据动作参数或动作与规则关系id获取对应的参数信息
     *
     * @param baseRuleActionParamValueInfo 参数
     */
    List<BaseRuleActionParamValueInfo> findBaseRuleActionParamValueInfoList(BaseRuleActionParamValueInfo baseRuleActionParamValueInfo);


    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据参数id获取参数value
     *
     * @param paramId 参数id
     */
    BaseRuleActionParamValueInfo findRuleParamValueByActionParamId(@Param("paramId") Long paramId);
}
