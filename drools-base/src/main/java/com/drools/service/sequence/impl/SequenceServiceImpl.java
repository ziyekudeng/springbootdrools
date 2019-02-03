package com.drools.service.sequence.impl;

import com.drools.dao.sequence.ISequenceDao;
import com.drools.dao.sequence.Sequence;
import com.drools.exception.ExceptionEnum;
import com.drools.exception.ServiceException;
import com.drools.model.constant.SequenceEnum;
import com.drools.service.sequence.ISequenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 描述：
 * CLASSPATH: com.drools.cpyy.service.sequence.impl.SequenceServiceImpl
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SequenceServiceImpl implements ISequenceService {

    private final ISequenceDao sequenceDao;

    @Autowired
    public SequenceServiceImpl(ISequenceDao sequenceDao) {
        this.sequenceDao = sequenceDao;
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据序列名称获取下一个序列值
     *
     * @param seqName 序列名称
     */
    @Override
    public Integer getNextValBySeqName(SequenceEnum seqName) {
        if (null == seqName) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }

        return this.sequenceDao.getNextValBySeqName(seqName.getSeqName());
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据序列名称获取当前序列值
     *
     * @param seqName 序列名称
     */
    @Override
    public Integer getCurrValBySeqName(SequenceEnum seqName) {
        if (null == seqName) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        return this.sequenceDao.getCurrValBySeqName(seqName.getSeqName());
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据序列名称获取序列
     *
     * @param seqName 序列名称
     */
    @Override
    public Sequence findSequenceBySeqName(SequenceEnum seqName) {
        if (null == seqName) {
            throw new ServiceException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        return this.sequenceDao.findSequenceBySeqName(seqName.getSeqName());
    }

    /**
     * DATE:
     * Author gaowei
     * 方法说明: 根据序列名称获取指定区间序列值
     *
     * @param seqName 序列名
     * @param length  长度
     */
    @Override
    public List<Integer> getNextValListBySeqName(SequenceEnum seqName, Integer length) {
        //如果没有指定长度或者长度为1,则调用原获取序列方法
        if (null == length || length == 1) {
            return Collections.singletonList(getNextValBySeqName(seqName));
        }

        //获取当前序列值
        Integer currVal = getCurrValBySeqName(seqName);
        //更新序列当前值
        this.sequenceDao.initCurrValBySeqName(seqName.getSeqName(), null, null, (currVal + length));

        //序列集合
        return IntStream.rangeClosed(1, length).mapToObj(i -> currVal + i).collect(Collectors.toList());
    }

}
