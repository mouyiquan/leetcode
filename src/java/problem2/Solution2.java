package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author mango
 * @version 1.0
 * @description 两数相加
 * @email
 * @date 2022/3/21 17:00
 */
public class Solution2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int highLevel = 0;

        List<ListNode> list = new ArrayList<>();

        while(l1 != null || l2 != null){
            int i = 0;
            if (l1 != null){
                i = l1.getVal();
            }
            int i2 = 0;
            if (l2 != null){
                i2 = l2.getVal();
            }
            int sum = i + i2 + highLevel;

            ListNode listNode = new ListNode();
            listNode.setVal(sum % 10);
            highLevel = sum / 10;

            list.add(listNode);

            if ((l1 == null || l1.getNext() == null )&& (l2 == null || l2.getNext() == null)){
                if (highLevel != 0){
                    ListNode tmp = new ListNode();
                    tmp.setVal(highLevel);
                    list.add(tmp);
                }
                break;
            }
            if (l1 != null ){
                l1 = Optional.ofNullable(l1.getNext()).orElse(null);
            }
            if (l2 != null ){
                l2 = Optional.ofNullable(l2.getNext()).orElse(null);
            }
        }

        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).setNext(list.get(i+1));
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9,new ListNode(9,new ListNode(9)));
        ListNode listNode2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))))));
        ListNode result = addTwoNumbers(listNode1, listNode2);
        System.out.println(result.toString());
    }
}
