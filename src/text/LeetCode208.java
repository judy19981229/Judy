package text;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode208 {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abc";
        System.out.println(s1.startsWith(s2));
    }
    class Trie {
        //用一个HashMap来维护当前字符，以及下一个前缀树节点
        Map<Character, Trie> next;
        //用来标识当前字符是否是单词的最后一位(上一个isEnd后一个到当前isEnd是一个完整的单词)
        boolean isEnd;

        //isEnd初始值为false
        public Trie() {
            this.next = new HashMap<>();
            this.isEnd = false;
        }

        //插入单词，只要把单词中没有在前缀树中的字符，插入前缀树的新树节点即可
        public void insert(String word) {
            //获取当前前缀树
            Trie cur = this;
            //遍历word
            for(char c : word.toCharArray()){
                //如果前缀树中不存在word当前遍历的字符，把当前字符存入前缀树中(cur.next的key)
                if(cur.next.get(c) == null){
                    cur.next.put(c, new Trie());
                }
                //不管前缀树中有没有word当前遍历的字符，当前前缀树都要走向下一个前缀树节点(cur.next的value)
                cur = cur.next.get(c);
            }
            cur.isEnd = true;
        }

        //多写一个searchPrefix方法，搜索前缀树中是否有prefix的所有字符
        //有就返回最后一个字符的前缀树节点，没有就返回null
        public Trie searchPrefix(String prefix){
            Trie cur = this;
            for(char c : prefix.toCharArray()){
                if(cur.next.get(c) == null) return null;
                cur = cur.next.get(c);

            }
            return cur;
        }

        //根据searchPrefix方法
        //如果返回了一个前缀树节点(说明word所有字符都在前缀树中)
        //并且该节点的isEnd属性为true(说明是单词的最后一位)
        public boolean search(String word) {
            Trie end = searchPrefix(word);
            return end != null && end.isEnd;
        }

        //根据searchPrefix方法
        //如果返回了一个前缀树节点(说明prefix所有字符都在前缀树中)
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

    }
}

