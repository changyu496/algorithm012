package Week_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    /**
     * 17. 电话号码的字母组合
     * <p>
     * leetcode:https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        // 这也是一个递归的题目啊，回溯，和前面的全排列、括号生成有异曲同工之妙
        HashMap<Character, List<String>> maps = new HashMap<>();
        maps.put('2', Arrays.asList("a", "b", "c"));
        maps.put('3', Arrays.asList("d", "e", "f"));
        maps.put('4', Arrays.asList("g", "h", "i"));
        maps.put('5', Arrays.asList("j", "k", "l"));
        maps.put('6', Arrays.asList("m", "n", "o"));
        maps.put('7', Arrays.asList("p", "q", "r", "s"));
        maps.put('8', Arrays.asList("t", "u", "v"));
        maps.put('9', Arrays.asList("w", "x", "y", "z"));
        List<String> ans = new ArrayList<>();
        char[] digitsArray = digits.toCharArray();
        helper(0, digitsArray, "", ans, maps);
        return ans;
    }

    private void helper(int index, char[] digitsArray, String temp, List<String> ans, HashMap<Character, List<String>> maps) {
        // 终止条件 这个终止条件太粗鲁了
        if (index == digitsArray.length && temp.length() == digitsArray.length) {
            ans.add(temp);
        }
        // 处理当前层逻辑
        for (int i = index; i < digitsArray.length; i++) {
            // 这里要处理下map的问题？
            List<String> stringList = maps.get(digitsArray[i]);
            for (String str : stringList) {
                temp += str;
                // 递归下一层
                helper(i + 1, digitsArray, temp, ans, maps);
                // 清理现场
                temp = temp.substring(0,temp.length()-1);
            }
        }

    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        List<String> ans = letterCombinationsOfAPhoneNumber.letterCombinations("22");
        System.out.println(ans);
    }
}
