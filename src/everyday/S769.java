package everyday;

/*
    数组arr长度为n,且由[0,n-1]范围内的整数组成,而各不相同,0-9
    那么数组排好序后，每个值和下标恰好是相等的
    从左到右遍历数组，并且分别对值和下标累加求和，只要两个和相等，就切出一个块
    ！！神奇的思路！！
 */

class S769 {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int sum = 0;
        int idxsum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            idxsum += i;
            if(sum == idxsum)
                res++;
        }
        return res;
    }
}