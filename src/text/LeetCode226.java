package text;


import java.util.Deque;
import java.util.LinkedList;

public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        //栈用来存储节点
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        //如果cur不为空，说明有可能还有子节点 需要继续遍历
        //如果stack不为空，说明有父节点，需要继续遍历
        while(cur != null || !stack.isEmpty()){
            //如果cur不为空，那么交换它的左右节点，然后把cur入栈，再遍历cur的左节点
            if(cur != null){
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
                stack.push(cur);
                cur = cur.left;
            }else{ //如果cur为空，那么找到cur的父节点（栈顶） 再遍历cur的右节点
                cur = stack.pop();
                cur = cur.right;
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