package com.drools.service.impl;

import com.drools.dao.BaseRuleVariableInfoMapper;
import com.drools.model.BaseRuleVariableInfo;
import com.drools.service.RuleVariableService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.drools.service.impl.RuleVariableServiceImpl
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
@Service
public class RuleVariableServiceImpl implements RuleVariableService {

    @Resource
    private BaseRuleVariableInfoMapper baseRuleVariableInfoMapper;

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据变量类型或数值类型获取变量集合信息
     *
     * @param baseRuleVariableInfo 参数
     * @param pageInfo             分页参数
     */
    @Override
    public List<BaseRuleVariableInfo> findBaseRuleVariableInfoList(BaseRuleVariableInfo baseRuleVariableInfo, PageInfo pageInfo) {
        return this.baseRuleVariableInfoMapper.findBaseRuleVariableInfoList(baseRuleVariableInfo);
    }
}
