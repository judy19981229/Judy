package text;

import java.util.ArrayList;
import java.util.List;

public class LeetCode725 {


    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result=new ListNode[k];
        ListNode cur=head;
        int count=0;//节点的总数
        while(cur!=null){
            cur=cur.next;
            count++;
        }
        int part=count/k;//每部分有part个节点
        int extra=count%k;//前面extra部分有一个多余的节点
        cur=head;
        for(int i=0;i<k;i++){
            result[i]=cur;//把头节点加入数组中
            int nums=part+(extra-->0?1:0);//该部分的节点数：part+1/0（根据extra判断）
            while(nums-->1 && cur!=null){ cur=cur.next; }//移动到该部分最后一个节点
            if(cur!=null){
                ListNode tmp=cur.next;
                cur.next=null;//断开该部分和下一部分
                cur=tmp;//头节点移到下一部分的开始节点
            }
        }
        return result;
    }

}
