package everyday;
/*
    1.假设字符串中素有的字符都是不重复的
    遍历第1个字符‘a’：子序列总数 = 1（字符‘a’本身）= 1
    遍历第2个字符‘b’：子序列总数 =【字符'a'的子序列总数】+ 1（字符‘b’本身）= 1 + 1 = 2；
    遍历第3个字符‘c’：子序列总数 =【字符'a'的子序列总数】+ 【字符'b'的子序列总数】+ 1（字符‘c’本身）= 1 + 2 + 1 = 4；
    遍历第4个字符‘d’：子序列总数 =【字符'a'的子序列总数】+【字符'b'的子序列总数】+【字符'c'的子序列总数】+ 1（字符‘d’本身）= 1 + 2 + 4 + 1 = 8；
    【总结果】 = 1 + 2 + 4 + 8 = 15

    2.如果字符串中出现重复字符
    在第1次遍历到字符‘b’的时候：子序列为“ab”、“b”；
    在第2次遍历到字符‘b’的时候：子序列为“ab”、“b”、“abb”、“bb”、“acb”、“abcb”、“bcb”、“cb”；
    【结论】我们发现第2次遍历字符'b'的时候，已经包含了第1次遍历字符'b'的子序列了。
    所以，在统计最终结果的时候，我们需要把“上一次”相同字符子序列总数减去才可以。
 */
class S940 {
    public int distinctSubseqII(String s) {
        int mod = (int)1e9 + 7;
        long[] res = new long[26];
        long result = 0L;
        for(char c : s.toCharArray()){
            long pre = res[c - 'a'];                //记录上一次相同字符子序列总数
            res[c - 'a'] = (result + 1) % mod;
            result = (result + res[c - 'a'] - pre + mod) % mod;     //+mod是为了防止出现负数
        }
        return (int)result;
    }
}