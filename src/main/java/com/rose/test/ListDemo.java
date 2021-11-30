package com.rose.test;


import java.util.*;

/**
 * Created on 2021/8/25 10:31
 *
 * @author Rose
 */
public class ListDemo {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int T = scanner.nextInt();
//        int[] input = new int[T];
//        int[] output = new int[T];
//        for (int i = 0; i < T; i++) {
//            input[i] = scanner.nextInt();
//        }
//        for (int i = 0; i < input.length; i++) {
//            output[i] = getNum(input[i]);
//        }
//
//        for (int i = 0; i < output.length; i++) {
//            System.out.println(output[i]);
//        }
//        int [] nums = {1,2,3};
//        Arrays.stream(twoSum(nums, 3)).forEach(System.out::println);
        ListNode l1 = new ListNode(9);
//        ListNode listNode = l1;
//        ListNode listNode1 = new ListNode(2);
//        listNode.next = listNode1;

        int [] a = new int[]{1,9,9,9};
        ListNode l2 = new ListNode(a[0]);
        ListNode listNode2 = l2;
        for (int i = 1 ; i< a.length;i++) {
            ListNode listNode3 = new ListNode(a[i]);
            listNode2.next = listNode3;
            listNode2 = listNode2.next;
        }
        ListNode listNode4 = addTwoNumbers(l1, l2);
        while (!Objects.isNull(listNode4)){
            System.out.print(listNode4.val+"");
            listNode4 = listNode4.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int flag = 0;
        while (l1 != null || l2 != null || flag != 0){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + flag;
            flag = sum / 10;
            ListNode sumNode = new ListNode(sum % 10);
            temp.next = sumNode;
            temp = sumNode;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        return head.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static int getNum(int num) {
        int n = num;
        int temp,res = 0;
        boolean flag = false;
        List<Integer> list = new ArrayList<>();
        while(n != 0){
            temp = n % 10;
            n = n / 10;
            list.add(temp);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > 3){
                res = (int) (res + 3 * Math.pow(10,i));
            }else if (list.get(i) <= 0){
                res = (int) (res + 3 * Math.pow(10,i));
                list.set(i + 1,list.get(i + 1) - 1);
                flag = true;
            }else {
                res = (int) (res + list.get(i) * Math.pow(10,i));
            }
        }
        if ((list.get(list.size() - 1) == 1 || list.get(list.size() - 1) == 2 || list.get(list.size() - 1) == 3) && flag){
            res = (int) (res + ((list.get(list.size() - 1) -1) * Math.pow(10, (list.size() - 1))));
        }else {
            res = (int) (res + (list.get(list.size() - 1)) * Math.pow(10, list.size() - 1));
        }
        return res;
    }

}



