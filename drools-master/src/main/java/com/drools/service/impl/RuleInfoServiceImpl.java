package com.drools.service.impl;

import com.drools.dao.BaseRuleInfoMapper;
import com.drools.exception.ExceptionEnum;
import com.drools.exception.ServiceException;
import com.drools.model.BaseRuleInfo;
import com.drools.model.BaseRulePropertyInfo;
import com.drools.model.BaseRulePropertyRelInfo;
import com.drools.model.BaseRuleSceneInfo;
import com.drools.service.RuleInfoService;
import com.drools.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.drools.service.impl.RuleInfoServiceImpl
 * VERSION:   1.0
 * Created by gaowei
 * DATE:      2017/7/25
 */
@Service
public class RuleInfoServiceImpl implements RuleInfoService {

    @Resource
    private BaseRuleInfoMapper baseRuleInfoMapper;

    /**
     * Date 2017/7/25
     * Author gaowei
     * <p>
     * 方法说明: 获取规则集合信息
     *
     * @param baseRuleInfo 参数
     * @param page         分页参数
     */
    @Override
    public PageInfo<BaseRuleInfo> findBaseRuleInfoPage(BaseRuleInfo baseRuleInfo, PageInfo page) {

        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<BaseRuleInfo> list = this.baseRuleInfoMapper.findBaseRuleInfoList(baseRuleInfo);
        return new PageInfo<>(list);
    }

    /**
     * Date 2017/7/25
     * Author gaowei
     * <p>
     * 方法说明: 查询规则属性信息
     *
     * @param baseRulePropertyInfo 参数
     */
    @Override
    public List<BaseRulePropertyInfo> findBaseRulePropertyInfoList(BaseRulePropertyInfo baseRulePropertyInfo) {
        return this.baseRuleInfoMapper.findBaseRulePropertyInfoList(baseRulePropertyInfo);
    }

    /**
     * Date 2017/7/25
     * Author gaowei
     * <p>
     * 方法说明: 根据规则获取已经配置的属性信息
     *
     * @param ruleId 参数
     */
    @Override
    public List<BaseRulePropertyRelInfo> findRulePropertyListByRuleId(final Long ruleId) {
        return this.baseRuleInfoMapper.findRulePropertyListByRuleId(ruleId);
    }

    /**
     * Date 2017/7/26
     * Author gaowei
     * <p>
     * 方法说明: 根据场景获取对应的规则规则信息
     *
     * @param baseRuleSceneInfo 参数
     */
    @Override
    public List<BaseRuleInfo> findBaseRuleListByScene(BaseRuleSceneInfo baseRuleSceneInfo) {
        if (null == baseRuleSceneInfo || (null == baseRuleSceneInfo.getSceneId() &&
                StringUtil.isNullOrNullValue(baseRuleSceneInfo.getSceneIdentify()))) {
            throw new ServiceException(ExceptionEnum.REQUEST_PARAM_MISSING);
        }

        return this.baseRuleInfoMapper.findBaseRuleListByScene(baseRuleSceneInfo);
    }
}
