import java.util.HashMap;
import java.util.HashSet;

public class IsIsomorphic {
    public static void main(String[] args) {
//        String s = "egg";
//        String t = "add";
//        String s = "foo";
//        String t = "bar";
        String s = "paper";
        String t = "title";
//        String s = "ab";
//        String t = "aa";
        boolean b = isIsomorphic(s,t);
        System.out.println(b);
    }
    public static boolean isIsomorphic(String s, String t){
        return isIsomorphic0(s,t)&&isIsomorphic0(t,s);
    }
    public static boolean isIsomorphic0(String s, String t) {
        /*
        使用map
        注意a,b和a,a的情况
        使用两个map
         */
        boolean b= true;
        HashMap<Character,Character> map =new HashMap();
        HashMap<Character,Character> map2 =new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if(map.keySet().contains(s.charAt(i))){
                if(map.get(s.charAt(i)).equals(t.charAt(i))){
                    continue;
                }
                else {
                    b = false;
                    break;
                }
            }
            else {
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return b;
    }
}
