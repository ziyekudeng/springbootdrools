package com.ebiz.drools.service.impl;

import com.ebiz.drools.dao.BaseRuleConditionInfoMapper;
import com.ebiz.drools.exception.ExceptionEnum;
import com.ebiz.drools.exception.ServiceException;
import com.ebiz.drools.model.BaseRuleConditionInfo;
import com.ebiz.drools.service.RuleConditionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleConditionServiceImpl
 * VERSION:   1.0
 * Created by gaowei
 *
 */
@Service
public class RuleConditionServiceImpl implements RuleConditionService {

    @Resource
    private BaseRuleConditionInfoMapper baseRuleConditionInfoMapper;

    /**
     * Date 2017/7/24
     * Author gaowei [gaowei@sinosoft.com]
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
     * Date 2017/7/26
     * Author gaowei [gaowei@sinosoft.com]
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
