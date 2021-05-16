package text;
//要求：
//一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
public class jump {
    public static void main(String[] args) {
        System.out.println(jump(3));
    }
    //如何跳上第n阶？
    //方法一：在第n-1阶向上跳1级
    //方法二：在第n-2阶向上跳2级
    //跳上第n阶第条法等于跳上第n-1阶的条法加上跳上第n-2阶的跳法
    public static int jump(int target){
        if(target==1 || target==2){
            return target;
        }
        return jump(target-1)+jump(target-2);
    }
}
