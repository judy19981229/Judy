package text;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode94 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return list;
        /*递归，左 （左走到底再开始王集合list中add） 根  右
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
        */
        //栈的方法
        Deque<TreeNode> stack = new LinkedList<>();
        //栈为空并且root为null时遍历完成
        while(!stack.isEmpty() || root !=null){
            //先把当前节点所有左子树入栈
            while(root !=null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                //把root变成栈顶元素（最后一个左子树）
                root = stack.pop();
                //把栈顶元素的值入栈
                list.add(root.val);
                //如果当前节点有右子树，就走向当前节点的右子树（有右子树说明当前即是左子树也是根结点）
                root = root.right;
            }
        }
        return list;
    }
}
