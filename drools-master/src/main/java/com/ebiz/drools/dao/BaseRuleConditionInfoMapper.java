package com.ebiz.drools.dao;

import com.ebiz.drools.model.BaseRuleConditionInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleConditionInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 *
 */
public interface BaseRuleConditionInfoMapper {

    /**
     * Date 2017/7/24
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 根据规则获取规则条件信息
     *
     * @param baseRuleConditionInfo 参数
     */
    List<BaseRuleConditionInfo> findBaseRuleConditionInfoList(BaseRuleConditionInfo baseRuleConditionInfo);

    /**
     * Date 2017/7/26
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 根据规则获取对应的条件信息
     *
     * @param ruleId 规则id
     */
    List<BaseRuleConditionInfo> findRuleConditionInfoByRuleId(@Param("ruleId") Long ruleId, @Param("relFlag") Integer relFlag);
}
