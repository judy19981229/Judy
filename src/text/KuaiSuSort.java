package text;

import java.util.Arrays;

public class KuaiSuSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5,3,7,2,9,8,1,4};
        int left = 0;
        int right = nums.length - 1;
        quickSort(nums, left, right);
        System.out.println(Arrays.toString(nums));
    }
    public static void quickSort(int[] nums, int left, int right){
        if(left >= right) return;
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }
    public static int partition(int[] nums, int left, int right){
        //随机取主元下标(取 3 - 9中随机一个， 先生成一个0 - 1的随机数， 然后* (9 - 3), 取整， 再加3)
        //不加3的话就会取成0 - 6的随机数
        int pivotIndex = (int)(Math.random() * (right - left) + left);
        //int pivot = right;
        //主元的值
        int pivotNum = nums[pivotIndex];
        System.out.println("取的主元的值为" + pivotNum);
        //需要把主元的值放到最后一位
        swap(nums, pivotIndex, right);
        //i用来存放比主元小的值(i前面的值都是比主元小的，i当前指向的下一个比主元小值的位置)
        int i = left;
        //j用来遍历数组，找到比主元小的值，就交换到i处
        for(int j = left; j < right; j++ ){
            if(nums[j] < nums[right]){
                //j不等于i的时候才交换
                if(j != i){
                    swap(nums, i , j);
                }
                i++;
            }
        }
        //i的位置指向的是所有比主元小的值后面一个位置，所以我们遍历完数组之后，把主元的值放到i位置即可完成排序
        if(i != right){
            swap(nums, i , right);
        }
        System.out.println("数组进行一次快排" + Arrays.toString(nums));
        return i;
    }
    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
