package text;

import java.util.Arrays;

public class MaoPaoSort {
    public static void main(String[] args) {
        int[] sort = new int[]{5,7,4,1,3,2,8,9};
        //8个元素需要两两比较7次，把最大值放到最后一位
        //然后最后一位不用比较了，7个元素两两比较6次
        for(int i = 0; i < sort.length - 1; i++){
            //count用来记录交换的次数
            int count = 0;
            //内层循环比较次数减i，因为外层循环一次之后，就会确定一个最大值在最后一位，内层就可以少比较一次
            for(int j = 0; j < sort.length - 1 - i; j++){
                if(sort[j + 1] < sort[j]){
                    int tmp = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = tmp;
                    count++;
                }
            }
            System.out.println("第"+ ( i + 1) +"次冒泡的结果" + Arrays.toString(sort) +
                    " 交换次数" + count);
            //如果交换次数为1次，那么说明已经排序好了，直接结束循环即可
            if(count == 1) return;
        }


    }
}
