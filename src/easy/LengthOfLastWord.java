package easy;

public class LengthOfLastWord {
    /*
    咋不太懂啥意思，啥叫不存在最后一个单词，
     */
    public static void main(String[] args) {
//        String s ="hello world ";
//        String s ="hello world";
//        String s ="hello";
        String s ="a";
        int r = lengthOfLastWord(s);
        System.out.println(r);

    }
    public static int lengthOfLastWord(String s) {
        boolean b = false;
        int num = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i) !=32 && !b ){
                b = true;
                num++;
            }
            else if(s.charAt(i) != 32 && b)num++;
            else if(s.charAt(i) == 32 && b)break;
        }
        return num;
    }
}

