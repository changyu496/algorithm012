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
        // 这里其实可以不同map，因为是26个字母的话，直接用字符串即可
        if (s.length() != t.length()) {
            return false;
        }
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[sCharArray[i] - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            chars[tCharArray[i] - 'a']--;
        }
        for (int aChar : chars) {
            if (aChar != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        Boolean ret = isAnagram.isAnagram("a", "ab");
        System.out.println(ret);
    }
}
