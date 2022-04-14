package tree.problem1367;

/**
 * @author mango
 * @version 1.0
 * @description
 * @email
 * @date 2022/3/21 17:01
 */
public class ListNode {

    private int val;

    private ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
