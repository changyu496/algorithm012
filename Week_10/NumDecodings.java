package Week_10;

public class NumDecodings {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return helper(s, 0);
    }

    public int helper(String str, int start) {
        if (str.length() == start) {
            return 1;
        }
        if (str.charAt(0) == '0') {
            return 0;
        }
        int ans1 = helper(str, start + 1);
        int ans2 = 0;
        if (start < str.length() - 1) {
            int ten = (str.charAt(start) - '0') * 10;
            int one = str.charAt(start + 1) - '0';
            if (ten + one < 26) {
                ans2 = helper(str, start + 2);
            }
        }
        return ans1 + ans2;
    }

    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        int nums = numDecodings.numDecodings("2226");
        System.out.println(nums);
    }
}
