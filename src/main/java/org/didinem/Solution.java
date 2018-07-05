package org.didinem;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = nodeToList(l1);
        List<Integer> list2 = nodeToList(l2);
        List<Integer> result = new ArrayList<>();
        int size = Math.max(list1.size(), list2.size());
        boolean isJ = false;
        for (int i = 0; i < size; i++) {
            int a = 0;
            if (list1.size() >= i + 1) {
                a = list1.get(i);
            }
            int b = 0;
            if (list2.size() >= i + 1) {
                b = list2.get(i);
            }
            int c = a + b;
            if (isJ) {
                c += 1;
            }
            isJ = false;
            if (c >= 10) {
                isJ = true;
                c = c - 10;
            }
            result.add(c);
        }
        if (isJ) {
            result.add(1);
        }
        ListNode listNode = listToNode(result);
        return listNode;
    }

    private List<Integer> nodeToList(ListNode listNode) {
        List<Integer> list = new ArrayList<Integer>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    private ListNode listToNode(List<Integer> list) {
        ListNode l1 = null;
        ListNode prev = null;
        for (int num : list) {
            ListNode listNode = new ListNode(num);
            if (l1 == null) {
                l1 = listNode;
            }
            if (prev != null) {
                prev.next = listNode;
            }
            prev = listNode;
        }
        return l1;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] p1 = new int[]{2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 9};
//        int[] p1 = new int[]{2, 4, 3};
        ListNode l1 = null;
        ListNode prev = null;
        for (int num : p1) {
            ListNode listNode = new ListNode(num);
            if (l1 == null) {
                l1 = listNode;
            }
            if (prev != null) {
                prev.next = listNode;
            }
            prev = listNode;
        }

        int[] p2 = new int[]{5, 6, 4, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 9, 9, 9, 9};
//        int[] p2 = new int[]{5, 6, 4, 2};
        ListNode l2 = null;
        ListNode prev2 = null;
        for (int num : p2) {
            ListNode listNode = new ListNode(num);
            if (l2 == null) {
                l2 = listNode;
            }
            if (prev2 != null) {
                prev2.next = listNode;
            }
            prev2 = listNode;
        }

        Solution s = new Solution();
        s.addTwoNumbers(l1, l2);
    }
}

