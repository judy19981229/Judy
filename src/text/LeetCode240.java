package text;

public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //从右上角开始查找
        int i = 0;
        int j = matrix[0].length - 1;
        //查找到左下角
        while(i <= matrix.length - 1  && j >= 0){
            //查找到了，返回true
            if(matrix[i][j] == target) return true;
            //比target大，就往左走
            if(matrix[i][j] > target){
                j--;
            }
            //比target小，就往下走
            else{
                i++;
            }
        }
        //没查找到，返回false
        return false;
    }
    //二分法，遍历二维数组，依次二分查找每一个一维数组
    public boolean searchMatrixMiddle(int[][] matrix, int target){
        for(int[] nums : matrix){
            if(searchMiddle(nums, target)){
                return true;
            }
        }
        return false;
    }
    public boolean searchMiddle(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int middle = (right - left) / 2 + left;
            int num = nums[middle];
            if(num == target) return true;
            else if(num > target){
                right = middle - 1;
            }else{ //num < target
                left = middle + 1;
            }
        }
        return false;

    }
}
