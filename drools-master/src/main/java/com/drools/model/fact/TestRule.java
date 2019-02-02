package com.drools.model.fact;

import com.drools.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 描述：
 * CLASSPATH: TestRule
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TestRule extends BaseModel {
    private String message;
    private Integer amount;
    private Integer score;
}
