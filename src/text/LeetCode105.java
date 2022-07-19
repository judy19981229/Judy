package text;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 1) return new TreeNode(preorder[0]);
        //前序遍历：根左右
        //中序遍历：左根右
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        //先把根结点入栈
        stack.push(cur);
        //前序遍历的下标（根结点入栈，已经前序遍历一个了）
        int pre = 1;
        //中序遍历的下标
        int in = 0;
        //循环 前序遍历 根据pre来遍历preorder
        while(pre < preorder.length){
            //当前节点的值和中序遍历的值不相同，说明前序遍历的下一个还是左节点
            //设置cur的左节点（值为前序遍历时pre下标的值），并把cur的左节点入栈
            if(cur.val != inorder[in]){
                cur.left = new TreeNode(preorder[pre++]);
                cur = cur.left;
                stack.push(cur);
            }
            //如果当前节点的值等于中序遍历的值,说明前序遍历下一个节点是右节点
            else{
                //前序遍历往回找，中序遍历继续向下遍历，找最后一个相同的节点
                //就是前序遍历下一个右节点的根结点
                //这时的cur就是那个根节点
                while(!stack.isEmpty() && stack.peek().val == inorder[in]){
                    cur = stack.pop();
                    //这里in++不能写在stack.peek().val == inorder[in]这里
                    //不然找到的就不是最后一个相等的位置了（不相等了in不会再++）
                    in++;
                }
                //设置cur的右节点（值为前序遍历时pre下标的值），并把cur的右节点入栈
                cur.right = new TreeNode(preorder[pre++]);
                cur = cur.right;
                stack.push(cur);
            }
        }
        return root;
    }
}
