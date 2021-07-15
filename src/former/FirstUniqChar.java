import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {
    public static void main(String[] args) {
        String s= "leetcode";
//        String s= "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
    public static int firstUniqChar(String s) {
        /*
        本想使用map,但此处既要保存字符，又要保存个数，
        因此考虑使用两个map,另一个存字符和索引，但发现可以用函数根据字符得索引，
        因此最终使用一个map

        忘了考虑顺序问题
         */
        HashMap<Character,Integer> map = new HashMap<>();
        int temp;
        for (int i = 0; i < s.length(); i++) {
            temp = 0;
            if(map.keySet().contains(s.charAt(i))){
                temp = map.get(s.charAt(i));
                map.put(s.charAt(i),temp+1);
            }
            else {
                map.put(s.charAt(i),1);
            }

        }
        Character r;
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
//        for (Character c:map.keySet()
//             ) {
//            if(map.get(c)==1){
//                return s.indexOf(c);
////                break;
//            }
//        }
        return -1;
    }
}
