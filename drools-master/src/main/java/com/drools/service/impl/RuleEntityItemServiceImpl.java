package com.drools.service.impl;

import com.drools.dao.BaseRuleEntityItemInfoMapper;
import com.drools.exception.ExceptionEnum;
import com.drools.exception.ServiceException;
import com.drools.model.BaseRuleEntityItemInfo;
import com.drools.service.RuleEntityItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleEntityItemServiceImpl
 * VERSION:   1.0
 * Created by gaowei
 * DATE:      2017/7/20
 */
@Service
public class RuleEntityItemServiceImpl implements RuleEntityItemService {

    @Resource
    private BaseRuleEntityItemInfoMapper baseRuleEntityItemInfoMapper;

    /**
     * Date 2017/7/20
     * Author gaowei
     * <p>
     * 方法说明: 根据实体id获取规则引擎实体属性信息
     *
     * @param baseRuleEntityItemInfo 参数
     */
    @Override
    public List<BaseRuleEntityItemInfo> findBaseRuleEntityItemInfoList(BaseRuleEntityItemInfo baseRuleEntityItemInfo) {
        return this.baseRuleEntityItemInfoMapper.findBaseRuleEntityItemInfoList(baseRuleEntityItemInfo);
    }

    /**
     * Date 2017/7/26
     * Author gaowei
     * <p>
     * 方法说明: 根据id获取对应的属性信息
     *
     * @param id 属性Id
     */
    @Override
    public BaseRuleEntityItemInfo findBaseRuleEntityItemInfoById(Long id) {
        if (null == id) {
            throw new ServiceException(ExceptionEnum.REQUEST_PARAM_MISSING);
        }
        return this.baseRuleEntityItemInfoMapper.findBaseRuleEntityItemInfoById(id);
    }
}
