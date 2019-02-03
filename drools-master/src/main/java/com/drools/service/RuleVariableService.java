package com.drools.service;

import com.drools.model.BaseRuleVariableInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.drools.service.RuleVariableService
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface RuleVariableService {

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据变量类型或数值类型获取变量集合信息
     *
     * @param baseRuleVariableInfo 参数
     * @param pageInfo             分页参数
     */
    List<BaseRuleVariableInfo> findBaseRuleVariableInfoList(BaseRuleVariableInfo baseRuleVariableInfo, PageInfo pageInfo);
}
