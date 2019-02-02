package com.ebiz.drools.service.impl;

import com.ebiz.drools.dao.BaseRuleSceneEntityRelInfoMapper;
import com.ebiz.drools.exception.ExceptionEnum;
import com.ebiz.drools.exception.ServiceException;
import com.ebiz.drools.model.BaseRuleEntityInfo;
import com.ebiz.drools.model.BaseRuleSceneEntityRelInfo;
import com.ebiz.drools.model.BaseRuleSceneInfo;
import com.ebiz.drools.service.RuleSceneEntityRelService;
import com.ebiz.drools.util.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleSceneEntityRelServiceImpl
 * VERSION:   1.0
 * Created by gaowei
 *
 */
@Service
public class RuleSceneEntityRelServiceImpl implements RuleSceneEntityRelService {

    @Resource
    private BaseRuleSceneEntityRelInfoMapper baseRuleSceneEntityRelInfoMapper;


    /**
     * Date 2017/7/24
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 查询场景与实体关系表信息
     *
     * @param baseRuleSceneEntityRelInfo 参数
     * @param page                       分页参数
     */
    @Override
    public List<BaseRuleSceneEntityRelInfo> findBaseRuleSceneEntityRelInfoList(BaseRuleSceneEntityRelInfo baseRuleSceneEntityRelInfo, PageInfo page) {
        return this.baseRuleSceneEntityRelInfoMapper.findBaseRuleSceneEntityRelInfoList(baseRuleSceneEntityRelInfo);
    }

    /**
     * Date 2017/7/26
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 根据场景信息获取相关的实体信息
     *
     * @param baseRuleSceneInfo 参数
     */
    @Override
    public List<BaseRuleEntityInfo> findBaseRuleEntityListByScene(BaseRuleSceneInfo baseRuleSceneInfo)  {
        //判断参数
        if (null == baseRuleSceneInfo || (StringUtil.isNullOrNullValue(baseRuleSceneInfo.getSceneIdentify()) &&
                null == baseRuleSceneInfo.getSceneId())) {
            throw new ServiceException(ExceptionEnum.REQUEST_PARAM_MISSING);
        }
        //查询数据
        return this.baseRuleSceneEntityRelInfoMapper.findBaseRuleEntityListByScene(baseRuleSceneInfo);
    }
}
