public class MyAtoi {
    public static void main(String[] args) {
//        String s ="42";
//        String s ="   -42";
//        String s ="4193 with words";
//        String s ="4193 5 with words";
//        String s ="-91283472332";
//        String s ="91283472332";
//        String s ="+-12";
//        String s ="words and 987";
//        String s ="00000-42a1234";
//        String s =" 0000000000012345678";
//        String s ="0000000000012345678";
//        String s ="2147483648";
//        String s ="2147483646";
        String s ="-2147483647";
//        String s ="+1";
        int r = myAtoi(s);
        System.out.println("r-----------");
        System.out.println(r);
    }
    public static int myAtoi(String s){
//        用ASCii来判断
//        将字符串转换为字符数组，并依次判断，并保存
//        注意比较数字是否超过有效范围
//        0： 48   9：57   +：43    -：45  空格：32
//        注意数字的开头和结尾
        boolean start =false;
        String arr ="";
        int startnum =0;
        int endnum =0 ;
        int numnum = 0;
        char[] b = s.toCharArray();
        int i = 0;
        char f = 32;
        while(i < s.length()) {
            if ( start ==false && b[i] == 32) {
//                startnum = i+1;
            } else if (f ==32 && start ==false &&(b[i] == 43 || b[i] == 45 )) {
                f = b[i];
                start =true;
                startnum = i;
            } else if ( (b[i] >= 48 && b[i] <= 57)) {
                endnum = i;
                if (startnum ==0 && start == false){
                    startnum = i;
                }
                arr = s.substring(startnum, endnum+1);
                start =true;
            } else {
                break;
            }
            i++;
        }
        int sum =0;
        System.out.println(arr);
        if (arr.length()==0){
            return 0;
        }
        if(f == 45 || f ==43){
           arr = arr.substring(1,arr.length()) ;
        }
        System.out.println("arr");
        System.out.println(arr);
        for (int j = 0; j <arr.length(); j++) {
//            System.out.println(arr.charAt(j));
//            System.out.println(arr.charAt(j)-48);
            int a =arr.charAt(j)-48;
            System.out.println(a*10);
            if((double)(Integer.MAX_VALUE-a)/10 < sum){
                sum = f ==45 ? Integer.MIN_VALUE: Integer.MAX_VALUE;
                break;
            }
            sum = sum*10 + a;
            System.out.println(sum);
            System.out.println("-----------");
        }
        System.out.println("sum:");
        System.out.println(sum);
//        int l = (int) (Math.pow(2,31));
//        System.out.println("l---");
//        System.out.println(l);
        if(f ==45){
            return  sum <= Integer.MAX_VALUE ? -sum : Integer.MIN_VALUE;
        }
        else {
            return  sum <= Integer.MAX_VALUE ? sum : Integer.MAX_VALUE;
        }
    }
}
