package com.ebiz.drools.dao.sequence;

import com.ebiz.drools.model.constant.DateTimeConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：
 * CLASSPATH: Sequence
 * VERSION:   1.0
 * Created by gaowei
 *
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
