package text;

public class ErFenSearch {
    public static void main(String[] args) {
        //二分查找：奇数取中间、偶数取中间靠左
        int[] array = new int[]{1,5,8,11,19,22,31,35,40,45,48,49,50};
        int target = 45;
        int index = binarySearch(array,target);
        System.out.println(index);
    }

    private static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int count = 0;
        while(left <= right){
            //int middle = (left + right) / 2
            int middle = left + (right - left) / 2;
            //int middle = (left + right) >> 1;
            count++;
            if(array[middle] == target){
                break;
            }else if(array[middle] > target){
                right = middle - 1;
            }else if(array[middle] < target){
                left = middle + 1;
            }
        }
        return count;
    }
}
