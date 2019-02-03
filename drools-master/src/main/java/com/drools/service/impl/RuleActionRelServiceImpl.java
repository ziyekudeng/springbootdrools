package com.drools.service.impl;

import com.drools.dao.BaseRuleActionRuleRelInfoMapper;
import com.drools.model.BaseRuleActionRuleRelInfo;
import com.drools.service.RuleActionRelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleActionRelServiceImpl
 * VERSION:   1.0
 * Created by gaowei
 * DATE:      2017/7/24
 */
@Service
public class RuleActionRelServiceImpl implements RuleActionRelService {

    @Resource
    private BaseRuleActionRuleRelInfoMapper baseRuleActionRuleRelInfoMapper;

    /**
     * Date 2017/7/24
     * Author gaowei
     * <p>
     * 方法说明: 获取规则与动作关系集合信息
     *
     * @param baseRuleActionRuleRelInfo 参数
     * @param page                      分页参数
     */
    @Override
    public PageInfo<BaseRuleActionRuleRelInfo> findBaseRuleActionRuleRelInfoPage(BaseRuleActionRuleRelInfo baseRuleActionRuleRelInfo, PageInfo page) {

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<BaseRuleActionRuleRelInfo> list = this.baseRuleActionRuleRelInfoMapper.findBaseRuleActionRuleRelInfoList(baseRuleActionRuleRelInfo);
        return new PageInfo<>(list);
    }
}
