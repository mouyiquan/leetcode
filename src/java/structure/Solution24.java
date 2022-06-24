package structure;

/**
 * @author mango
 * @version 1.0
 * @description
 * 24. 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 * @email
 * @date 2022/6/24 12:56
 */
public class Solution24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next!=null){

            ListNode curNext = cur.next;
            ListNode nextNext =  cur.next.next;


            curNext.next = nextNext.next;
            nextNext.next = curNext;

            cur.next = nextNext;

            cur = curNext;
        }

        return dummyHead.next;
    }


}
