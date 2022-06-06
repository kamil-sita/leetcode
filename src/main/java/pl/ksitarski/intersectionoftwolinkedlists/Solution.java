package pl.ksitarski.intersectionoftwolinkedlists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<Integer, List<ListNode>> map = new HashMap<>();

        ListNode a = headA;

        while (a != null) {
            if (!map.containsKey(a.val)) {
                map.put(a.val, new ArrayList<>());
            }
            map.get(a.val).add(a);
            a = a.next;
        }

        ListNode b = headB;

        while (b != null) {
            if (map.containsKey(b.val)) {

                for (ListNode node : map.get(b.val)) {
                    if (node == b) {
                        return node;
                    }
                }

            }


            b = b.next;
        }

        return b;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}