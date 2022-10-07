package everyday;
/*
1.先计算数组中1的个数是否为3的整数倍
2.若不是，一定不能三等分，直接返回[-1,-1];
  若是，找到三部分中各自第一个1，记录索引为i,j,k
  (为什么可以直接找第一个1，因为题干说前导0可忽略，无须比较)
3.然后从i,j,k各自往后检查，若数字不相同则说明无法三等分，若k到达最后则返回正确分割索引
 */
class S927 {
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int oneNum = 0;
        for(int d : arr){  //统计1的个数
            oneNum += d;
        }

        if(oneNum % 3 != 0)  //若1的个数不是3的整数倍，直接返回
            return new int[]{-1, -1};
        if(oneNum == 0)      //若都是0，一定能等分，随便返回
            return new int[]{0, n-1};

        int i = 0;
        int j = 0;
        int k = 0;
        int onethird = oneNum / 3;

        int count = 0;
        int idx = 0;
        while(count < 1){ //找到第一等分第一个1的索引i
            if(arr[idx] == 1)
                count++;
            idx++;
        }
        i = idx-1;

        while(count < onethird+1){ //找到第二等分第一个1的索引j
            if(arr[idx] == 1)
                count++;
            idx++;
        }
        j = idx-1;

        while(count < 2*onethird+1){ //找到第三等分第一个1的索引k
            if(arr[idx] == 1)
                count++;
            idx++;
        }
        k = idx-1;

        while(k < n-1){ //到n-1即可，因为+1比较，否则会数组越界
            if( arr[i+1] == arr[j+1] && arr[j+1] == arr[k+1] ){ //三部分同步往后检查是否相等
                i++; j++; k++;
            }else{  //不相等则返回[-1,-1]
                return new int[]{-1, -1};
            }
        }

        return new int[]{i, j+1};
    }
}