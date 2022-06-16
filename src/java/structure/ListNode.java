package structure;

/**
 * @author mango
 * @description  TODO
 * @email
 * @date 2022/4/11 9:40
 * @version 1.0
 */
public class ListNode {

    public int val;

    public ListNode next;

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
