package Week_09;

import java.util.HashMap;

/**
 * 387. 字符串中的第一个唯一字符
 * <p>
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int index = -1;
        HashMap<Character, Integer> maps = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            maps.put(charArray[i], maps.getOrDefault(charArray[i], 0) + 1);
        }
        for (int i = 0; i < charArray.length; i++) {
            if (maps.get(charArray[i]) == 1) {
                index = i;
                break;
            }
        }
        return index;
    }
}
