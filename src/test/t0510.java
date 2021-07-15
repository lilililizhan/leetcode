package test;

import java.text.NumberFormat;

public class t0510 {
    public static void main(String[] args) {
//        int i = 0xFFFFFFF1;
//        int j = ~i;
//        System.out.println(j);
//        String foo = "blue";
//        Boolean bar = new Boolean[1];
//        if(bar[0])foo = "green";
//        int i =1;
//        int j = i++;
//        if((i>++j)&&(i++==j))i+=j;
//        System.out.println(i);

        Integer i = new Integer(42);
        Long l = new  Long(42);
        Double d = new Double(42.0);
//        System.out.println(i==l);
//        System.out.println(i==d);
////        System.out.println(d==l);
//        System.out.println(i.equals(d));
//        System.out.println(d.equals(i));
//        System.out.println(i.equals(42));

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(4);
        nf.setMinimumFractionDigits(2);
        String a = nf.format(3.1415926);
        String b= nf.format(2);
        System.out.println(a);
        System.out.println(b);
    }
}
class A{
    public byte getNumber(){
        return 1;
    }
}
//class B extends A{
//    public short getNumber(){
//        return 2;
//    }
//}

interface s{
     int my = 10;

}