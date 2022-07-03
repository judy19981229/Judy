package text;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode589 {
/*    List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) return result;
        *//*
        //递归，和二叉树前序遍历差不多，只是改成了循环children数组
        result.add(root.val);
        for(int i = 0; i < root.children.size(); i++){
            preorder(root.children.get(i));
        }
        return result;
        *//*
        Deque<Node> stack = new LinkedList<>();
        //先把根节点入栈
        stack.push(root);
        //栈不为空，说明还有没遍历完的节点
        while(!stack.isEmpty()){
            //root为栈顶元素，把栈顶元素val值存入result中（根-孩子0-n)
            root = stack.pop();
            result.add(root.val);
            //然后遍历孩子节点，从右到左存入栈中，也就是从左到右出栈，满足前序遍历条件
            for(int i = root.children.size() - 1; i >= 0; i--){
                stack.push(root.children.get(i));
            }
        }
        return result;
    }
    class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};*/

}
