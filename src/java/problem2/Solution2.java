package problem2;

import java.util.List;

/**
 * @author mango
 * @version 1.0
 * @description 两数相加
 * @email
 * @date 2022/3/21 17:00
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.getVal() == 0){
            return l2;
        }
        if (l2.getVal() == 0){
            return l1;
        }
        int highLevel = 0;

        ListNode result = new ListNode();
        while(l1 != null || l2 != null){

            //设置进位和当前node的值
            int i = l1.getVal() + l2.getVal() + highLevel;

            ListNode listNode = new ListNode();
            listNode.setVal(i / 10);
            highLevel = i % 10;

            result.setNext(listNode);
            if (l1.getNext() == null && l2.getNext() == null){
                if (highLevel != 0){

                }
                return listNode;
            }
            if (l1.getNext() == null){
                l1 = new ListNode(0);
            }

            if (l2.getNext() == null){
                l2 = new ListNode(0);
            }
        }

        return listNode;
    }

}
