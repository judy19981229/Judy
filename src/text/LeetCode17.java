package text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode17 {
    List<String> combines = new ArrayList<>();
    //因为digits中的数字是String类型的，截出来一个数字就是char类型的，所以HashMap的key为Character类型
    Map<Character, String> phoneMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        //特殊情况
        if(digits.length() == 0) return combines;
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        StringBuffer combine = new StringBuffer();
        //调用backtrack回溯方法，从下标0开始，到digits.length()
        backtrack(digits, combine, 0);
        return combines;
    }
    public void backtrack(String digits, StringBuffer combine, int index){
        //递归到digits.length()之后，把StringBuffer中拼接的字符串转成String放入结果集中
        if(index == digits.length()){
            combines.add(combine.toString());
        }else{
            //获取当前数字
            char digit = digits.charAt(index);
            //获取当前数字对应的字母
            String letters = phoneMap.get(digit);
            for(int i = 0; i < letters.length(); i++){
                //从第一个字母开始依次拼接当前数字对应的字母
                combine.append(letters.charAt(i));
                //递归下一个数字，一直递归到digits.length()，把拼接后的结果放入结果集中
                backtrack(digits, combine, index + 1);
                //在StringBuffer中删掉当前的字母，继续拼接下一个字母并开始第二轮的递归
                combine.deleteCharAt(index);
            }
        }
    }

}
