package com.drools.model.fact;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：规则全局对象
 * CLASSPATH: RuleExecutionResult
 * VERSION:   1.0
 * Created by gaowei
 * DATE:      2017/7/25
 */
@Data
public class RuleExecutionResult implements Serializable {

    //规则执行中需要保存的数据
    private Map<String,Object> map = new HashMap<>();
}
