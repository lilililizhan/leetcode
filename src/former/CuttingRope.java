public class CuttingRope {
    public static void main(String[] args) {
        /*
        发现一个问题，120分40段，每段3，则最后面积为1.21577E+19，取模为953270272
                    120分12段，每段10，则最后面积为1E+12，取模为999993007，
                    发现此时取模前后的大小顺序不一致，故应该先制定策略，再进行取模运算
                    long类型只有2^64次方，远小于n的值1000
         尝试一下double类型,对120来说，能发现40时最大，但因为小数点的位数，依然不精确，取模运算后会有误差
         通过看官方的解答，先通过数学求导得知，每段均分时最大，再通过设函数求导数得每段为3时最大，
            同时对余数为1，余数为2的情况进行分析
         后面根据官方的思路进行修改，但在一些中间变量定义的时候，使用了int类型，而不是long类型，导致结果一直不对
         */
//        int m = mlu(8,3);
//        System.out.println(m);
//        int Area=cuttingRope(8);
//        System.out.println((int)Math.pow(10,9)+7);
        int temp =(int)(Math.pow(10,9)+7);
//        System.out.println(2*9);
//        long t =429981696;
//        System.out.println((t*12)%temp);
//        int Area=cuttingRope(120);
//        int Area1=cuttingRope1(120);
//        int Aread=cuttingRoped(120);
        int AreaNew=cuttingRopeNew(127);
        System.out.println("Areanew:  "+AreaNew);
//        System.out.println(modQic(12,10,temp));
//        System.out.println("Area:  "+Area);
//        System.out.println("Area1:  "+Area1);
//        System.out.println("Aread:  "+Aread);
//        System.out.println(Area%temp);
//        int t1 =(int)(Math.pow(10,9)+8);
//        int t2 =(int)(Math.pow(10,9)+7);
//        System.out.println(t1);
//        System.out.println(t2);
//        System.out.println(t1%t2);
        long a = mlu(120,40);
        long b = mlu1(120,40);
        long c = mlu1(120,43);
//        System.out.println(temp);
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println((long)(a%temp));
//        System.out.println((long)a%temp);
//        System.out.println((long)a%temp);

    }
    //以下是按照官方的解题思路来
    public static int cuttingRopeNew(int n){
        int p =(int)(Math.pow(10,9)+7);
        if(n<=3){
            return n-1;
        }
        int s = n/3;
        int y = n%3;
        long r =1;
        System.out.println("s: "+s+" y: "+y);
        r = modQic(3,s-1,p);
        if(y==0){
            r= ((r%p)*3)%p;
        }
        else if(y==1){
            r = ((r%p)*4)%p;
        }
        else {
            r = ((r%p)*6)%p;
        }
        return (int)r;
    }
    public static int modQic(int x,int k,int p){
        long r =1;
        System.out.println(x+"  "+k+"  "+p);
        for (int i = 0; i < k; i++) {
            r = (r*x)%p;
            System.out.println(r);
        }
        return (int)r;
    }
    public static int cuttingRope(int n) {
        /*
        首先排除穷举法，记得似乎有一个数学公式
        当和一致，分为n段时，平均分则乘积最大
        现在问题转化为求分段的m值，直觉性的认为，m为n的平方根时面积最大
        首先定义一个由m求乘积的函数

        最小2段，最大n段，但n段没有意义
        对2段特殊处理
         */
        long maxArea = 0;
        long tempArea =0;
        if(n ==2){
            return 1;
        }
        for (int i = 2; i <n ; i++) {
            tempArea = mlu(n,i);
            if(tempArea >maxArea){
                maxArea = tempArea;
                System.out.println("!!!!!!!!!!!!"+i);
            }
        }
        System.out.println("----"+maxArea);
        return ((int)maxArea%((int)(Math.pow(10,9)+7)));
//        return maxArea;
//        return (int) (maxArea%(Math.pow(10,9)+7));
    }
    public static int cuttingRope1(int n) {
        long maxArea = 0;
        long tempArea =0;
        if(n ==2){
            return 1;
        }
        for (int i = 2; i <n ; i++) {
            tempArea = mlu1(n,i);
            if(tempArea >maxArea){
                maxArea = tempArea;
                System.out.println("!!!!!!!!!!!!"+i);
            }
        }
        System.out.println("----"+maxArea);
        return ((int)maxArea%((int)(Math.pow(10,9)+7)));
//        return maxArea;
//        return (int) (maxArea%(Math.pow(10,9)+7));
    }
    public static int cuttingRoped(int n) {
        double maxArea = 0;
        double tempArea =0;
        if(n ==2){
            return 1;
        }
        for (int i = 2; i <n ; i++) {
            tempArea = mlud(n,i);
            if(tempArea >maxArea){
                maxArea = tempArea;
                System.out.println("!!!!!!!!!!!!"+i);
            }
        }
        System.out.println("----"+maxArea);
//        return (maxArea%((Math.pow(10,9)+7)));
//        return maxArea;
        return (int) (maxArea%(Math.pow(10,9)+7));
    }
    public static long mlu(int n, int m){
        int[] len = new int[m];
        int temp =(int)(Math.pow(10,9)+7);
//        System.out.println(temp+"   temp");
        for (int i = 0; i < n; i++) {
            len[i%m]++;
        }
        long mlu = 1;
        for (int i = 0; i < m; i++) {
//            System.out.println(i+"  "+len[i]);
            mlu = mlu*(len[i]);
//            System.out.println(mlu+"----");
        }
        return mlu;
    }
    public static long mlu1(int n, int m){
        int[] len = new int[m];
        int temp =(int)(Math.pow(10,9)+7);
//        System.out.println(temp+"   temp");
        for (int i = 0; i < n; i++) {
            len[i%m]++;
        }
        long mlu = 1;
        for (int i = 0; i < m; i++) {
//            System.out.println(i+"  "+len[i]);
            mlu = (mlu%temp)*(len[i]%temp);
            mlu = mlu%temp;
//            System.out.println(mlu+"----");
        }
        return mlu;
    }
    public static double mlud(int n, int m){
        int[] len = new int[m];
        int temp =(int)(Math.pow(10,9)+7);
//        System.out.println(temp+"   temp");
        for (int i = 0; i < n; i++) {
            len[i%m]++;
        }
        double mlu = 1;
        for (int i = 0; i < m; i++) {
//            System.out.println(i+"  "+len[i]);
            mlu = mlu*(len[i]);
//            System.out.println(mlu+"----");
        }
        return mlu;
    }
}
