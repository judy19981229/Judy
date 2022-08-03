package text;

public class LeetCode面试题0106字符串压缩 {

    public String compressString(String s) {
        int length = s.length();
        if(length <= 1) return s;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < length){
            int j = i + 1;
            while(j < length && s.charAt(j) == s.charAt(i)) j++;
            sb.append(s.charAt(i));
            sb.append(j - i);
            i = j;
        }
        return sb.length() < length ? sb.toString() : s;
    }
}
