package text;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    List<String> combines = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuffer combine = new StringBuffer();
        generate(combine, n, n, 0);
        return combines;
    }
    //回溯，left是左括号剩余个数，right是右括号剩余个数，index是当前括号在StringBuffer中的下标
    public void generate(StringBuffer combine, int left, int right, int index){
        //左右括号剩余个数都为0，把拼接后的结果转成String放入结果集中
        if(left == 0 && right == 0){
            combines.add(combine.toString());
        }
        //左右括号剩余个数相同，先递归拼接左括号，递归拼接完成后把当前左括号的从StringBuffer中删掉
        else if(left == right){
            generate(combine.append("("), left - 1, right, index + 1);
            //本次左括号拼接完成之后，需要删掉本次左括号，继续考虑下一种情况（回溯）
            combine.deleteCharAt(index);
        }
        //剩余左括号个数小于右括号个数，优先递归拼接左括号，拼接完之后删掉左括号，然后再递归拼接右括号
        else if(left < right){
            if(left > 0){
                generate(combine.append("("), left - 1, right, index + 1);
                combine.deleteCharAt(index);
            }
            generate(combine.append(")"), left, right - 1, index + 1);
            combine.deleteCharAt(index);
        }
    }

}
