package text;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 1) return new TreeNode(preorder[0]);
        //根节点是前序遍历的第一个值
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;
        //pre用来遍历前序遍历preorder
        int pre = 0;
        //in用来遍历中序遍历inorder
        int in = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        //把根节点放入栈中，pre + 1 指向下一个元素
        stack.push(cur);
        pre++;
        //根据pre来遍历preorder
        while(pre < preorder.length){
            //如果当前节点的值不等于中序遍历的值,说明下一个节点还是左子树
            if(cur.val != inorder[in]){
                cur.left = new TreeNode(preorder[pre]);
                cur = cur.left;
                stack.push(cur);
            }
            //如果当前节点的值等于中序遍历的值,说明下一个节点是右子树
            //因为中序遍历时左根右，前序遍历是根左右，会在遍历到已经没有左子树的时候相等
            //这时候我们就要找到那个根节点，下一个节点就是它的右子树
            else{
                //前序遍历：根左右 中序遍历：左根右
                //这时候把已经前序遍历的节点倒着找，中序遍历的节点正着找
                //如果继续相等，那么就说明这个节点没有右子树
                //如果这时候已经不相等了，那么就说明这个节点是右子树了
                //我们需要往回找到最后一个相等的节点，下一个节点就是它的右子树
                while(!stack.isEmpty() && stack.peek().val == inorder[in]){
                    cur = stack.pop();
                    in++;
                }
                cur.right = new TreeNode(preorder[pre]);
                cur = cur.right;
                stack.push(cur);
            }
            pre++;
        }
        return root;
    }
}
