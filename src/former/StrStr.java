package former;
public class StrStr {
    public static void main(String[] args) {
//        String haystack ="hello";
//        String needle = "ll";
//        String haystack ="aaaaa";
//        String needle = "bba";
//        String haystack ="";
//        String needle = "";
//        String haystack ="a";
//        String needle = "a";
        String haystack= "mississippi";
        String needle ="issip";
        int r =strStr2(haystack,needle);
        System.out.println(r);

    }
    public static int strStr(String haystack, String needle) {
        /*
        循环遍历，
        定义两个标识符，
            有字符匹配
            当前对比的字符

        看了官方的答案，可以从i开始，直接比较n个字符串
         */
        boolean b = false;
        int index = -1;
        int temp = 0;
        if(needle.length()==0){
//            if(needle ==""){
            return 0;
        }
        int i = 0;
        while (i<haystack.length()){
//        for (int i = 0; i < haystack.length(); i++) {
            if(!b){
                if(haystack.charAt(i)==needle.charAt(temp)){
                    b = true;
                    index = i;
                    temp++;
                }
                i++;
            }
            else {
                if(temp == needle.length()){
                    return index;
                }
                if(haystack.charAt(i)==needle.charAt(temp)){
                    temp++;
                    i++;
                }
                else {
                    b = false;
                    i = index+1;
                    temp = 0;
                    index =-1;

                }
            }
        }
        if(b==true && temp ==needle.length()){
            return index;
        }
        return -1;

    }
    public static int strStr2(String haystack, String needle) {
        int l = haystack.length();
        int n = needle.length();
        for (int i = 0; i < l-n+1; i++) {
            if(haystack.substring(i,i+n).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
