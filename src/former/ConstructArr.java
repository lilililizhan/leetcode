import java.util.ArrayList;

public class ConstructArr {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] r = constructArr2(a);
        for (int i:r
             ) {
            System.out.println(i);
        }

    }
    public static int[] constructArr(int[] a) {
        /*
        不能使用除法
        本来想使用分数，但分数本质上是除法吗
        如果直接硬性计算，怕是不行吧，先试一试暴力法吧
        试了一下暴力法，果然不行
        别的思路：把数组分为两份，就减小了很多工作量，但太细分就变成了一个数一份，
         */
        int[]  b= new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] =1;
            for (int j = 0; j < a.length; j++) {
                if(j!=i){
                    b[i] = b[i]*a[j];
                }
            }

        }
        return  b;
    }

    public static int[] constructArr2(int[] a) {
        /*
        考虑到上面的矛盾，设分为k段，每段m个，复杂度为[m+(k-1)]*n,m*k=n,即[n/k+(k-1)]*n,对k求导，k=sqrt(n)时最小
        */
        int k =(int)Math.sqrt(a.length);
        System.out.println(k);
        ArrayList<Integer> mul = new ArrayList<>();
        int i =0;
        int j =0;
        while ((i+k)<a.length){
            mul.add(construct(a, i, i + k));
//            mul.set(j, construct(a, i, i + k));
            j++;
            i = i+k;
        }
        if(i != a.length){
            mul.add(construct(a,i,a.length));
//            mul.set(j,);
        }

        int[]  b= new int[a.length];
        int temp;
        for (int l = 0; l < a.length; l++) {
            temp =1;
            for (int m = 0; m < mul.size(); m++) {
                if((l<m*k) ||(l>=m*k+k)){
                    temp = temp*mul.get(m);
                }
                else {
                    int temp2 = m*k;
                    while (temp2<m*k+k && temp2<a.length){
                        if(temp2 != l){
                            temp = temp*a[temp2];
                        }
                        temp2++;
                    }
                }
            }
            b[l] =temp;

    }
        return  b;
}
    public static Integer construct(int[] a,int start, int end) {
        int r =1;
        for (int ii = start; ii < end; ii++) {
            r = r*a[ii];
        }
        return r;
    }
}
