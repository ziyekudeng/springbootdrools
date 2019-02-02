package com.drools.service;

import com.drools.model.BaseRuleSceneInfo;
import com.github.pagehelper.PageInfo;
import com.drools.model.BaseRuleActionInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.RuleActionService
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/24
 */
public interface RuleActionService {

    /**
     * Date 2017/7/24
     * Author gaowei
     * <p>
     * 方法说明: 获取动作列表
     *
     * @param baseRuleActionInfo 参数
     * @param page               分页信息
     */
    PageInfo<BaseRuleActionInfo> findBaseRuleActionInfoPage(BaseRuleActionInfo baseRuleActionInfo, PageInfo page);

    /**
     * Date 2017/7/26
     * Author gaowei
     * <p>
     * 方法说明: 根据场景获取所有的动作信息
     *
     * @param sceneInfo 参数
     */
    List<BaseRuleActionInfo> findRuleActionListByScene(BaseRuleSceneInfo sceneInfo);


    /**
     * Date 2017/7/26
     * Author gaowei
     * <p>
     * 方法说明: 根据规则id获取动作集合
     *
     * @param ruleId 参数
     */
    List<BaseRuleActionInfo> findRuleActionListByRule(final Long ruleId);

    /**
     * Date 2017/7/26
     * Author gaowei
     * <p>
     * 方法说明: 查询是否有实现类的动作
     *
     * @param ruleId 规则id
     */
    Integer findRuleActionCountByRuleIdAndActionType(final Long ruleId);
}
