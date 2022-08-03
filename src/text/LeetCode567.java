package text;

import java.util.Arrays;

public class LeetCode567 {
    public boolean checkInclusion(String s1, String s2) {
        //特殊情况
        if(s1.equals(s2)) return true;
        if(s1.length() > s2.length()) return false;
        int[] one = new int[26];
        int[] two = new int[26];
        //先根据s1的长度，初步构建滑动窗口
        for(int i = 0; i < s1.length(); i++){
            one[s1.charAt(i) - 'a']++;
            two[s2.charAt(i) - 'a']++;
        }
        //判断最初的滑动窗口是否和s1的数组相同
        if(Arrays.equals(one, two)) return true;
        //i表示滑动窗口的左侧，i + s1.length()表示滑动窗口的右侧 左减 右加 将滑动窗口一直右移
        for(int i = 0; i < s2.length() - s1.length(); i++){
            two[s2.charAt(i) - 'a']--;
            two[s2.charAt(i + s1.length()) - 'a']++;
            if(Arrays.equals(one, two)) return true;
        }
        return false;
    }
}
