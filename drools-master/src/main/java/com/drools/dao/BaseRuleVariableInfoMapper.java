package com.drools.dao;

import com.drools.model.BaseRuleVariableInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleVariableInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface BaseRuleVariableInfoMapper {

    /**
     * DATE:
     * Author gaowei
     *
     * 方法说明: 根据变量类型或数值类型查询变量信息
     * @param baseRuleVariableInfo 参数
     */
    List<BaseRuleVariableInfo> findBaseRuleVariableInfoList(BaseRuleVariableInfo baseRuleVariableInfo);
}
