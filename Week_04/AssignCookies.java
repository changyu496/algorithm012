package Week_04;

import java.util.Arrays;

public class AssignCookies {

    /**
     * 455. 分发饼干
     * <p>
     * leetcode:https://leetcode-cn.com/problems/assign-cookies/
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        // 先排序，依次满足
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        int sIndex = 0;
        while (gIndex < g.length && sIndex < s.length) {
            if (s[sIndex] >= g[gIndex]) {
                gIndex += 1;
            }
            sIndex += 1;
        }
        return gIndex;
    }

}
