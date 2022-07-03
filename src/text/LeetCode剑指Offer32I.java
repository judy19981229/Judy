package text;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode剑指Offer32I {
    public int[] levelOrder(TreeNode root) {
        //特殊情况，root为null，返回一个空数组
        if(root == null) return new int[0];
        //list用来存储遍历的节点的val值
        List<Integer> list = new ArrayList<>();
        //queue队列用来存储每一层的节点
        Deque<TreeNode> queue = new LinkedList<>();
        //先把根节点放入队列
        queue.add(root);
        //如果队列不为空，说明还有节点没遍历完
        while(!queue.isEmpty()){
            //size是当前这一层节点的个数，要挨个遍历
            int size = queue.size();
            while(size-- > 0){
                //出队队首节点，把它的val值放入list中，然后再把他的左右子节点放到queue队列中
                root = queue.poll();
                list.add(root.val);
                if(root.left != null) queue.add(root.left);
                if(root.right != null) queue.add(root.right);
            }
        }
        //结果是一个int数组，长度为arrayList的长度，把arrayList中的元素导入数组中即可
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
