package everyday;

/*
题意: 从nums中挑选数字来组成head的子链表, nums和head中的数字都不重复,使问题变简单
     子链表要取最长,例如有子链表1-2-3,1-2就不用记了,计数只+1

思路: 使用HashSet或者数组(用0,1表示)来记录nums中有的数字
     循环链表,直到得到最长子链表,计数+1
     若链表中的数字在nums中没有,head = head.next即可
 */
//class Solution {
//    public int numComponents(ListNode head, int[] nums) {
//        Set<Integer> set = new HashSet<>();    //HashSet来记录nums中出现的数字
//        for(int num : nums)
//            set.add(num);
//
//        int res = 0;
//        while(head != null){
//            if(set.contains(head.val)){
//                while(head != null && set.contains(head.val))   //得到最长子链表(组件)
//                    head = head.next;
//                res++;
//            }else{
//                head = head.next;
//            }
//        }
//        return res;
//    }
//}