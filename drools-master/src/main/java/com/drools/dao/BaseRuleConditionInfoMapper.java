package com.drools.dao;

import com.drools.model.BaseRuleConditionInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleConditionInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface BaseRuleConditionInfoMapper {

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据规则获取规则条件信息
     *
     * @param baseRuleConditionInfo 参数
     */
    List<BaseRuleConditionInfo> findBaseRuleConditionInfoList(BaseRuleConditionInfo baseRuleConditionInfo);

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据规则获取对应的条件信息
     *
     * @param ruleId 规则id
     */
    List<BaseRuleConditionInfo> findRuleConditionInfoByRuleId(@Param("ruleId") Long ruleId, @Param("relFlag") Integer relFlag);
}
