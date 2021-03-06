package com.drools.service.sequence;

import com.drools.dao.sequence.Sequence;
import com.drools.model.constant.SequenceEnum;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.drools.cpyy.service.sequence.ISequenceService
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
public interface ISequenceService {

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据序列名称获取下一个序列值
     *
     * @param seqName 序列名称
     */
    Integer getNextValBySeqName(SequenceEnum seqName);

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据序列名称获取当前序列值
     *
     * @param seqName 序列名称
     */
    Integer getCurrValBySeqName(SequenceEnum seqName);

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据序列名称获取序列
     *
     * @param seqName 序列名称
     */
    Sequence findSequenceBySeqName(SequenceEnum seqName);

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据序列名称获取指定区间序列值
     *
     * @param seqName 序列名
     * @param length  长度
     */
    List<Integer> getNextValListBySeqName(SequenceEnum seqName, Integer length);

}
