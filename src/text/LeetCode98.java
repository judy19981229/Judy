package text;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        //二叉树中序遍历，左根右之后应该是递增的，所以如果当前节点的val小于前一个节点的val就不是搜索树
        Deque<TreeNode> stack = new LinkedList<>();
        //第一个pre应该是一个最小值，中序遍历之后第一个节点应该是大于这个最小值的，不然第一个节点没法判断
        long pre = Long.MIN_VALUE;
        //Integer pre = null; //也可以把pre设置成null，pre不为null的时候才比较，这样就不用比较第一个节点
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //就比中序遍历多了一个判断的条件，还有一个把当前节点的val设置成pre
            if(root.val <= pre) return false;
            pre = root.val;
            root = root.right;
        }
        return true;
        /*
        //和上面的方法类似，只是把pre从存值变成存上一个节点
        TreeNode pre = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && pre.val >= root.val) return false;
            pre = root;
            root =root.right;
        }
        return true;
        */
    }
}
