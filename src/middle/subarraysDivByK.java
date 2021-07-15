package middle;

import java.util.HashMap;
import java.util.Map;

public class subarraysDivByK {
    /*
   974,middle,给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
   输入：A = [4,5,0,-2,-3,1], K = 5
    输出：7
    解释：
    有 7 个子数组满足其元素之和可被 K = 5 整除：
    [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

    初始想法：dp二维数组，不用数组，一个变量就可以了
    dp二维数组时，完成38/73，改为临时变量后68、73

     */

    public static void main(String[] args) {
        int[] A= {4,5,0,-2,-3,1};
        int K =5;
        int res = subarraysDivByK2(A,K);
        System.out.println(res);


    }

    public static int subarraysDivByK(int[] A, int K) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            sum = A[i];
            if(sum%K==0){
                count++;
            }
            for (int j = i+1; j < A.length; j++) {
                sum += A[j];
                if(sum%K==0){
                    count++;
                }
            }
        }
        return count;
    }
    public static int subarraysDivByK2(int[] A, int K){
        Map<Integer,Integer> record = new HashMap<>();
        record.put(0,1);
        int sum = 0;
        int count = 0;
        for (int ele:A
             ) {
            sum += ele;
            int modules = (sum % K  + K)%K;
            int same = record.getOrDefault(modules,0);
            count += same;
            record.put(modules,same+1);
        }
        return count;
    }
}
