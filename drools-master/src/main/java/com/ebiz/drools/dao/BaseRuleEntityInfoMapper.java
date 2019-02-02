package com.ebiz.drools.dao;

import com.ebiz.drools.model.BaseRuleEntityInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: BaseRuleEntityInfoMapper
 * VERSION:   1.0
 * Created by gaowei
 *
 */
public interface BaseRuleEntityInfoMapper {
    /**
     * Date 2017/7/20
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 获取规则引擎实体信息
     *
     * @param baseRuleEntityInfo 参数
     */
    List<BaseRuleEntityInfo> findBaseRuleEntityInfoList(BaseRuleEntityInfo baseRuleEntityInfo);

    /**
     * Date 2017/7/26
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 根据实体id获取实体信息
     *
     * @param id 实体id
     */
    BaseRuleEntityInfo findBaseRuleEntityInfoById(@Param("id") Long id);
}
