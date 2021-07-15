package backtrack;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    /*
    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    输入：n = 3
    输出：["((()))","(()())","(())()","()(())","()()()"]

   回溯类型，22，middle
   用到栈的思想，先左括号，然后，看是右括号还是继续左括号，
   感觉，只要左括号的个数大于右括号的个数，就可以了，
   定义两个存储的数组，不用定义数组，直接用n 和index标记就好

   时间96%，空间6%
   总用时25分钟以下

   官方答案有个是一样的，回溯法添加，
   还有一种思路是：递归调用，任意一种组合可以表示为 (a)b,其中a,b是合法的括号序列（可以为空），这种方法看的不是很懂，
     */
    public static void main(String[] args) {
//        int n  = 3;
        int n  = 1;
        List<String> res = generateParenthesis(n);
        System.out.println(res);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesis2(n,res,sb,0,0);
        return res;
    }
    public static void generateParenthesis2(int n,List<String> res, StringBuilder sb,int lindex,int rindex) {
        if(sb.length() == n*2){
            res.add(String.valueOf(sb));
            return;
        }
        if(lindex <n) {
            sb.append('(');
            generateParenthesis2(n, res, sb, lindex + 1, rindex);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(lindex >rindex){
            sb.append(')');
            generateParenthesis2(n, res, sb, lindex, rindex+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
