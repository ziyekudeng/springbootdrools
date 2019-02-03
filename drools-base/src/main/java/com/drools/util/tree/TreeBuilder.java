package com.drools.util.tree;

import com.drools.exception.ExceptionEnum;
import com.drools.exception.UtilsException;
import com.drools.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：java构建树工具类
 * CLASSPATH: com.sinosoft.cpyy.util.tree.TreeBuilder
 * VERSION:   1.0
 * Created by gaowei
 * DATE:      2017/10/13
 */
public class TreeBuilder {

    //默认根节点ID
    private static final Integer ROOT = 0;

    private TreeBuilder() {
    }

    /**
     * Date 2017/10/13
     * Author gaowei
     * <p>
     * 方法说明: 两层循环实现建树
     *
     * @param treeNodes 传入的树节点列表
     */
    public static List<TreeNode> bulid(List<TreeNode> treeNodes) {
        //默认根节点为0
        return bulid(treeNodes, ROOT);
    }

    /**
     * Date 2017/10/13
     * Author gaowei
     * <p>
     * 方法说明: 两层循环实现建树
     *
     * @param rootId    根节点ID
     * @param treeNodes 传入的树节点列表
     */
    public static List<TreeNode> bulid(List<TreeNode> treeNodes, Integer rootId) {
        //判断参数
        if (null == treeNodes || treeNodes.isEmpty()) {
            return new ArrayList<>();
        }
        //根节点不能为空
        if (null == rootId) {
            throw new UtilsException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        //最终结果树
        List<TreeNode> trees = new ArrayList<>();
        //已处理过的菜单
        List<Integer> ids = new ArrayList<>();

        findTreeNodeInfo(treeNodes, rootId, trees, ids);
        //循环判断是否所有数据都已经处理过
        for (TreeNode fun : treeNodes) {
            if (!ids.contains(fun.getNodeId())) {
                trees.add(fun);
            }
        }
        return trees;
    }

    private static void findTreeNodeInfo(List<TreeNode> treeNodes, Integer rootId, List<TreeNode> trees, List<Integer> ids) {
        for (TreeNode treeNode : treeNodes) {
            //判断第一层级
            if (treeNode.getParentId().equals(rootId)) {
                trees.add(treeNode);
                //添加到已处理数据里
                ids.add(treeNode.getNodeId());
            }
            //查询子集
            for (TreeNode it : treeNodes) {
                if (it.getParentId().equals(treeNode.getNodeId())) {
                    if (treeNode.getChildList() == null) {
                        treeNode.setChildList(new ArrayList<>());
                    }
                    //添加到已处理数据里
                    ids.add(it.getNodeId());
                    treeNode.getChildList().add(it);
                }
            }
        }
    }


    /**
     * Date 2017/10/13
     * Author gaowei
     * <p>
     * 方法说明: 使用递归方法建树
     *
     * @param treeNodes 传入的树节点列表
     */
    public static List<TreeNode> buildByRecursive(List<TreeNode> treeNodes) {
        return buildByRecursive(treeNodes, ROOT);
    }

    /**
     * Date 2017/10/13
     * Author gaowei
     * <p>
     * 方法说明: 使用递归方法建树
     *
     * @param treeNodes 传入的树节点列表
     * @param rootId    根节点ID
     */
    public static List<TreeNode> buildByRecursive(List<TreeNode> treeNodes, Integer rootId) {
        //判断参数
        if (null == treeNodes || treeNodes.isEmpty()) {
            return new ArrayList<>();
        }
        //根节点不能为空
        if (null == rootId) {
            throw new UtilsException(ExceptionEnum.SYS_REQUEST_PARAM_MISSING);
        }
        //新的树
        List<TreeNode> trees = new ArrayList<>();
        for (TreeNode treeNode : treeNodes) {
            if (treeNode.getParentId().equals(rootId)) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }


    /**
     * Date 2017/10/13
     * Author gaowei
     * <p>
     * 方法说明: 递归查找子节点
     *
     * @param treeNode  父节点
     * @param treeNodes 传入的树节点列表
     */
    private static TreeNode findChildren(TreeNode treeNode, List<TreeNode> treeNodes) {
        for (TreeNode it : treeNodes) {
            if (treeNode.getNodeId().equals(it.getParentId())) {
                if (treeNode.getChildList() == null) {
                    treeNode.setChildList(new ArrayList<>());
                }
                treeNode.getChildList().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }
}
