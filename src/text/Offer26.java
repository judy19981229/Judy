package text;

public class Offer26 {
    //工作一： 对二叉树进行遍历找到树 A 的根节点和树 B 的根节点相等的位置 root
    //工作二： 判断树 A 中以 root 为根节点的子树和树 B 具有相同的结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //递归终止条件，如果A或B有一个为null就返回false（一开始就为null或者遍历完了）
        if(A == null || B == null) return false;
        //递归终止条件,如果A和B的值相同，同时A中具有和B相同的树结构
        //helper方法判断A的right包含B的right A的left包含B的left
        if(A.val == B.val && helper(A.left, B.left) && helper(A.right, B.right)) return true;
        //A的val和B的val不相同，继续遍历A.left和B，以及A.right和B
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    //递归遍历root1中是否有和root2完全相等的部分（这部分应该从root1的根节点开始，但不一定到root1的最后一排）
    public boolean helper(TreeNode root1, TreeNode root2){
        //注意：这里判断root2 == null 应该在判断root1 == null前面
        //不然一旦同时遍历完了root1和root2 roo1 == null 在前面就会返回false，而应该返回true
        //如果遍历完了root2，说明root1中有完全和root2相等的部分，返回true
        if(root2 == null) return true;
        //如果遍历完了root1，且没遍历完root2，说明root1中没有完全和root2相等的部分，返回false
        if(root1 == null) return false;
        //如果root1.val和root2.val相等，继续遍历root1和root2的left和right，判断是否相等
        if(root1.val == root2.val){
            return helper(root1.left, root2.left) && helper(root1.right, root2.right);
        }else{
            return false;
        }
    }
}
