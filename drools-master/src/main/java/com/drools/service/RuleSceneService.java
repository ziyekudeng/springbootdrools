package com.drools.service;

import com.drools.model.BaseRuleSceneInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.drools.service.RuleSceneService
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface RuleSceneService {
    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 获取规则引擎场景集合
     *
     * @param sceneInfo 参数
     */
    List<BaseRuleSceneInfo> findBaseRuleSceneInfiList(BaseRuleSceneInfo sceneInfo);
}
