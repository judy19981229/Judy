package text;

import java.util.*;

public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //对单词str排序，字母异位词排序后的结果是一样的
        //维护一个map，排序后的结果为map的key，各个字母异位词（排序结果相同都为key）为一个list集合
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            //通过把String转成char[]数组来实现排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            //再把char[]数组变成String，作为map的key
            String key = new String(charArray);
            List<String> list = null;
            //map中存在该key，取出value，把str存入value的list中，再把list存回map中
            if(map.containsKey(key)){
                list = map.get(key);
            }
            //map中不存在该key，新建一个list作为该key的value，存入map中
            else{
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(key, list);
        }
        //HashMap的values方法，取出map中的所有value值，组成一个集合
        return new ArrayList<List<String>>(map.values());
    }
}
