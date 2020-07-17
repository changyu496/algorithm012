package Week_02;

import java.util.HashMap;

public class IsAnagram {
    /**
     * 有效的字母异位词
     * <p>
     * leetcode:https://leetcode-cn.com/problems/valid-anagram/description/
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        // 思路，首先挨个遍历字符串s的每个字符，放到一个hashmap中，key字符，value为出现次数，然后遍历另外一个，依次和hashmap中比较，如果出现
        // 过，就减1，最后看下hashmap中每个key所对应的value是不是都为0
        boolean ret = true;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        HashMap<Character, Integer> maps = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            
        }
        return ret;
    }
}
