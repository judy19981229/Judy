package text;

import java.util.Arrays;

public class LeetCode912 {
    public int[] sortArray(int[] nums) {
        //Arrays.sort(nums); return nums;
        //return quickSort(nums, 0, nums.length - 1);
        //return insertSort(nums);
        return heapSort(nums);
        //return mergeSort(nums);

    }
    //插入排序
    // 5 2 3 1 第一个数是5
    // 2 5 3 1 第二个数是2 比5小 放到5前面
    // 2 3 5 1 第三个数是3 比5小 比2大 放到5前面 2后面
    // 1 2 3 5 第四个数是1 比5小 比3小 比2小 放到2前面
    // 这时候 循环出的数是1 把 2 3 5分别向后移动一位 把2原先的位置变成1
    public int[] insertSort(int[] nums){
        for(int i=0; i<nums.length; i++){
            int tmp=nums[i];
            int j=i-1;
            while(j>=0 && tmp<nums[j]){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=tmp;
        }
        return nums;
    }
    //堆排序，每次构建成最大堆（堆的叶子结点值要大于它两个子节点），然后把最大值交换到堆最后一位
    public int[] heapSort(int[] nums){
        if(nums.length == 1) return nums;
        //从最后一个非叶子结点(下标nums.length / 2 -1)开始，依次往前构建成最大堆
        for(int i = nums.length / 2 - 1; i >= 0; i--){
            buildMaxHeap(nums, i, nums.length - 1);
        }
        //把最大值交换到最后一位,然后把最大值除外的前面继续构建成最大堆
        for(int i = nums.length - 1; i > 0; i--){
            swap(nums, 0, i);
            buildMaxHeap(nums, 0, i - 1);
        }
        return nums;
    }
    //构建成最大堆(从i下标开始，构建到length为最大堆)
    public void buildMaxHeap(int[] nums, int i, int length){
        int tmp = nums[i];
        int j;
        while((j = 2 * i + 1) <= length){
            //如果右子比左子更大，那么j指向右子(j指向两个子节点中较大的那个)
            if(j + 1 <= length && nums[j + 1] > nums[j]){
                j++;
            }
            //如果两个子节点中较大那个都小于tmp(最初的nums[i])，则直接退出循环
            if(nums[j] <= tmp){
                break;
            }
            //nums[j] > tmp 把大的子节点放到根结点处，i落下到j，继续循环，找是否有大的子结点
            nums[i] = nums[j];
            i = j;
        }
        //最后把tmp(最初的nums[i])放到合适的位置(i落下到j之后的位置,因为已经把大的放到上面去了)
        nums[i] = tmp;

    }
    //归并排序，把数组分为左右两部分，然后分别排序好左边和右边，再合并排序
    public int[] mergeSort(int[] nums){
        if(nums.length == 1) return nums;
        int length = nums.length;
        int[] L = mergeSort(Arrays.copyOfRange(nums, 0, length / 2));
        int[] R = mergeSort(Arrays.copyOfRange(nums, length / 2, length));
        nums = merge(L, R);
        return nums;
    }
    //合并并排序两个已经排序好的数组
    public int[] merge(int[] left, int[] right){
        int[] nums = new int[left.length + right.length];
        int l = 0;
        int r = 0;
        int i = 0;
        while(l < left.length && r < right.length){
            if(left[l] < right[r]){
                nums[i++] = left[l++];
            }else{
                nums[i++] = right[r++];
            }
        }
        while(l < left.length){
            nums[i++] = left[l++];
        }
        while(r < right.length){
            nums[i++] = right[r++];
        }
        return nums;
    }
    //快排，随机选主元，分别排序好主元左右两边（主元左边的都比主元小，右边的都比主元大
    public int[] quickSort(int[] nums, int left, int right){
        //递归终止条件
        if(left >= right) return nums;
        //第一次快排，从left到right，随机选取下标为pivotIndex的主元
        int pivotIndex = partition(nums, left, right);
        //将left到pivotIndex - 1进行快排
        quickSort(nums, left, pivotIndex - 1);
        //将pivotIndex + 1到right进行快排
        quickSort(nums, pivotIndex + 1, right);
        return nums;
    }
    public int partition(int[] nums, int left, int right){
        //随机选取下标，作为主元
        int pivotIndex = (int)(Math.random() * (right - left) + left);
        //主元值
        int pivotNum = nums[pivotIndex];
        //把主元值交换到最后一位
        swap(nums, pivotIndex, right);
        //i左边的值都比主元值小
        int i = left;
        //j开始从left开始遍历数组，找到比主元小的值就放到i，然后i往后走一位
        for(int j = left; j < right; j++){
            if(nums[j] < pivotNum){
                if(i != j){
                    swap(nums, i, j);
                }
                i++;
            }
        }
        //把主元交换到i位置(前面都是比主元小的值)
        if(i != right){
            swap(nums, i ,right);
        }
        return i;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
