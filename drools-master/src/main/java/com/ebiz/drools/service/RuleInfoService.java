package com.ebiz.drools.service;

import com.ebiz.drools.model.BaseRuleInfo;
import com.ebiz.drools.model.BaseRulePropertyInfo;
import com.ebiz.drools.model.BaseRulePropertyRelInfo;
import com.ebiz.drools.model.BaseRuleSceneInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.RuleInfoService
 * VERSION:   1.0
 * Created by gaowei
 *
 */
public interface RuleInfoService {

    /**
     * Date 2017/7/25
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 获取规则集合信息
     *
     * @param baseRuleInfo 参数
     * @param page         分页参数
     */
    PageInfo<BaseRuleInfo> findBaseRuleInfoPage(BaseRuleInfo baseRuleInfo, PageInfo page);

    /**
     * Date 2017/7/25
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 查询规则属性信息
     *
     * @param baseRulePropertyInfo 参数
     */
    List<BaseRulePropertyInfo> findBaseRulePropertyInfoList(BaseRulePropertyInfo baseRulePropertyInfo);

    /**
     * Date 2017/7/25
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 根据规则获取已经配置的属性信息
     *
     * @param ruleId 参数
     */
    List<BaseRulePropertyRelInfo> findRulePropertyListByRuleId(final Long ruleId);

    /**
     * Date 2017/7/26
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 根据场景获取对应的规则规则信息
     *
     * @param baseRuleSceneInfo 参数
     */
    List<BaseRuleInfo> findBaseRuleListByScene(BaseRuleSceneInfo baseRuleSceneInfo);
}
