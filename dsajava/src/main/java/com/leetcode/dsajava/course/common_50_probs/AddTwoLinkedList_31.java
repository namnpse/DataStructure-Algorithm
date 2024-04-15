package com.leetcode.dsajava.course.common_50_probs;

import com.leetcode.dsajava.course.common_50_probs.common.LinkedList;
import com.leetcode.dsajava.course.common_50_probs.common.Node;

public class AddTwoLinkedList_31 {

    // Section 31:
    public static LinkedList addTwoLinkedLists(LinkedList list1, LinkedList list2) {
        LinkedList res = new LinkedList();
        Node dummyNode = new Node(0);
        int module = 0;
        Node temp = dummyNode;
        Node temp1 = list1.head;
        Node temp2 = list2.head;
        while (temp1 != null || temp2 != null) {
            int sum = module
                    + (temp1 != null ? temp1.data : 0)
                    + (temp2 != null ? temp2.data : 0);
            module = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
        }
        if (module > 0) {
            temp.next = new Node(module);
        }
        res.head = dummyNode.next; // remove dummy node
        return res;
    }
}
