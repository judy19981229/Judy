package text;

public class LeetCode200 {
    //遇到1就搜索它上下左右位置，把遇到的所有1都变成0(把相交的一群1，也就是一个岛屿的1全变成0)
    //搜索的次数就是岛屿数量(不相交的一群1的个数)
    public int numIslands(char[][] grid) {
        //特殊情况
        if(grid == null || grid.length == 0) return 0;
        //二维数组行数
        int m = grid.length;
        //二维数组列数
        int n = grid[0].length;
        int count = 0;
        //遍历二维数组，如果grid[i][j]位置为1，则深度优先搜索i j位置上下左右位置
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    //搜索当前i j位置上下左右位置，把遇到的'1'变成'0'
    public void dfs(char[][] grid, int i, int j){
        //二维数组行数
        int m = grid.length;
        //二维数组列数
        int n = grid[0].length;
        //超出范围，或者当前位置为‘0’，直接结束搜索
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }
}
