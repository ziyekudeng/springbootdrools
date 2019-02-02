package com.ebiz.drools.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述：
 * CLASSPATH: BaseRuleActionRuleRelInfo
 * VERSION:   1.0
 * Created by gaowei
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseRuleActionRuleRelInfo extends BaseModel {
    private Long ruleActionRelId;//主键
    private Long actionId;//动作
    private Long ruleId;//规则
}
