package text;

import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetCode969 {
    public static void main(String[] args) {
        LinkedList<Object> linkedList = new LinkedList<>();
    }

    public List<Integer> pancakeSort(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        //从arr.length开始遍历，依次找出最大值arr.length，次大值arr.length-1...
        for(int i= arr.length;i>0;i--){
            int index=0;//index是依次找出的最大值，次大值...的下标
            while(arr[index]!=i){ index++; }
            if(index==i-1){ continue;}//如果最大值已经在最后一个位置了，不用反转
            else if(index==0){//如果最大值在第一个位置，反转一次即可
                reverse(arr,i);
                result.add(i);
            }
            else{//最大值在中间，先反转到第一个位置，再反转到最后一个位置
                reverse(arr,index+1);
                result.add(index+1);
                reverse(arr,i);
                result.add(i);
            }
        }
        return result;
    }
    public void reverse(int[] arr,int index){//反转数组的方法
        int head=0;//头节点
        int tail=index-1;//尾节点
        int tmp;//临时节点
        while(head<tail){
            tmp=arr[head];
            arr[head]=arr[tail];
            arr[tail]=tmp;
            head++;
            tail--;
        }
    }
}
