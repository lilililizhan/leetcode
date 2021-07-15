package test;

public class t04141 {
    /*
    leetcode 1190,中等
给出一个字符串 s（仅含有小写英文字母和括号）。
请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
注意，您的结果中 不应 包含任何括号。
    (u(love)i)
    判断内层的反转次数，然后拼接字符串
    "a(bcdefghijkl(mno)p)q"出错，没有判断括号

    "ta()usw((((a))))"//"tauswa"
    "sxmdll(q)eki(x)"从这个得出，我的思路不对，括号不一定是嵌套的，所以要找到成对的括号，

    官方用栈来实现，没太看懂，想法很好，
     */
    public static void main(String[] args) {
//        String s = "(u(love)i)";//iloveu
//        String s = "(x(u(love)i)y)";//yuevolix
//        String s = "(x)";//x
//        String s = "(ed(et(oc))el)";//leetcode
//        String s ="a(bcdefghijkl(mno)p)q";//"apmnolkjihgfedcbq"
//        String s ="ta()usw((((a))))";//tauswa
        String s ="sxmdll(q)eki(x)";//
        String r = reverse(s);
        System.out.println(r);
    }
    public static String reverse(String s){

        return reverse2(s,1,0,s.length()-1);
    }

    public static String reverse2(String s, int k, int left,int right){
        StringBuilder sbl = new StringBuilder();
        StringBuilder sbr = new StringBuilder();
        if(left>right)return new String();
        else if(left==right)return ""+s.charAt(left);
        if (s.charAt(left) =='('){
            if(s.charAt(left+1)==')')left+=2;
            else {
                left++;
                right--;
                k++;
            }
        }

        while(left <= right){
            if(s.charAt(left) == '(')break;
            else {
                if(k%2==1)  sbl.append(s.charAt(left));
                else sbl.insert(0,s.charAt(left));
                left++;
            }
        }
        while (right>=left){
            if(s.charAt(right)==')')break;
            else {
                if(k%2==1)sbr.insert(0,s.charAt(right));
                else sbr.append(s.charAt(right));
                right--;
            }
        }
        if(k%2==1){
            return sbl.toString()+reverse2(s,k,left,right)+sbr.toString();
        }
        else return sbr.toString() +reverse2(s,k,left,right)+sbl.toString();
    }
}
