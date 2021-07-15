package former;
import javax.jws.soap.SOAPMessageHandlers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class wordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s= "dog cat cat dog";

//                String pattern = "abba";
//        String s= "dog cat cat fish";
//        String pattern = "aaaa";
//        String s = "dog cat cat dog";

//        String pattern = "abba";
//        String s = "dog dog dog dog";
        wordPattern(pattern,s);
        boolean b =wordPattern(pattern,s);
        System.out.println("r:   "+b);

    }
    public static boolean wordPattern(String pattern, String s) {
        boolean b =true;
        HashMap<Character,String> map=new HashMap<>();
        ArrayList<Character> key=new ArrayList<>();
        ArrayList<String> value=new ArrayList<>();
        String[] sl = s.split(" ");
        if(pattern.length() != sl.length){
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            if( key.contains(c)){
                if(map.get(c).equals(sl[i])){
                    continue;
                }
                else {
                    b = false;
                }
            }
            else{
                key.add(c);
                if(value.contains(sl[i])){
                    return false;
                }
                else {
                    map.put(c,sl[i]);
                    value.add(sl[i]);
                }

            }

        }
//        for (String ss:sl
//             ) {
//            System.out.println(ss);
//        }


        return b;
    }
}
