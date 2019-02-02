package com.ebiz.drools.service.impl;

import com.ebiz.drools.dao.BaseRuleEntityInfoMapper;
import com.ebiz.drools.exception.ExceptionEnum;
import com.ebiz.drools.exception.ServiceException;
import com.ebiz.drools.model.BaseRuleEntityInfo;
import com.ebiz.drools.service.RuleEntityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleEntityServiceImpl
 * VERSION:   1.0
 * Created by gaowei
 *
 */
@Service
public class RuleEntityServiceImpl implements RuleEntityService {

    @Resource
    private BaseRuleEntityInfoMapper baseRuleEntityInfoMapper;


    /**
     * Date 2017/7/20
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 获取规则引擎实体信息
     *
     * @param baseRuleEntityInfo 参数
     */
    @Override
    public List<BaseRuleEntityInfo> findBaseRuleEntityInfoList(BaseRuleEntityInfo baseRuleEntityInfo) {
        return this.baseRuleEntityInfoMapper.findBaseRuleEntityInfoList(baseRuleEntityInfo);
    }

    /**
     * Date 2017/7/26
     * Author gaowei [gaowei@sinosoft.com]
     * <p>
     * 方法说明: 根据实体id获取实体信息
     *
     * @param id 实体id
     */
    @Override
    public BaseRuleEntityInfo findBaseRuleEntityInfoById(Long id) {
        if (null == id) {
            throw new ServiceException(ExceptionEnum.REQUEST_PARAM_MISSING);
        }
        return this.baseRuleEntityInfoMapper.findBaseRuleEntityInfoById(id);
    }
}
