package text;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode145 {
    public static void main(String[] args) {

    }
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        postorder(root,list);
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){return list;}
        Deque<TreeNode> stack=new LinkedList<>();
        Deque<Integer> statusStack=new LinkedList<>();
        stack.push(root);
        statusStack.push(0);
        while(!stack.isEmpty()){
            switch (statusStack.pop()){
                case 0:
                    statusStack.push(1);
                    if(stack.peek().left!=null){
                        stack.push(stack.peek().left);
                        statusStack.push(0); }
                    break;
                case 1:
                    statusStack.push(2);
                    if(stack.peek().right!=null){
                        stack.push(stack.peek().right);
                        statusStack.push(0); }
                    break;
                case 2:
                    list.add(stack.pop().val);
                    break;
            }
        }
        return list;
    }


    public void postorder (TreeNode root, List<Integer> list){
        if(root==null){return;}
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.val);
    }




    public class TreeNode {
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
}
