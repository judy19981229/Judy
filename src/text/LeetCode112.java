package text;

public class LeetCode112 {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        //特殊情况，如果root为空，直接返回false
        if(root == null) return false;
        //递归的终止条件，root没有左子树叶没有右子树，同时root的val值为targetSum时返回true
        //这里的targerSum为每次递归之后减去当前节点val值的targetSum
        if(root.left == null && root.right == null) return root.val == targetSum;
        //开始递归，分别递归左子树和右子树，只要有一个满足条件即可
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum  - root.val);

        /*
        //维护两个队列，一个存放的是当前的节点，一个存放的是当前节点和之前节点相加后的val值
        //想等于层序遍历，依次从根节点开始遍历每一层的每一个节点，把节点放入栈中，val和放入另一个栈中
        Deque<TreeNode> queueNode = new LinkedList<>();
        Deque<Integer> queueVal = new LinkedList<>();
        //先把root节点和root的val值放入两个队列中
        queueNode.add(root);
        queueVal.add(root.val);
        //queueNode栈不为空，说明还有节点没遍历完
        while(!queueNode.isEmpty()){
            //root是当前队首节点，tmp是当前队首节点从根节点到该节点的val值的和
            root = queueNode.poll();
            int tmp = queueVal.poll();
            //如果root节点没有左子树和右子树，判断tmp值和targerSum是否相等
            //相等就说明根到叶的和为targetSum，不相等就继续循环，判断别的节点
            if(root.left == null && root.right == null){
                if(tmp == targetSum) return true;
                else continue;
            }
            //左子树不为空，把左节点放入栈中，加上左节点的val值的tmp放入栈中
            if(root.left != null){
                queueNode.add(root.left);
                queueVal.add(tmp + root.left.val);
            }
            //右子树不为空，把右节点放入栈中，加上右节点的val值的tmp放入栈中
            if(root.right != null){
                queueNode.add(root.right);
                queueVal.add(tmp + root.right.val);
            }
        }
        //如果走到这一步，说明遍历完了所有的节点，都没有和等于targetSum的，返回false
        return false;
        */
    }
}
