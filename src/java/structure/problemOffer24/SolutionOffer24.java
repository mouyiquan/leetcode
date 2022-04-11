package structure.problemOffer24;

/**
 * @author mango
 * @version 1.0
 * @description 剑指 Offer 24. 反转链表
 * @email
 * @date 2022/4/11 9:40
 */
public class SolutionOffer24 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
