package jianzhiOffer.middle;

public class FindNthDigit {
    /*
    n的大小到2^31,
    并不知道要写道第几个数字，
    并且n太大了
    考虑一下，100-200，200-300的数的相似性
    先试一试简单粗暴的方法吧,并不需要构造字符串，仅计数即可
    1000000000,超出时间限制

    1-9   9*1        9
    10-99 90*2       189
    100-999 900*3    2889
    1000-9999 9000*4  38889
    首先确认应该是几位数，再确认是那一个数，再确认是哪个数，注意这里的kSum会超出2^31次方，使用long

    思路是一样的，但是为什么时间和空间复杂度差了那么多呢，官方的是n--的，重新写一下
    最后确定是72的第几位数时可以用取模的运算，
    res = int(s[(n - 1) % digit]) # 获得 num 的 第 (n - 1) % digit 个数位，并转化为 int，n%digit = 1或0时，都正确

    num = start + (n - 1) // digit  这一步绝了，n%digit==0时，没问题，n%digit ==1时也对，保证了永远向上取整
    */
    public static void main(String[] args) {
//        0 1 2 3 4 5 6 7 8 9 1 0 1 1 1 2 1 3 1 4 1 5
//        int n = 135;
//        int n = 134;
//        int n = 1000000000;
        int n = 11;
        int r  = findNthDigit(n);
//        int r2 = findNthDigit2(n);
        int r3 = findNthDigit3(n);
        System.out.println("r:  "+r);
        System.out.println("r3:   "+r3);
//        findNthDigit2(134);

    }
    public static int findNthDigit(int n) {
        if(n==0)return 0;
        int k = 0;
        int num = 0;
        String s;
        char c = ' ';
        while(k<n){
            num++;
            s = num +"";
            k += s.length();
            if(k >=n){
                c = (num+"").charAt(s.length()-1-(k-n));
                break;
            }
        }
        return c-48;
    }

    public static int findNthDigit2(int n) {
        int weishu = 1;
        long kSum = 9;
        if(n<10)return n;
        while (kSum < n){
            weishu ++;
            kSum += weishu*9*Math.pow(10,weishu-1);
        }
        System.out.println("weishu:  "+weishu);
        kSum -=weishu*9*Math.pow(10,weishu-1);
        System.out.println("kSum:  "+kSum);
        int c = (int)Math.ceil((double)(n-kSum)/weishu);
        System.out.println("c: " +c);
        kSum += c*weishu;
        System.out.println("kSum:  "+kSum);
        int temp = (int) (Math.pow(10,weishu-1)-1+c);
        System.out.println("temp:  "+temp);
        String s = temp+"";
        int ch = (char)s.charAt((int) (s.length()-1-(kSum-(long)n)))-48;
        System.out.println(ch);
        return ch;
    }

    public static int findNthDigit3(int n) {
        int weishu = 1;
        int kSum = 9;
        if(n<10)return n;
        while (kSum < n){
            n = n - kSum;
            weishu ++;
            kSum = (int) (weishu*9*Math.pow(10,weishu-1));
        }
        System.out.println("weishu:  "+weishu);
        System.out.println("kSum:  "+kSum);
        System.out.println("n:  "+n);
        int c = (int)(Math.pow(10,weishu-1)+Math.ceil((double)n/weishu)-1);
        System.out.println("c: " +c);
        String s = c+"";
        int ch = (char)s.charAt((n-1)%weishu)-48;
        System.out.println(ch);
        return ch;
    }
}
