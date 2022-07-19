package text;


import java.util.Deque;
import java.util.LinkedList;

public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        //特殊情况
        if(root == null || (root.left == null && root.right == null)) return root;
        //栈用来存储节点 先进先出
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        //把头节点入栈
        stack.push(cur);
        //如果栈不为空，说明还有节点没交换完
        while(!stack.isEmpty()){
            //从栈中取出当前节点
            cur = stack.pop();
            //如果当前节点不为空，交换它的左右子节点，然后再把它的左右字节点入栈
            if(cur != null){
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        return root;
        /*
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
        */
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}