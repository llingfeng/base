package com.app;

import java.util.*;

/**
 * Created by admin on 2016/11/11.
 * 多叉树路径
 */
public class Tree {

    public static Map<Integer, TreeNode> map = new HashMap<>();

    public static void main(String args[]) {
        Tree test = new Tree();
        test.createTree();//创建多叉树
        //1-a,2-b,3-c,4-d,5-e,6-f,7-g,8-h,9-i
        TreeNode treeNode1 = map.get(4);//d节点
        TreeNode treeNode2 = map.get(8);//h节点
        String way = test.getWay(treeNode1, treeNode2);//得到路径
        System.out.print(treeNode1.name+"节点到"+treeNode2.name+"节点路径为："+way);
    }

    /**
     * 路径
     *
     * @param fromNode  开始节点
     * @param toNode    结束节点
     * @return
     */
    public String getWay(TreeNode fromNode, TreeNode toNode) {
        List<TreeNode> fromList = getParents(fromNode, new ArrayList<>());
        List<TreeNode> toList = getParents(toNode, new ArrayList<>());
        Collections.reverse(fromList);
        Collections.reverse(toList);
        int fromEnd = 0;
        int toEnd = 0;
        StringBuilder sb = new StringBuilder();
        if (fromList.contains(toNode)) {//开始节点的父节点包含结束节点(包括结束节点为祖先节点)
            sb.append(fromNode.name);
            for (int i = 0; i <= fromList.indexOf(toNode); i++) {
                sb.append(fromList.get(i).name);
            }
        } else if (toList.contains(fromNode)) {//结束节点的父节点包含开始节点（包括开始节点为祖先节点）
            for (int i = toList.indexOf(fromNode); i >= 0; i--) {
                sb.append(toList.get(i).name);
            }
            sb.append(toNode.name);
        } else if (fromList != null && fromList.size() > 0 && toList != null && toList.size() > 0) {
            outterLoop:
            for (int i = 0; i < fromList.size(); i++) {
                for (int j = 0; j < toList.size(); j++) {
                    if (fromList.get(i) == toList.get(j)) {
                        fromEnd = i;
                        toEnd = j;
                        break outterLoop;
                    }
                }
            }
            sb.append(fromNode.name);
            for (int i = 0; i < fromEnd; i++) {
                sb.append(fromList.get(i).name);
            }
            for (int i = toEnd; i >= 0; i--) {
                sb.append(toList.get(i).name);
            }
            sb.append(toNode.name);
        }
        return sb.toString();
    }

    /**
     * 创建多叉树
     *           a
     *         b   c
     *       d       e
     *     f   g   h    i
     */
    public void createTree() {
        TreeNode nodeA = new TreeNode(1, 0, "a");//根节点
        TreeNode nodeB = new TreeNode(2, 1, "b");
        TreeNode nodeC = new TreeNode(3, 1, "c");
        TreeNode nodeD = new TreeNode(4, 2, "d");
        TreeNode nodeE = new TreeNode(5, 3, "e");
        TreeNode nodeF = new TreeNode(6, 4, "f");
        TreeNode nodeG = new TreeNode(7, 4, "g");
        TreeNode nodeH = new TreeNode(8, 5, "h");
        TreeNode nodeI = new TreeNode(9, 5, "i");
        map.put(nodeA.id, nodeA);
        map.put(nodeB.id, nodeB);
        map.put(nodeC.id, nodeC);
        map.put(nodeD.id, nodeD);
        map.put(nodeE.id, nodeE);
        map.put(nodeF.id, nodeF);
        map.put(nodeG.id, nodeG);
        map.put(nodeH.id, nodeH);
        map.put(nodeI.id, nodeI);
    }

    /**
     * 得到所有父类元素
     *
     * @param node
     * @param list
     * @return
     */
    public List<TreeNode> getParents(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return null;
        }
        int parentId = node.parentId;
        TreeNode treeNode = map.get(parentId);
        getParents(treeNode, list);
        if (treeNode != null) {
            list.add(treeNode);
        }
        return list;
    }

    /**
     * 节点内部类
     */
    public class TreeNode {
        int id;
        int parentId;
        String name;
        Map<Integer, TreeNode> childs = new HashMap<>();

        public TreeNode(int id, int parentId, String name) {
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }

        public String toString() {
            return id + name;
        }
    }
}
