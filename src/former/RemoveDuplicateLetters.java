import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "bcabc";
        String r = removeDuplicateLetters(s);
        System.out.println(r);

    }
    public static String removeDuplicateLetters(String s) {
        /*
        先计算有多少个不重复的字符，然后使用两个指针，依次移动来获取字符串
        并不需要用到map，直接集合就好了，看哪个能有contaions函数
        直接set吧，set存储含有的字符个数，
        暴力法：直接找长度为num的string，使其不含重复元素
        indexof,看某个string是否含某个字符
        一个一个字符检验，当发现有重复字符时，就把start+1，
        */
        HashSet<Character> sset =new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(!sset.contains(s.charAt(i))){
                sset.add(s.charAt(i));
            }
        }
        int num = sset.size();
        int start = 0;
        int end = 0;
        String temp =s.substring(start,end);
//        HashSet<Character> temp = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(end - start  ==num){
                break;
            }
            if(temp.indexOf(s.charAt(i))==-1){ //如果不含某字符
                end = i+1;
                temp = s.substring(start,end);
            }
            else{
                start = start +1;
                temp = s.substring(start,end);
            }
        }
        System.out.println("start:  "+start);
        System.out.println("end:  "+end);
        return s.substring(start,end);
    }

}
