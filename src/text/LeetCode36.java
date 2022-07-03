package text;

public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        //存储每一行 每个数字出现了几次(行对应1-9行，列对应数字1-9出现的次数)
        int[][] rows = new int[9][9];
        //存储每一列 每个数字出现了几次(行对应1-9列，列对应数字1-9出现的次数)
        int[][] columns = new int[9][9];
        //存储每一个九宫格，每个数字出现了几次(行3个，列3个，数字9个)
        int[][][] subboxes = new int[3][3][9];
        //行循环
        for(int i = 0; i < 9; i++){
            //列循环
            for(int j = 0; j < 9; j++){
                //获取当前循环的字符
                char cur = board[i][j];
                //判断是否是数字，是数字才判断
                if(cur != '.'){
                    //获取当前数字的下标（数字 - 1，因为下标从0开始）
                    int index = cur - '0' - 1;
                    //该行当前数字出现次数+ 1
                    rows[i][index]++;
                    //该列当前数字出现次数 + 1
                    columns[j][index]++;
                    //该九宫格当前数字出现次数 + 1
                    subboxes[i / 3][j / 3][index]++;
                    //如果当前该数字在列、行、九宫格中出现的次数大于1，那么返回false
                    if(rows[i][index] > 1 ||  columns[j][index] > 1
                            || subboxes[i / 3][j / 3][index] > 1){
                        return false;
                    }
                }
            }
        }
        //走到这里说明都没有重复的，返回true
        return true;
    }

}
