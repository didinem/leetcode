package org.didinem.linkedlist.q160;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Classname S1
 * @Description TODO
 * @Date 2020/4/2 17:13
 * @Created by didinem
 */
public class S1 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 遍历A
        List<ListNode> lista = new ArrayList<>();
        ListNode iter = headA;
        while (iter != null) {
            lista.add(iter);
            iter = iter.next;
        }

        // 遍历B
        List<ListNode> listb = new ArrayList<>();
        iter = headB;
        while (iter != null) {
            listb.add(iter);
            iter = iter.next;
        }

        // 集合A中的索引
        Integer index = null;
        for (int i = lista.size() - 1, j = listb.size() - 1; i >= 0 && j >= 0; i--, j--) {
            ListNode a = lista.get(i);
            ListNode b = listb.get(j);

            ListNode pa = null;
            if (i - 1 >= 0) {
                pa = lista.get(i - 1);
            }
            ListNode pb = null;
            if (j - 1 >= 0) {
                pb = listb.get(j - 1);
            }

            if (a == b && (pa != pb || (pa == null && pb == null))) {
                index = i;
                break;
            }
        }

        if (index == null) {
            return null;
        }

        ListNode result = headA;
        while (index > 0) {
            result = result.next;
            index--;
        }
        return result;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
