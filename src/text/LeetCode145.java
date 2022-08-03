package text;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode145 {

    public static void main(String[] args) {

    }

    List<Integer> list=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return list;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        //pre节点用来记录遍历树的前一个节点，如果前一个节点是右节点，那么就说明当前根节点可以放入集合中了
        TreeNode pre = root;
        //root不为null，说明当前节点可能还有子节点
        //stack不为null，说明当前节点一定有父节点
        while(root != null || !stack.isEmpty()){
            //先遍历root的左节点，找到最后一个左节点
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            //如果有右边节点，那么该节点就不能先出栈，要遍历完右边节点之后才能出栈
            root = stack.peek();
            if(root.right == null || root.right == pre){
                list.add(root.val);
                stack.pop();
                pre = root;
                //这里的root是一个左右节点都遍历完的根节点，需要设置为null，不然就无法向上继续遍历了
                root = null;
            }else{
                root = root.right;
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
