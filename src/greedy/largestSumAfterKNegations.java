package greedy;

import java.util.Arrays;

public class largestSumAfterKNegations {
    /*
    1005,easy,给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引并将 A[i] 替换为 -A[i]，
    然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
    以这种方式修改数组后，返回数组可能的最大和。

    输入：A = [2,-3,-1,5,-4], K = 2
    输出：13
    解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。

    排序，有负数，先对负数进行替换，当负数替换完后，看剩下的次数的奇偶数，
    思路简单，代码好繁琐啊，
    能不能一边加，一边计算

    时间88%，空间22%，
    官方解答没细看，大体思路一致
     */
    public static void main(String[] args) {
        int[] A ={4,2,3};
        int K =1;//5

//        int[] A ={3,-1,0,2};
//        int K =3;//6

//        int[] A ={2,-3,-1,5,-4};
//        int K =2;//13

//        int[] A = {-8,3,-5,-3,-5,-2};
//        int K =6;//22
        int r = largestSumAfterKNegations2(A,K);
        System.out.println(r);
    }
    public static int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int n = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i]<0){
                if(n<K){
                    A[i] = -A[i];
                    n++;
                }
                else break;
            }
            else {
                if((K-n)%2==0)break;
                else {
                    if(i==0){
                        A[i] = -A[i];
                    }
                    else {
                        if(Math.abs(A[i-1])<Math.abs(A[i]))  A[i-1] = -A[i-1];
                        else A[i] = A[i];
                    }
                    break;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }

    public static int largestSumAfterKNegations2(int[] A, int K){
        Arrays.sort(A);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if(K==0)sum += A[i];
            else {
                if(A[i] <0){
                    sum +=  -A[i];
                    K--;
                }
                else {
                    if(K%2==0) sum += A[i];
                    else {
                        if (i == 0) sum += -A[i];
                        else sum += Math.abs(A[i-1])<Math.abs(A[i]) ? (A[i-1]*2)+A[i]:-A[i];//易错的地方
                    }
                    K=0;
                }
            }
        }
        return sum;
    }
}
