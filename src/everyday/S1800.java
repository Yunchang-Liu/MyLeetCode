package everyday;

public class S1800 {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0]; //先假设第一个数是最大值，省去了讨论数组只有1个数的情况

        for (int i = 0; i < nums.length-1; i++){
            int sum = 0;  //每次重置sum
            sum += nums[i];
            while ( i < nums.length-1 && nums[i] < nums[i+1] ){ //升序和
                sum += nums[i+1];
                i++;
            }
            maxSum = sum > maxSum ? sum : maxSum; //也可以Math.max(sum, maxSum)
        }
        return maxSum;
    }
}
