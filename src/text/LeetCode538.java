package text;

public class LeetCode538 {
    //二叉搜索树：左子节点小、右子节点大，中序遍历是递增的
    //我们要求所有大于等于当前节点的值之和
    //做一个反向中序遍历、把反向中序遍历的值累加到sum中
    //遍历到当前节点的时候，sum中存储的就是所有大于当前节点的值的和
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        //递归终止条件
        if(root == null) return root;
        //右
        convertBST(root.right);
        //根(进行操作，累加sum、把当前节点值设置成sum)
        sum += root.val;
        root.val = sum;
        //左
        convertBST(root.left);
        //返回root
        return root;
    }
}
