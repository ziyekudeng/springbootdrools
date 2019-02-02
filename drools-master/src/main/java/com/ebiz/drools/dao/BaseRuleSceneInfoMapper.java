package com.ebiz.drools.dao;

import com.ebiz.drools.model.BaseRuleSceneInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleSceneInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 *
 */
public interface BaseRuleSceneInfoMapper {

    /**
     * Date 2017/7/20
     * Author gaowei [gaowei@sinosoft.com]
     *
     * 方法说明: 获取规则引擎场景集合
     * @param sceneInfo 参数
     */
    List<BaseRuleSceneInfo> findBaseRuleSceneInfiList(BaseRuleSceneInfo sceneInfo);
}
