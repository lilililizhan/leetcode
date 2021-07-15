package test;

public class t04042 {
    /*
    先竖着一刀，2份
    再横着一刀，4份，
    再横着一刀，6份


    先横着一刀，2份
    再横着一刀，3份，
    再横着一刀，4份，
    再竖着一刀，8份
     */
    public static void main(String[] args) {
//        int[] f = {1,0,0};
        int[] f = {0,0,0,1};
        int res = count2(f);
        System.out.println(res);
    }
//    public static int count(int[] f){
//        int x = 1;//横着有几份
//        int y = 1;//竖着有几份
//        int num = 1;
//        //t = 0,横着切，t =1,竖着切
//        for (int i = 0; i < f.length; i++) {
//            if(f[i] ==0){
//                x++;
//                num += y;
//            }
//            else {
//                y++;
//                num +=x;
//            }
//        }
//        return num;
//    }
    public static int count2(int[] f){
        int x = 1;//横着切了几刀
        int y = 0;//竖着切了几刀
        int num = 1;
        //t = 0,横着切，t =1,竖着切
        for (int i = 0; i < f.length; i++) {
            if(f[i] ==0){//横着
                x++;
                num += Math.pow(2,y);
            }
            else {//竖着
                y++;
                num += x;
            }
        }
        return num;
    }
}
