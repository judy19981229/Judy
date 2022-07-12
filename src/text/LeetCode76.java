package text;

import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {
    public String minWindow(String s, String t) {
        //特殊情况
        if (s.equals(t)) return s;
        //hs存储s中当前滑动窗口每个字母的个数,ht存储t中每个字母的个数
        Map<Character, Integer> hs = new HashMap<>();
        Map<Character, Integer> ht = new HashMap<>();
        //把t中每个字母的个数存到ht中
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }
        //结果
        String result = "";
        //cnt是当前滑动窗口中有多少个字母可以匹配t中的字母
        int count = 0;
        //length是滑动窗口的长度，找最小的，把length的初值设置为一个大于s的长度的值
        int length = s.length() + 1;
        //i是滑动窗口的左端，j是滑动窗口的右端
        for (int i = 0, j = 0; j < s.length(); j++) {
            //滑动窗口右端的值
            char right = s.charAt(j);
            //getOrDefault方法，有value就获得，没有就放一个初值（第二个参数0）进去
            hs.put(right, hs.getOrDefault(right, 0) + 1);
            //如果ht中有s的右窗口字母，并且hs中的个数要小于等于ht中的个数，可以匹配的个数+1
            if (ht.containsKey(right) && hs.get(right) <= ht.get(right)) {
                count++;
            }
            //如果ht中不包含当前左窗口字母，或者hs中当前左窗口字母个数大于ht中的个数，左窗口右移
            while (i < j && (!ht.containsKey(s.charAt(i)) || hs.get(s.charAt(i)) > ht.get(s.charAt(i)))) {
                int tmp = hs.get(s.charAt(i)) - 1;
                hs.put(s.charAt(i), tmp);
                i++;
            }
            //如果cnt值等于t.length()了，说明滑动窗口匹配了t中所以字母，判断当前滑动窗口长度是否比之前要小
            if (count == t.length() && j - i + 1 < length) {
                length = j - i + 1;
                result = s.substring(i, j + 1);
            }
        }
        return result;
    }
}


