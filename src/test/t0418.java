package test;

public class t0418 {
    /*
    tengxun
     */
    public static void main(String[] args) {
        String[]  s = {"aaba","abaa",
        "aabb","abab",
        "aaabbb","bbbaaa",
                "cba","abc"};
//        for (int i = 0; i < s.length; i+=2) {
//            System.out.println(test(s[i],s[i+1]) ? "YES" :"NO");
//        }
        boolean b = test(s[4],s[5]);
        System.out.println(b);

    }
    public static boolean test(String s1, String s2){
        if(s1.length() != s2.length())return false;
        if(s1.length()%2==1) return s1.equals(s2);
        else {
            String temp1 = "";
            String temp2 = "";
            for (int i = 0; i < s1.length()/2; i++) {
                temp1 = s1.substring(i,i+s1.length()/2) +s1.substring(i+s1.length()/2) + s1.substring(0,i);
                temp2 = s1.substring(i+s1.length()/2) + s1.substring(0,i)+s1.substring(i,i+s1.length()/2) ;
                if(s2.equals(temp1) || s2.equals(temp2)) return true;
            }
            return  false;
        }
    }


}
