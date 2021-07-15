public class Add {
    public static void main(String[] args) {
//        int a =1;
//        int b =10;
        int a =0;
        int b =-4;
        System.out.println(add(a,b));
    }
//    public static int add(int a, int b) {
//        int t = 0;
//        if(b>=0){
//            while(t != b){
//            a++;
//            t++;
//            }
//        }
//        else {
//            while(t != b){
//                a--;
//                t--;
//            }
//        }
//
//
//        return a;
//    }
    public static int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
