package linkedList;

import lombok.Data;
import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode445Test {
    @Test
    public void leetcode445Test() {

        //      You are given two non-empty linked lists representing two non-negative integers.
        //
        //      The most significant digit comes first and each of their nodes contain a single digit.
        //
        //      Add the two numbers and return it as a linked list.
        //
        //      You may assume the two numbers do not contain any leading zero, except the number 0 itself.
        //
        //      Follow up:
        //      What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
        //
        //      Example:
        //
        //      Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        //      Output: 7 -> 8 -> 0 -> 7


        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);

        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode normalL1 = reverse(l1);
        ListNode normalL2 = reverse(l2);

        ListNode prev = null;
        ListNode temp;


        int add = 0;
        int sum = 0;
        while (normalL1 != null || normalL2 != null || add != 0) {

            if (normalL1 != null) {

                sum += normalL1.val;
                normalL1 = normalL1.next;
            }
            if (normalL2 != null) {

                sum += normalL2.val;
                normalL2 = normalL2.next;
            }

            sum += add;
            add = sum / 10;
             temp= new ListNode(sum % 10);
            temp.next = prev;
            prev = temp;
            sum = 0;
        }



        return reverse(prev);
    }




    public ListNode reverse(ListNode node) {

        if (node == null || node.next == null) {
            return node;
        }

        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }

        return prev;
        
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode resultHead=new ListNode(-1);


        ListNode normalL1=reverseNodeList(l1);
        ListNode normalL2=reverseNodeList(l2);
        int sum=0;
        int carry=0;
        ListNode curr;
        ListNode after;
        while(normalL1!=null||normalL2!=null){
            if(normalL1!=null){
                sum+=normalL1.val;
                normalL1=normalL1.next;
            }

            if(normalL2!=null){
                sum+=normalL2.val;
                normalL2=normalL2.next;
            }
            sum+=carry;

            curr=new ListNode(sum%10);

            after=resultHead.next;
            resultHead.next=curr;
            curr.next=after;

            carry=sum/10;
            sum=0;
        }

        if(carry==1){
            curr=new ListNode(1);
            after=resultHead.next;
            resultHead.next=curr;
            curr.next=after;
        }


        return resultHead.next;
    }


    private ListNode reverseNodeList(ListNode list){
        ListNode prev=null;
        ListNode curr=list;
        ListNode tempNext;
        while(curr!=null){
            tempNext=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tempNext;
        }
        return prev;
    }
}
