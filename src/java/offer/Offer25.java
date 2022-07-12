package offer;

import java.util.List;

/**
 * @author mango
 * @version 1.0
 * @description 剑指 Offer 25. 合并两个排序的链表
 * https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/submissions/
 * @email
 * @date 2022/6/13 17:40
 */
public class Offer25 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null){
            return list2;
        }

        if (list2 == null){
            return list1;
        }

        ListNode result = new ListNode();
        ListNode pre = result;
        while (list1!=null  && list2!=null){
            if (list1.val > list2.val){
                pre.next = list2;
                list2 = list2.next;
            }else {
                pre.next = list1;
                list1 = list1.next;
            }
            pre = pre.next;
        }
        
        if (list1!=null ){
            pre.next = list1;
        }
        if (list2!=null){
            pre.next = list2;
        }

        return result.next;
    }

}
