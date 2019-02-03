package com.drools.dao;

import com.drools.model.BaseRuleActionParamValueInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleActionParamValueInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 * DATE:      2017/7/24
 */
public interface BaseRuleActionParamValueInfoMapper {

    /**
     * Date 2017/7/24
     * Author gaowei
     * <p>
     * 方法说明: 根据动作参数或动作与规则关系id获取对应的参数信息
     *
     * @param baseRuleActionParamValueInfo 参数
     */
    List<BaseRuleActionParamValueInfo> findBaseRuleActionParamValueInfoList(BaseRuleActionParamValueInfo baseRuleActionParamValueInfo);


    /**
     * Date 2017/7/27
     * Author gaowei
     * <p>
     * 方法说明: 根据参数id获取参数value
     *
     * @param paramId 参数id
     */
    BaseRuleActionParamValueInfo findRuleParamValueByActionParamId(@Param("paramId") Long paramId);
}
