package com.lgj.algorithm.leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 节点值的范围在32位有符号整数范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode637 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Integer> counts = new ArrayList<>();
            List<Double> sums = new ArrayList<>();
            dfs(root, 0, counts, sums);
            List<Double> averages = new ArrayList<Double>();
            int size = sums.size();
            for (int i = 0; i < size; i++) {
                averages.add(sums.get(i) / counts.get(i));
            }
            return averages;
        }

        /**
         * 前序遍历
         *
         * @param root
         * @return
         */
        public void levelOrder(TreeNode root) {
            LinkedList<TreeNode> list = new LinkedList<>();
            list.addLast(root);
            while (!list.isEmpty()) {
                TreeNode node = list.poll();
                if (node.left != null) {
                    list.addLast(node.left);
                }
                if (node.right != null) {
                    list.addLast(node.right);
                }
            }
        }

        void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
            if (root == null) {
                return;
            }
            if (level < counts.size()) {
                counts.set(level, counts.get(level) + 1);
                sums.set(level, sums.get(level) + root.val);
            } else {
                counts.add(1);
                sums.add(1.0 * root.val);
            }
            if (root.left != null) {
                dfs(root.left, level + 1, counts, sums);
            }
            if (root.right != null) {
                dfs(root.right, level + 1, counts, sums);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solution.averageOfLevels(root));
    }
}
