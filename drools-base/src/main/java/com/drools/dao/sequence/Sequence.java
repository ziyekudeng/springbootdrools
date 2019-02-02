package com.drools.dao.sequence;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.drools.model.constant.DateTimeConstant;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：
 * CLASSPATH: Sequence
 * VERSION:   1.0
 * Created by lihao
 * DATE: 2018/8/30
 */
@Data
public class Sequence implements Serializable {

    private String seqName;
    private Integer currentVal;
    private Integer incrementVal;
    private Integer currYear;
    private Integer currMonth;
    @JsonFormat(pattern = DateTimeConstant.DATE_TIME, timezone = "GMT+8")
    private Date creTime;
}
