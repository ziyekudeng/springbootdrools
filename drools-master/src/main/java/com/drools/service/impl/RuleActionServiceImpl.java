package com.drools.service.impl;

import com.drools.dao.BaseRuleActionInfoMapper;
import com.drools.exception.ExceptionEnum;
import com.drools.exception.ServiceException;
import com.drools.model.BaseRuleActionInfo;
import com.drools.model.BaseRuleSceneInfo;
import com.drools.service.RuleActionService;
import com.drools.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.drools.service.impl.RuleActionServiceImpl
 * VERSION:   1.0
 * Created by gaowei
 * DATE:
 */
@Service
public class RuleActionServiceImpl implements RuleActionService {

    @Resource
    private BaseRuleActionInfoMapper baseRuleActionInfoMapper;

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 获取动作列表
     *
     * @param baseRuleActionInfo 参数
     * @param page               分页信息
     */
    @Override
    public PageInfo<BaseRuleActionInfo> findBaseRuleActionInfoPage(BaseRuleActionInfo baseRuleActionInfo, PageInfo page) {

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<BaseRuleActionInfo> list = this.baseRuleActionInfoMapper.findBaseRuleActionInfoList(baseRuleActionInfo);
        return new PageInfo<>(list);
    }

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据场景获取所有的动作信息
     *
     * @param sceneInfo 参数
     */
    @Override
    public List<BaseRuleActionInfo> findRuleActionListByScene(BaseRuleSceneInfo sceneInfo) {
        if (null == sceneInfo || (null == sceneInfo.getSceneId() &&
                StringUtil.isNullOrNullValue(sceneInfo.getSceneIdentify()))) {
            throw new ServiceException(ExceptionEnum.REQUEST_PARAM_MISSING);
        }
        return this.baseRuleActionInfoMapper.findRuleActionListByScene(sceneInfo);
    }

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 根据规则id获取动作集合
     *
     * @param ruleId 参数
     */
    @Override
    public List<BaseRuleActionInfo> findRuleActionListByRule(final Long ruleId) {
        if (null == ruleId) {
            throw new ServiceException(ExceptionEnum.REQUEST_PARAM_MISSING);
        }

        return this.baseRuleActionInfoMapper.findRuleActionListByRule(ruleId);
    }

    /**
     * DATE:
     * Author gaowei
     * <p>
     * 方法说明: 查询是否有实现类的动作
     *
     * @param ruleId 规则id
     */
    @Override
    public Integer findRuleActionCountByRuleIdAndActionType(Long ruleId) {
        if (null == ruleId) {
            throw new ServiceException(ExceptionEnum.REQUEST_PARAM_MISSING);
        }
        return this.baseRuleActionInfoMapper.findRuleActionCountByRuleIdAndActionType(ruleId);
    }
}
