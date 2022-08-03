package text;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3 {
    public static void main(String[] args) {
        System.out.println('z' - 'a' == 25);

    }
    public int lengthOfLongestSubstring(String s) {
        //HashMap中存储的是字符串和它对应的下标
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        //滑动窗口，维持一个从start到end的不重复的滑动窗口，通过HashMap判断是否重复出现
        for(int start = 0, end = 0; end < s.length(); end++){
            char cur = s.charAt(end);
            //如果当前值出现过，start变成上一次出现位置后面1位（从后面1位开始不重复）
            if(map.containsKey(cur)){
                //防止start跑到当前start值前面，需要判断一下大小
                start = Math.max(start, map.get(cur) + 1);
            }
            //不管有没有出现过，都要放入HashMap当前字符和他最后一次出现的下标
            map.put(cur, end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
