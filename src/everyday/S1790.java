package everyday;
/*
由于最多只能对其中一个字符串进行一次字符交换，
说明s1和s2最多只能有两个位置字母不相同
(若有3个及以上,一次交换不完)

使用数组存放两个不相同字母的索引,若diff超过2直接返回false
最后只需比较不同的两个位置是否交叉相等即可(s1[i]==s1[j] 且 s1[j]==s1[i])
 */
class S1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] arr = new int[2];
        int diff = 0;

        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(diff ==2)
                    return false;
                arr[diff] = i;
                diff++;
            }
        }

        return s1.charAt(arr[0]) == s2.charAt(arr[1]) && s1.charAt(arr[1]) == s2.charAt(arr[0]);
    }
}