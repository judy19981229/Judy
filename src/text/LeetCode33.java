package text;

public class LeetCode33 {
    public int search(int[] nums, int target) {
        if(nums.length == 1) return target == nums[0] ? 0 : -1;
        int left = 0;
        int right = nums.length - 1;
        //二分法
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target) return mid;
            //nums[mid]在第一段升序区间
            if(nums[mid] >= nums[0]){
                //如果target比nums[mid]小，并且大于等于nums[left]
                //说明target就在left - mid区间，right移动到mid - 1
                if(target < nums[mid] && target >= nums[left]){
                    right = mid - 1;
                }else{ // target > nums[mid]
                    //left移动到mid + 1
                    left = mid + 1;
                }
            }
            //nums[mid]在第二段升序区间
            else{
                //如果target比nums[mid]大，并且小于等于nums[right]
                //那么说明target就在mid - right区间，left移动到mid + 1
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{ //target < nums[mid]
                    //right移动到mid - 1
                    right = mid - 1;
                }
            }
        }
        //二分查找没找到，返回-1
        return -1;
    }
}
