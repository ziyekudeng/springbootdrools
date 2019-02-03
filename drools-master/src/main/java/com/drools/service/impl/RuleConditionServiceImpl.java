package com.drools.service.impl;

import com.drools.dao.BaseRuleConditionInfoMapper;
import com.drools.exception.ExceptionEnum;
import com.drools.exception.ServiceException;
import com.drools.model.BaseRuleConditionInfo;
import com.drools.service.RuleConditionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.drools.service.impl.RuleConditionServiceImpl
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
@Service
public class RuleConditionServiceImpl implements RuleConditionService {

    @Resource
    private BaseRuleConditionInfoMapper baseRuleConditionInfoMapper;

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据规则获取规则条件信息
     *
     * @param baseRuleConditionInfo 参数
     * @param page                  分页参数
     */
    @Override
    public PageInfo<BaseRuleConditionInfo> findBaseRuleConditionInfoPage(BaseRuleConditionInfo baseRuleConditionInfo, PageInfo page) {

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<BaseRuleConditionInfo> list = this.baseRuleConditionInfoMapper.findBaseRuleConditionInfoList(baseRuleConditionInfo);
        return new PageInfo<>(list);
    }

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据规则id获取规则条件信息
     *
     * @param ruleId 规则id
     */
    @Override
    public List<BaseRuleConditionInfo> findRuleConditionInfoByRuleId(Long ruleId) {
        if (null == ruleId) {
            throw new ServiceException(ExceptionEnum.REQUEST_PARAM_MISSING);
        }
        return this.baseRuleConditionInfoMapper.findRuleConditionInfoByRuleId(ruleId, null);
    }
}
