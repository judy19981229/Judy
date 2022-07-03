package text;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode102 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        //特殊情况，返回空list集
        if(root == null) return result;
        //用一个队列来存储节点，先进先出，先遍历上一层节点出队的时候，也要入队他们的子节点
        Deque<TreeNode> queue = new LinkedList<>();
        //先把节点入栈
        queue.add(root);
        //如果栈不为空就说明还有节点没遍历完
        while(!queue.isEmpty()){
            //size是当前这一层的节点数，要把这一层每个节点都遍历完，同时把他们的子节点加入队列中
            int size = queue.size();
            //存放当前这一层val的list
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                //遍历一次出队一个节点，把它的val值放入lis中，把它的left和right放入队列中
                root = queue.poll();
                list.add(root.val);
                if(root.left != null) queue.add(root.left)  ;
                if(root.right != null) queue.add(root.right)  ;

            }
            //遍历完这一层之后，把存放这一层的list放入结果集中
            result.add(list);
        }
        return result;
    }
}
