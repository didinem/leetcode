package org.didinem;

/**
 * Created by zhongzhengmin on 2018/2/28.
 */
public class S21M1 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1p = l1;
        ListNode l2p = l2;
        ListNode parentNode = null;
        ListNode start = null;

        while (l1p != null || l2p != null) {
            ListNode currentNode = null;
            if (l1p == null) {
                currentNode = new ListNode(l2p.val);
                l2p = l2p.next;
            } else if (l2p == null) {
                currentNode = new ListNode(l1p.val);
                l1p = l1p.next;
            } else if (l1p.val >= l2p.val) {
                currentNode = new ListNode(l2p.val);
                l2p = l2p.next;
            } else if (l1p.val < l2p.val) {
                currentNode = new ListNode(l1p.val);
                l1p = l1p.next;
            }

            if (start == null) {
                start = currentNode;
                parentNode = start;
            } else {
                parentNode.next = currentNode;
                parentNode = currentNode;
            }

        }
        return start;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode create(int[] nums) {
        ListNode start = new ListNode(nums[0]);
        ListNode listNode = start;
        for (int i = 1; i < nums.length; i++) {
            listNode.next = new ListNode(nums[i]);
            listNode = listNode.next;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1, 2, 4};
        int[] n2 = new int[]{1, 3, 4};
        ListNode l1 = create(n1);
        ListNode l2 = create(n2);
        mergeTwoLists(l1, l2);
        System.out.println(l1);
    }

}
