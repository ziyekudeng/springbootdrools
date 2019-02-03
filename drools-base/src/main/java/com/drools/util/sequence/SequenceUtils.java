package com.drools.util.sequence;

import com.drools.exception.ExceptionEnum;
import com.drools.exception.ServiceException;
import com.drools.model.constant.SequenceEnum;
import com.drools.service.sequence.ISequenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sinosoft.cpyy.util.sequence.SequenceUtils
 * VERSION:   1.0
 * Created by gaowei
 * DATE: 2018/3/12
 */
@Slf4j
@Component
public class SequenceUtils {

    private static ISequenceService sequenceService;

    public SequenceUtils(ISequenceService seqService) {
        sequenceService = seqService;
    }


    /**
     * Date 2018/3/12
     * Author gaowei
     * 方法说明: 根据序列名称获取下一个序列值
     *
     * @param seqName 序列名称
     */
    public static Integer getNextValBySeqName(SequenceEnum seqName) {
        if (null == seqName) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        return sequenceService.getNextValBySeqName(seqName);
    }

    /**
     * Date 2018/3/12
     * Author gaowei
     * 方法说明: 根据序列名称获取当前序列值
     *
     * @param seqName 序列名称
     */
    public static Integer getCurrValBySeqName(SequenceEnum seqName) {
        if (null == seqName) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        return sequenceService.getCurrValBySeqName(seqName);
    }

    /**
     * Date 2018/7/4
     * Author gaowei
     * 方法说明: 根据序列名称获取指定区间序列值
     *
     * @param seqName 序列名
     * @param length  长度
     */
    public static List<Integer> getNextValListBySeqName(SequenceEnum seqName, Integer length) {
        if (null == seqName) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        return sequenceService.getNextValListBySeqName(seqName, length);
    }
}
