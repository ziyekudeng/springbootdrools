package com.drools.service;

import com.drools.model.BaseRuleSceneEntityRelInfo;
import com.drools.model.BaseRuleSceneInfo;
import com.github.pagehelper.PageInfo;
import com.drools.model.BaseRuleEntityInfo;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.RuleSceneEntityRelService
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/24
 */
public interface RuleSceneEntityRelService {

    /**
     * Date 2017/7/24
     * Author gaowei
     * <p>
     * 方法说明: 查询场景与实体关系表信息
     *
     * @param baseRuleSceneEntityRelInfo 参数
     * @param page                       分页参数
     */
    List<BaseRuleSceneEntityRelInfo> findBaseRuleSceneEntityRelInfoList(BaseRuleSceneEntityRelInfo baseRuleSceneEntityRelInfo, PageInfo page);

    /**
     * Date 2017/7/26
     * Author gaowei
     * <p>
     * 方法说明: 根据场景信息获取相关的实体信息
     *
     * @param baseRuleSceneInfo 参数
     */
    List<BaseRuleEntityInfo> findBaseRuleEntityListByScene(BaseRuleSceneInfo baseRuleSceneInfo);
}
