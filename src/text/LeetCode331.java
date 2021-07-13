package text;

import java.util.ArrayList;
import java.util.List;

public class LeetCode331 {
    public static void main(String[] args) {
        System.out.println(Integer.bitCount(3));//2
    }
    public boolean isValidSerialization(String preorder) {
        String[] s=preorder.split(",");//去掉，
        List list=new ArrayList();//集合存放树中的非空节点
        for(int i=0;i<s.length;i++){
            list.add(s[i]);
            int index=list.size()-1;
            //1##-#，数字加两个#，变成一个#（一个完整的分支）
            while(list.size()>2&&list.get(index).equals("#")
                    &&list.get(index-1).equals("#")&&!list.get(index-2).equals("#")){
                list.remove(index-1);
                list.remove(index-2);
                index=list.size()-1;//移除节点之后集合长度会发生变化
            }
        }
        return list.size()==1 && list.get(0).equals("#");//集合长度为1且只剩下#时为正true
    }
}
