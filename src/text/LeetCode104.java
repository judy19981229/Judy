package text;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int result = 0;
        //用一个队列来存放每一层的节点（需要一边进一边出）
        Deque<TreeNode> queue = new LinkedList<>();
        //先把根节点放入队列中
        queue.add(root);
        //如果队列不为空，就继续循环（说明还有节点在队列中）
        while(!queue.isEmpty()){
            //size是当前这一层节点的个数
            int size = queue.size();
            //把当前这一层的每个节点都遍历一遍，把他们的子节点从前面入队，然后把他们从后面出队（先进先出）
            while(size > 0){
                TreeNode node = queue.poll();
                //有左节点，左节点入队；有右节点，右节点入队
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                size--;
            }
            //每遍历完这一层的所有节点，都把result + 1
            result++;
        }
        return result;
        /*
        int result = 0;
        //递归终止条件，root为null
        if(root == null) return result;
        //找到左子树的最大深度
        int left = maxDepth(root.left);
        //找到右子树的最大深度
        int right = maxDepth(root.right);
        //二叉树的最大深度是左子树的最大深度和右子树的最大深度中的最大值+ 1（要加上根节点）
        result = Math.max(left,right) + 1;
        return result;
        */
    }
}
