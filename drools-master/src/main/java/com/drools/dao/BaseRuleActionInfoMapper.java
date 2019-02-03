package com.drools.dao;

import com.drools.model.BaseRuleActionInfo;
import com.drools.model.BaseRuleSceneInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleActionInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface BaseRuleActionInfoMapper {

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 获取动作列表
     *
     * @param baseRuleActionInfo 参数
     */
    List<BaseRuleActionInfo> findBaseRuleActionInfoList(BaseRuleActionInfo baseRuleActionInfo);

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据场景获取所有的动作信息
     *
     * @param sceneInfo 参数
     */
    List<BaseRuleActionInfo> findRuleActionListByScene(BaseRuleSceneInfo sceneInfo);


    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据规则id获取动作集合
     *
     * @param ruleId 参数
     */
    List<BaseRuleActionInfo> findRuleActionListByRule(@Param("ruleId") Long ruleId);

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 查询是否有实现类的动作
     *
     * @param ruleId 规则id
     */
    Integer findRuleActionCountByRuleIdAndActionType(@Param("ruleId") Long ruleId);

}
