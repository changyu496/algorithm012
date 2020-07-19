package Week_02;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    /**
     * 49. 字母异位词分组
     * <p>
     * leetcode:https://leetcode-cn.com/problems/group-anagrams/
     *
     * @param strs
     * @return
     */
    public ArrayList groupAnagrams(String[] strs) {
        // 特别要注意HashMap里的K和V放什么值
        // 需要对字母排序，相同的放到一起
        HashMap<String, List<String>> maps = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!maps.containsKey(key)) {
                maps.put(key, new ArrayList<>());
            }
            maps.get(key).add(strs[i]);
        }
        return new ArrayList(maps.values());

    }
}
