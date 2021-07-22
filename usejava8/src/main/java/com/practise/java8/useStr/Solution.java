package com.practise.java8.useStr;

public class Solution {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(121);
        ListNode listNode2 = new ListNode(18);
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode);
        //相同的位置直接叠加
        //考虑进位制
    }

    /**
     * 基本的思路：
     *  从个位开始求和与进位（进位包括：除当前位的所有的位）
     *  +
     *  循环到下一位
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 求头尾的值
         */
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                //1、求当前最低位
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            //2、剩下的进位数
            carry = sum / 10;
            //进行下一next的求解
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}

class ListNode {
    //第一位的值
    int val;
    //下一位的值
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
