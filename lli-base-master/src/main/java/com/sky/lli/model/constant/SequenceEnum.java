package com.sky.lli.model.constant;

import lombok.Getter;

import java.beans.ConstructorProperties;
//自定义序列枚举
public enum SequenceEnum {

    //批次号
    SEQ_BATCH_NO("SEQ_BATCH_NO");


    @Getter
    private String seqName;

    @ConstructorProperties({"seqName"})
    SequenceEnum(String seqName) {
        this.seqName = seqName;
    }
}
