package simulation.problem25;


import java.util.List;

/**
 * @author mango
 * @date 2022/4/10 11:57
 * @version 1.0
 * @description:
 */
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.setNext(head);
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.getNext();
                if (tail == null) {
                    return hair.getNext();
                }
            }
            ListNode nex = tail.getNext();
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.setNext(head);
            tail.setNext(nex);
            pre = tail;
            head = tail.getNext();
        }

        return hair.getNext();
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.getNext();
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.getNext();
            p.setNext(prev);
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
