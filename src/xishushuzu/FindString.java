package xishushuzu;

public class FindString {
    public static void main(String[] args) {
        String[] words = {"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""};
//        String s ="ta";
        String s ="ball";
        System.out.println(findString(words,s));

    }
    public static int findString(String[] words, String s) {
        for (int i = 0; i < words.length; i++) {
            if(words[i] ==null){
                continue;
            }
            else{
                if(s.equals(words[i])){
                    return i;
                }
            }

        }

        return  -1;

    }
}
