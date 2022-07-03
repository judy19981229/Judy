package text;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Offer54 {
    List<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        //正常的中序遍历，二叉搜索树是递增的，找倒数第k个元素，就是第k大节点
        //inOrder(root);
        //return list.get(list.size() - k);
        //反过来的中序遍历，右根左，是递减的，第k个元素就是第k大元素
        //inOrderReverse(root, k);
        //return res;
        //迭代法反过来的中序遍历
        Deque<TreeNode> stack = new LinkedList<>();
        int count = 0;
        TreeNode p = root;
        while (p!=null || !stack.isEmpty()){
            //先将右节点全压栈(右)
            while(p != null){
                stack.push(p);
                p = p.right;
            }
            //出栈：先出右-再出根-然后到左节点
            p = stack.pop();
            //出栈第K个元素即整棵树的第K大的节点
            if(++count == k) return p.val;
            //左
            p = p.left;

        }
        return -1;

    }
    //正常的中序遍历
    public void inOrder(TreeNode root){
        //遍历终止条件，root为null
        if(root == null) return;
        //左
        inOrder(root.left);
        //根（在根这一步把root.val放入集合中，因为不管左还是右节点，最后都会是一个根节点）
        list.add(root.val);
        //右
        inOrder(root.right);
    }
    //count用来计数，走到k的时候直接返回即可
    int count = 0;
    //res用来存放第k大节点的值
    int res;
    //一个反转的中序遍历，右根左
    public void inOrderReverse(TreeNode root, int k){
        //遍历终止条件，root为null
        if(root == null) return ;
        //右，会一直走到最后一个没有右子树的右节点，然后再找到它的根节点，它的左节点
        inOrderReverse(root.right, k);
        //根，在根这一步的时候进行判断，因为不管是左还是右节点，最后都会是一个根节点，所以每走一步count都会+ 1
        //把count + 1 然后和k做比较， 等于k的时候直接返回当前root.val值即可
        count++;
        if(count == k){
            res = root.val;
            return;
        }
        //左
        inOrderReverse(root.left, k);
    }
}
