package com.drools.service;

import com.drools.model.BaseRuleInfo;
import com.drools.model.BaseRulePropertyInfo;
import com.drools.model.BaseRulePropertyRelInfo;
import com.drools.model.BaseRuleSceneInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.drools.service.RuleInfoService
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface RuleInfoService {

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 获取规则集合信息
     *
     * @param baseRuleInfo 参数
     * @param page         分页参数
     */
    PageInfo<BaseRuleInfo> findBaseRuleInfoPage(BaseRuleInfo baseRuleInfo, PageInfo page);

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 查询规则属性信息
     *
     * @param baseRulePropertyInfo 参数
     */
    List<BaseRulePropertyInfo> findBaseRulePropertyInfoList(BaseRulePropertyInfo baseRulePropertyInfo);

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据规则获取已经配置的属性信息
     *
     * @param ruleId 参数
     */
    List<BaseRulePropertyRelInfo> findRulePropertyListByRuleId(final Long ruleId);

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据场景获取对应的规则规则信息
     *
     * @param baseRuleSceneInfo 参数
     */
    List<BaseRuleInfo> findBaseRuleListByScene(BaseRuleSceneInfo baseRuleSceneInfo);
}
