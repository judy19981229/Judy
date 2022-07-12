package text;

public class LeetCode48 {
    public void rotate(int[][] matrix) {
        //特殊情况
        if(matrix.length == 1) return;
        int length = matrix.length;
        //先沿主对角线（从左上角到右下角）翻转
        for(int i = 0; i < length; i++){
            //主对角线翻转 matrix[i][j]位置和matrix[j][i]位置交换，j < i （j = i为对角线位置）
            for(int j = 0; j < i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //再左右翻转
        for(int i = 0; i < length; i++){
            //i表示行，j、k表示列，交换i行的j位置和k位置
            //交换matrix[i][j]和matrix[i][k]
            for(int j = 0, k = length - 1; j < k; j++, k--){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = tmp;
            }
        }
    }
}
