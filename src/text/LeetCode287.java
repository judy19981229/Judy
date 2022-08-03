package text;

public class LeetCode287 {
    //判断链表是否有环
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(fast != slow);
        fast = nums[0];
        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
