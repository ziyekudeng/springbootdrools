package com.ebiz.drools.dao;

import com.ebiz.drools.model.BaseRuleEntityInfo;
import com.ebiz.drools.model.BaseRuleSceneEntityRelInfo;
import com.ebiz.drools.model.BaseRuleSceneInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleSceneEntityRelInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 *
 */
public interface BaseRuleSceneEntityRelInfoMapper {

    /**
     * Date 2017/7/24
     * Author gaowei [gaowei@sinosoft.com]
     *
     * 方法说明: 查询场景与实体关系表信息
     * @param baseRuleSceneEntityRelInfo 参数
     */
    List<BaseRuleSceneEntityRelInfo> findBaseRuleSceneEntityRelInfoList(BaseRuleSceneEntityRelInfo baseRuleSceneEntityRelInfo);


    /**
     * Date 2017/7/26
     * Author gaowei [gaowei@sinosoft.com]
     *
     * 方法说明: 根据场景信息获取相关的实体信息
     * @param baseRuleSceneInfo 参数
     */
    List<BaseRuleEntityInfo> findBaseRuleEntityListByScene(BaseRuleSceneInfo baseRuleSceneInfo);
}
