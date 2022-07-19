package text;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode114 {
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        //每次循环都把当前节点的右子树放到该放的位置（左子树的最后一个右节点的右面）
        //然后再把左子树挪到右子树处
        while(root != null){
            //如果当前节点没有左子树，无需操作
            if(root.left != null){
                //当前节点的左子节点
                TreeNode next = root.left;
                //找当前节点左子树前序遍历的最后一个节点(最后一个右节点)
                TreeNode finalRight = next;
                while(finalRight.right != null){
                    finalRight = finalRight.right;
                }
                //把当前节点的右子树挂在左子树的最后一个右节点后面
                finalRight.right = root.right;
                //把当前节点的左子树移动到右子树
                root.right = next;
                //把当前节点的左子树设置为空
                root.left = null;
            }
            //每次操作完之后直接走向当前节点的右子树
            root = root.right;
        }
    }
    //前序遍历，把节点存在list集合中，再重新从头开始串链表
    public void flattenPreOrder(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return;
        Deque<TreeNode> stack = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                list.add(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                cur = cur.right;
            }
        }
        for(int i = 0; i < list.size(); i++){
            root.left = null;
            root.right = list.get(i);
            root = root.right;
        }
    }
}
