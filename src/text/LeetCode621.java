package text;

import java.util.Arrays;

public class LeetCode621 {
    public static void main(String[] args) {
        System.out.println("s".length());
        System.out.println("abc".charAt(0));
    }

    public int leastInterval(char[] tasks, int n) {
        int[] count=new int[26];
        for(int i=0;i<tasks.length;i++){
            count[tasks[i]-'A']++;//找出有几个A，几个B，几个C(按照A到-Z的顺序放在数组中)
        }
        Arrays.sort(count);
        int maxTimes=count[25];//同一元素出现最多的个数(有五个A，五个B，四个C，maxTimes为5)
        int maxCounts=1;//同一元素出现最多的个数的次数(有五个A，五个B，四个C，maxCounts为2)
        for(int i=25;i>0;i--){
            if(count[i]==count[i-1]){
                maxCounts++;
            } else{break;} //直接退出循环，因为count是已经排序好的数组，前面的都不是maxTimes了
        }
        return Math.max(tasks.length,(maxTimes-1)*(n+1)+maxCounts);
    }
}
