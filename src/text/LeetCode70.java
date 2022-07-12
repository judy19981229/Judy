package text;

public class LeetCode70 {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int [] memory = new int[n + 1];
        return climbStairsMemory(n, memory);
    }
    public int climbStairsDP(int n){
        if(n <= 2) return n;
        //动态规划 爬上n楼的方法 = 爬上n - 1楼的方法 + 爬上n - 2楼的方法
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i =3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public int climbStairsDiGui(int n){
        if(n <= 2) return n;
        //爬上1楼的方法
        int n1 = 1;
        //爬上2楼的方法
        int n2 = 2;
        //从3楼开始循环
        for(int i = 3; i <=n; i++){
            //3楼的方法 = 2楼的方法 + 1楼的方法
            int sum = n1 + n2;
            //n1变成2楼
            n1 = n2;
            //n2变成3楼
            n2 = sum;
        }
        return n2;
    }
    //记忆化递归，把每层的值写入memory数组中
    public int climbStairsMemory(int n, int[] memory){
        if(memory[n] > 0){
            return memory[n];
        }
        if(n <= 2){
            memory[n] = n;
        }else{
            memory[n] = climbStairsMemory(n - 1, memory) + climbStairsMemory(n - 2, memory);
        }
        return memory[n];
    }
}
