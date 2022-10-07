package everyday;

class S1694 {
    public String reformatNumber(String number) {
        String s = number.replace(" ", "").replace("-", "");  //去除其他字符

        int n = s.length();
        int num = n / 3;     //判断有几组3
        int remain = n % 3;  //剩余几个数字

        StringBuilder sb = new StringBuilder();

        int count = 0;
        int start = 0;
        while(count < num){
            sb.append(s.substring(start, start+3));
            sb.append("-");
            start+=3;
            count++;
        }

        if(start < n)
            sb.append(s.substring(start)); //把剩余字符都填入

        if(remain == 0)                           //1.整除3,最后多加了一个‘-’,需要去掉
            sb.deleteCharAt(sb.length()-1);       //2.除3余1,‘-’的位置往后了一个，如XXX-123-1
        else if(remain == 1)                      //3.除3余2,无需改动，如XXX-12-34
            sb.deleteCharAt(sb.length()-2).insert(sb.length()-2, '-');
                                                  //deleteCharAt:删除某位置的字符
                                                  //insert(idx, c):将字符c插入到idx的位置
        return sb.toString();
    }
}