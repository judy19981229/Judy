package text;

public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int index = 0;
                if(search(board, word, index, i, j)) return true;
            }
        }
        return false;
    }
    //深度优先搜索 index用来记录搜索的层次，搜索到word.length() - 1层即可
    public boolean search(char[][] board, String word, int index, int i, int j){
        //如果i j越界、board[i][j] == '.'(表示已经被搜索过了) 或者board[i][j]不等于word要搜索的字母
        //直接返回false
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 ||
                board[i][j] == '.' || board[i][j] != word.charAt(index)){
            return false;
        }
        //如果当前已经搜索到word的最后一个字母(且在上面判断过等于那个字母)，直接返回true
        if(index == word.length() - 1){
            return true;
        }else{ //搜索上下左右位置
            //记录当前位置字母
            char cur = board[i][j];
            //设置为'.'表示已经搜索过
            board[i][j] = '.';
            boolean result = false;
            //搜索上下左右位置，有一个为true就行
            result = search(board, word, index + 1, i - 1, j) ||
                    search(board, word, index + 1, i + 1, j) ||
                    search(board, word, index + 1, i, j - 1) ||
                    search(board, word, index + 1, i, j + 1);
            //搜索完之后，把当前字母恢复
            board[i][j] = cur;
            return result;
        }
    }
}
