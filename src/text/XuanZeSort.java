package text;

import java.util.Arrays;

public class XuanZeSort {
    public static void main(String[] args) {
        int[] sort = new int[]{5,3,7,2,1,9,8,4};
        //i只要遍历到数组的倒数第二个数即可
        for(int i = 0; i < sort.length - 1; i++){
            int min = i;
            //j要遍历到数组的最后一个
            for(int j = i + 1; j < sort.length; j++){
                if(sort[j] < sort[min]){
                    min = j;
                }
            }
            if(min != i){ //最小值不是第一个才交换最小值到第一个
                int tmp = sort[min];
                sort[min] = sort[i];
                sort[i] = tmp;
            }

            System.out.println("第"+ i + "次选择排序的结果" + Arrays.toString(sort));
        }

    }
}
