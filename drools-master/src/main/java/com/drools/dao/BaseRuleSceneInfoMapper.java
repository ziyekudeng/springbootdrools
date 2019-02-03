package com.drools.dao;

import com.drools.model.BaseRuleSceneInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleSceneInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 * DATE:      2017/7/20
 */
public interface BaseRuleSceneInfoMapper {

    /**
     * Date 2017/7/20
     * Author gaowei
     *
     * 方法说明: 获取规则引擎场景集合
     * @param sceneInfo 参数
     */
    List<BaseRuleSceneInfo> findBaseRuleSceneInfiList(BaseRuleSceneInfo sceneInfo);
}
