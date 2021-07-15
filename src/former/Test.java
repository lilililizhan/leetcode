import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        System.out.println((double)(Integer.MAX_VALUE-6)/10);
//        Integer i =10;
//        int a = 10;
//        System.out.println(i==a);
//        int[] ab= new int[]{1,2,3,4,5};
//        int[] b = Arrays.copyOfRange(ab,0,3);
//        System.out.println(Arrays.toString(b));

//        int x = 125;
//        int y =2;
//        System.out.println((double)(x/y));
//        System.out.println(Math.ceil((double)x/y));
//
//        int a = 3;
//        int b = 2;
//        int c = (int)Math.ceil((double)a/b);
//        System.out.println(c);
//        String s = "0123456";
//        String r = s.substring(1,4);
//        System.out.println(r.toString());
//        int[][] shuzu = {{1,2,3},{4,5,6}};
//        int[][] r = shuzu.c
//        int[] r = new int[5];
//        System.out.println(r[0]);
//        String s = "abcde";
//        System.out.println(s.substring(0,3).toString());
//        System.out.println(s.indexOf(s.charAt(2)-0));

//        int i = 100;
//        int x1,x2,x3,y1,y2,y3;
//        x1 = i/100;
//        x2 = i%100/10;
//        x3 = i%10;
//        System.out.println("x1: "+x1);
//        System.out.println("x2: "+x2);
//        System.out.println("x3: "+x3);
//        System.out.println(sum(15));
        String s = "abcdefg";
//        System.out.println(s.substring(0,2));
        System.out.println((int)Math.sqrt(12));
        System.out.println((int)Math.sqrt(15));

    }
    public static int sum (int i){
        System.out.println(i/100);
        System.out.println((i%100)/10);
        System.out.println(i%10);
        return i/100+(i%100)/10+i%10;
    }
}
