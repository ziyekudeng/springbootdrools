package com.drools.service.impl;

import com.drools.dao.BaseRuleActionParamInfoMapper;
import com.drools.exception.ExceptionEnum;
import com.drools.exception.ServiceException;
import com.drools.model.BaseRuleActionParamInfo;
import com.drools.service.RuleActionParamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.drools.service.impl.RuleActionParamServiceImpl
 * VERSION:   1.0
 * Created by gaowei
 * DATE:      2017/7/24
 */
@Service
public class RuleActionParamServiceImpl implements RuleActionParamService {

    @Resource
    private BaseRuleActionParamInfoMapper baseRuleActionParamInfoMapper;

    /**
     * Date 2017/7/24
     * Author gaowei
     * <p>
     * 方法说明: 获取动作参数信息
     *
     * @param baseRuleActionParamInfo 参数
     * @param page                    分页参数
     */
    @Override
    public PageInfo<BaseRuleActionParamInfo> findBaseRuleActionParamInfoPage(BaseRuleActionParamInfo baseRuleActionParamInfo, PageInfo page) {

        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<BaseRuleActionParamInfo> list = this.baseRuleActionParamInfoMapper.findBaseRuleActionParamInfoList(baseRuleActionParamInfo);

        return new PageInfo<>(list);
    }

    /**
     * Date 2017/7/24
     * Author gaowei
     * <p>
     * 方法说明: 根据动作id获取动作参数信息
     *
     * @param actionId 参数
     */
    @Override
    public List<BaseRuleActionParamInfo> findRuleActionParamByActionId(Long actionId) {
        if (null == actionId) {
            throw new ServiceException(ExceptionEnum.REQUEST_PARAM_MISSING);
        }
        return this.baseRuleActionParamInfoMapper.findRuleActionParamByActionId(actionId);
    }
}
