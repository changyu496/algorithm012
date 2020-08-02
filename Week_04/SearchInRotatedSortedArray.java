package Week_04;

public class SearchInRotatedSortedArray {

    /**
     * 33. 搜索旋转排序数组
     * <p>
     * leetcode:https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // 题目要求是O(N)基本的，那么直接遍历肯定就不可以
        // 那就就要考虑下二分查找
        // 查找完之后，看下是否单调，如果一边单调，另一边不单调，那么就肯定在另一边，然后逐次过去
        // 这次二分查找的条件不一样了
        // 二分查找的目的，是为了抛弃一半肯定不存在的
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                // 左侧单调
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右侧单调
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int index = searchInRotatedSortedArray.search(new int[]{5, 1, 3}, 5);
        System.out.println(index);
    }
}
