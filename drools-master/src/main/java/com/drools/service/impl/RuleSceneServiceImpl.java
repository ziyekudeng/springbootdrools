package com.drools.service.impl;

import com.drools.model.BaseRuleSceneInfo;
import com.drools.service.RuleSceneService;
import com.drools.dao.BaseRuleSceneInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：
 * CLASSPATH: com.sky.bluesky.service.impl.RuleSceneServiceImpl
 * VERSION:   1.0
 * Created by lihao
 * DATE:      2017/7/20
 */
@Service
public class RuleSceneServiceImpl implements RuleSceneService {

    @Resource
    private BaseRuleSceneInfoMapper baseRuleSceneInfoMapper;
    /**
     * Date 2017/7/20
     * Author gaowei
     * <p>
     * 方法说明: 获取规则引擎场景集合
     *
     * @param sceneInfo 参数
     */
    @Override
    public List<BaseRuleSceneInfo> findBaseRuleSceneInfiList(BaseRuleSceneInfo sceneInfo)  {
        return this.baseRuleSceneInfoMapper.findBaseRuleSceneInfiList(sceneInfo);
    }
}
