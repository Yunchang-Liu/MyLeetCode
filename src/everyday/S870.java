package everyday;

import java.util.Arrays;

/*
<田忌赛马> 把nums1当成是田忌的马，nums2当成是齐威王的马。
讨论田忌的下等马(nums1)的最小值：
    如果它能比过齐威王的下等马(nums2的最小值),那这一分田忌直接拿下；
    如果它比不过齐威王的下等马，则用田忌的下等马比齐威王的上等马(nums2的最大值)
 */
class S870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); //把nums1排序
        int[] res = new int[nums1.length]; //最后返回的结果
        Integer[] index = new Integer[nums1.length]; //索引数组，nums2数字从小到大的索引
        for(int i = 0; i < index.length; i++){
            index[i] = i;
        }
        Arrays.sort(index , (a,b) -> (nums2[a] - nums2[b])); //将index数组 按照nums2从小到大排列


        int small = 0;            //index第一个索引，也就是nums2中最小数对应的索引
        int big = index.length-1; //index最后一个索引，也就是nums2中最大数对应的索引

        for(int i = 0; i < nums1.length; i++){
            if(nums1[i] > nums2[index[small]]){ //判断nums1的最小 是否大于nums2的最小
                res[index[small]] = nums1[i]; //是 则把nums1最小的数 对应在nums2最小的数
                small++;
            }else{
                res[index[big]] = nums1[i];   //否 则把nums1最小的数 对应在nums2最大的数
                big--;
            }
        }
        return res;
    }
}