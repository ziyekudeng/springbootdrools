package com.ebiz.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * CLASSPATH: BaseRulePropertyRelInfo
 * VERSION:   1.0
 * Created by gaowei
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRulePropertyRelInfo extends BaseRulePropertyInfo {
    private Long ruleProRelId;//主键
    private Long ruleId;//规则
    private Long rulePropertyId;//规则属性
    private String rulePropertyValue;//属性值
}
