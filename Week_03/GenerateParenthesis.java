package Week_03;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    /**
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, new StringBuilder(""), 0, 0, n);
        return ans;
    }

    public List<String> generateParenthesisV2(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, "", 0, 0, n);
        return ans;
    }

    private void helper(List<String> ans, String str, int left, int right, int n) {
        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }
        if (left < n) {
            helper(ans, str + "(", left + 1, right, n);
        }
        if (right < left) {
            helper(ans, str + ")", left, right + 1, n);
        }
    }

    private void helper(List<String> ans, StringBuilder str, int left, int right, int max) {
        if (str.length() == 2 * max) {
            ans.add(str.toString());
            return;
        }
        if (left < max) {
            // 因为这里改变了，所以下面要恢复！！！
            str.append("(");
            helper(ans, str, left + 1, right, max);
            str.deleteCharAt(str.length() - 1);
        }
        if (right < left) {
            str.append(")");
            helper(ans, str, left, right + 1, max);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis solution = new GenerateParenthesis();
        solution.generateParenthesis(5);
        System.out.println(solution.generateParenthesisV2(5));
    }
}
