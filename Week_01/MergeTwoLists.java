package Week_01;

public class MergeTwoLists {
  /**
   * 合并两个有序链表 leetcode:https://leetcode-cn.com/problems/merge-two-sorted-lists
   * 
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // 迭代法
    ListNode dummyHead = new ListNode(-1);
    ListNode prev = dummyHead;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        prev.next = l1;
        l1 = l1.next;
      } else {
        prev.next = l2;
        l2 = l2.next;
      }
      prev = prev.next;
    }
    prev.next = l1 == null ? l2 : l1;
    return dummyHead.next;
  }

  public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
    // 核心思路，两个链表头部值较小的与剩下的元素合并
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

}