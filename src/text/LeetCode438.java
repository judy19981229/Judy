package text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode438 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums,0,3)));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        //特殊情况，p比s字符多，直接返回空集合
        if(p.length() > s.length()) return list;
        //通过sCount和pCount记录s和p中a - z的数量
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        //先根据p的length，把s的前p.length个存入数组中，形成滑动窗口
        for(int i = 0; i < p.length(); i++){
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        //如果一开始sCount和pCount就相同，存入下标0
        if(Arrays.equals(sCount, pCount)){
            list.add(0);
        }
        //滑动窗口开始滑动，左边从0开始，右边从p.length()开始
        for(int i = 0; i < s.length() - p.length(); i++){
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + p.length()) - 'a']++;
            if(Arrays.equals(sCount, pCount)) list.add(i + 1);
        }
        return list;
    }
}
