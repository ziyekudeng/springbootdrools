package com.drools.dao.sequence;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 描述：
 * CLASSPATH: com.sinosoft.cpyy.dao.master.sequence.ISequenceDao
 * VERSION:   1.0
 * Created by lihao
 * DATE: 2018/3/12
 */
public interface ISequenceDao {

    /**
     * Date 2018/3/12
     * Author gaowei
     * 方法说明: 根据序列名称获取下一个序列值
     *
     * @param seqName 序列名称
     */
    @Select(" SELECT NEXTVAL(#{seqName}) ")
    Integer getNextValBySeqName(@Param("seqName") String seqName);

    /**
     * Date 2018/3/12
     * Author gaowei
     * 方法说明: 根据序列名称获取当前序列值
     *
     * @param seqName 序列名称
     */
    @Select(" SELECT CURRVAL(#{seqName}) ")
    Integer getCurrValBySeqName(@Param("seqName") String seqName);

    /**
     * Date 2018/3/12
     * Author gaowei
     * 方法说明: 根据序列名称初始化当前序列值和当前年月日
     *
     * @param seqName  序列名称
     * @param currYear 当前年
     * @param currMM   当前月
     * @param currVal  当前值
     */
    @Update("UPDATE SEQUENCE T  SET T.CURR_YEAR = #{currYear} ,T.CURR_MONTH = #{currMM} ,T.CURRENT_VAL = #{currVal} WHERE T.SEQ_NAME = #{seqName}")
    void initCurrValBySeqName(@Param("seqName") String seqName, @Param("currYear") Integer currYear,
                              @Param("currMM") Integer currMM, @Param("currVal") Integer currVal);

    /**
     * Date 2018/8/30
     * Author gaowei
     * 方法说明: 根据序列名称获取序列
     *
     * @param seqName 序列名称
     */
    @Select("SELECT * from SEQUENCE T WHERE T.SEQ_NAME = #{seqName}")
    Sequence findSequenceBySeqName(@Param("seqName") String seqName);
}
