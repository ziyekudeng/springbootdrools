package com.drools.dao;

import com.drools.model.BaseRuleEntityInfo;
import com.drools.model.BaseRuleSceneEntityRelInfo;
import com.drools.model.BaseRuleSceneInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleSceneEntityRelInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface BaseRuleSceneEntityRelInfoMapper {

    /**
     * DATE:
     * Author gaowei
     *
     * 方法说明: 查询场景与实体关系表信息
     * @param baseRuleSceneEntityRelInfo 参数
     */
    List<BaseRuleSceneEntityRelInfo> findBaseRuleSceneEntityRelInfoList(BaseRuleSceneEntityRelInfo baseRuleSceneEntityRelInfo);


    /**
     * DATE:
     * Author gaowei
     *
     * 方法说明: 根据场景信息获取相关的实体信息
     * @param baseRuleSceneInfo 参数
     */
    List<BaseRuleEntityInfo> findBaseRuleEntityListByScene(BaseRuleSceneInfo baseRuleSceneInfo);
}
