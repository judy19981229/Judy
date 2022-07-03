package text;

public class LeetCode110 {
    //维护一个全局变量result，result为false的时候直接终止递归，返回result
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        //height(root);
        //return result;
        return height1(root) >= 0;
    }
    //递归返回树的高度，从下往上返回
    public int height(TreeNode root){
        //递归终止条件：result为false，或者root为null
        if(!result || root == null) return 0;
        //递归左子树的高度
        int left = height(root.left);
        //递归右子树的高度
        int right = height(root.right);
        //如果左右子树高度差大于1，把result设置为false
        if(Math.abs(left - right) > 1){
            result = false;
        }
        //左右子树中较高的那个再 + 1，就是当前节点的高度
        return Math.max(left, right) + 1;
    }
    //递归返回树的高度，从下往上返回
    public int height1(TreeNode root){
        //递归终止条件:root为null，但是如果root一开始就null，结果应该是true，所以返回0，最后判断结果>= 0
        if(root == null) return 0;
        //递归左子树的高度
        int left = height1(root.left);
        //递归右子树的高度
        int right = height1(root.right);
        //如果左子树或者右子树的高度为-1，说明它们不是平衡的
        //如果左子树和右子树的高度差大于1，说明这个节点也不是平衡的，直接返回 -1
        if(left < 0 || right < 0 || Math.abs(left - right) > 1){
            return - 1;
        }
        //左右子树中较高的那个再 + 1，就是当前节点的高度
        return Math.max(left, right) + 1;
    }
}
