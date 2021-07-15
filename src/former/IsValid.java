import com.sun.corba.se.impl.orb.ParserTable;

import java.util.ArrayList;

public class IsValid {
    public static void main(String[] args) {
//        String s = "()[]{}";
//        String s = "()";
//        String s = "(]";
//        String s = "([)]";
//        String s = "{[]}";
        String s = "[";
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {
        /*
        ()为0，【】为+-1.{}为+-2，相加为0为一对
        创建一个数组要求：
        当有新括号加入时，保证：
        左括号没影响；
        右括号必须和最接近的左括号一致；一致的话立即删除括号对；
        看最终是否为空；
        空格无影响；

        压栈出栈的方式比较好：
        进左括号，入栈；右括号，出栈；
         */
        ArrayList<Character>  kuohao= new ArrayList<>();
        char[]  sk = s.toCharArray();
        for (int i = 0; i < sk.length; i++) {
            if(sk[i] == '(' || sk[i] == '[' || sk[i] == '{'){
                kuohao.add(sk[i]);
            }
            else if(sk[i]==' '){
                continue;
            }
            else{
                if(kuohao.size() <1){
                    return false;
                }
                else if((kuohao.get(kuohao.size()-1) == '(' && sk[i] == ')') || (kuohao.get(kuohao.size()-1) == '[' && sk[i] == ']') || (kuohao.get(kuohao.size()-1) == '{' && sk[i] == '}') ){
                    kuohao.remove(kuohao.size()-1);
                }
                else{
                    return false;
                }
            }

        }
        if(kuohao.size()==0){
            return true;
        }
        else {
            return false;
        }

    }
}
