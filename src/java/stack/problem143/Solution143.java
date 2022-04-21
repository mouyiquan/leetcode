package stack.problem143;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mango
 * @version 1.0
 * @description 143. 重排链表
 * @email
 * @date 2022/4/21 8:34
 */
public class Solution143 {

    //转成线性连表再进行转换
    public ListNode reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        while (head.getNext() != null){
            list.add(head.getNext());
            head = head.getNext();
        }

        head = list.get(0);
        ListNode cur = head;
        boolean flag = true;
        int size = list.size();
        for (int i = 1; i <= size-i; i++) {
            ListNode listNode;

            listNode = list.get(size - i);
            cur.setNext(listNode);
            cur = listNode;

            if (i != size-i){
                listNode = list.get(i);
                cur.setNext(listNode);
                cur = listNode;
            }
        }
        cur.setNext(null);
        return head;
    }


    //
    public void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }

        // 获得中间节点
        ListNode mid = findMid(head);

        // 中间节点之后的部分进行反转
        ListNode head2 = mid.getNext();
        mid.setNext(null);
        head2 = reverseList(head2);

        // 合并
        ListNode head1 = head;
        mergeList(head1, head2);

    }

    // LeetCode 876
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast= fast.getNext().getNext();
        }
        return slow;
    }

    // LeetCode 206
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextNode = cur.getNext();
            cur.setNext(prev);
            prev =cur;
            cur = nextNode;
        }
        return prev;
    }


    private void mergeList(ListNode head1, ListNode head2) {
        ListNode next1 = null;
        ListNode next2 = null;
        while (head1 != null && head2 != null) {
            next1 = head1.getNext();
            next2 = head2.getNext();

            head1.setNext(head2);
            head1 = next1;

            head2.setNext(head1);
            head2 = next2;
        }
    }

    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(5,new ListNode(6,new ListNode(4,new ListNode(2))))));
        Solution143 solution143 = new Solution143();
        ListNode listNode = solution143.reorderList(listNode2);
        System.out.println(1);
    }

}
