package text;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode236 {
    //存放节点的值，以及其父节点信息
    Map<Integer, TreeNode> parentsMap = new HashMap<>();
    //存放p节点的所有父节点信息
    Set<TreeNode> parentsSet = new HashSet<>();

    //从root节点开始，把它所有子节点对应的父节点信息都写入map中
    public void addParentsMap(TreeNode root){
        if(root.left != null){
            parentsMap.put(root.left.val, root);
            addParentsMap(root.left);
        }
        if(root.right != null){
            parentsMap.put(root.right.val, root);
            addParentsMap(root.right);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //把root节点所有子节点对应的父节点信息都写入map中
        addParentsMap(root);
        //把p节点和p节点的所有父节点信息写入set中
        while(p != null){
            parentsSet.add(p);
            p = parentsMap.get(p.val);
        }
        //如果p节点和p节点的所有父节点信息的set中有q或者q的父节点，那么就返回q
        while(q != null){
            if(parentsSet.contains(q)) return q;
            q = parentsMap.get(q.val);
        }
        //不然就返回null，表示没有
        return null;
    }
}
