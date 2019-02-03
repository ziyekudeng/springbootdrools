package com.drools.dao;

import com.drools.model.BaseRuleEntityInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleEntityInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface BaseRuleEntityInfoMapper {
    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 获取规则引擎实体信息
     *
     * @param baseRuleEntityInfo 参数
     */
    List<BaseRuleEntityInfo> findBaseRuleEntityInfoList(BaseRuleEntityInfo baseRuleEntityInfo);

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据实体id获取实体信息
     *
     * @param id 实体id
     */
    BaseRuleEntityInfo findBaseRuleEntityInfoById(@Param("id") Long id);
}
