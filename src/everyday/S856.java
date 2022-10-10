package everyday;

import java.util.ArrayDeque;
import java.util.Deque;
/*
    初始化将0压入栈中
        1.每次遇到'('压入栈中
        2.每次遇到')'即要进行一次算分
            1.弹出栈顶,即最近一次操作的分数,记为top
            2.得分分为两部分 第一部分即top
            3.第二部分是2*top(内部平衡括号分数乘2)和1的最小值(top有可能为0,而平衡括号至少1分)
              即stack.pop() + Math.max(2*top, 1);
            4.将当前得分再次压入栈
        3.栈顶分数即为最终得分
 */
class S856 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(0);
            }else{
                int top = stack.pop();
                int mark = stack.pop() + Math.max(2*top, 1);
                stack.push(mark);
            }
        }

        return stack.peek();
    }
}