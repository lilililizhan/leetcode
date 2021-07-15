package jianzhiOffer.middle;

public class MovingCount {
    /*
    手感真的很重要，现在就感觉这都的啥啊，题都看不懂，也就两天没刷题
    这种方格类的题，还是不要用迭代了，直接标记，每一个方格是否能到达，能则标为1，不能-1，0表示未遍历到，
    如果是0的话需要再判断，-1的话就不用考虑了，是因为位数和不满足的原因，
    其实，不用判断上和左，因为（m,n)满足时，（m-1,n)和（m,n-1)也满足，(这个不一定）
        但是会不会存在没有遍历到的情况，不会存在，
        还是需要判读上和左，如 k=18,(34,39)不满足，但（34，40）满足，只有当十位相同的情况才不用判断
    本身不是一个规整的图形，

    有一个问题，是循环遍历的，所以会存在一种情况，这个不确定，
    这种情况，（m,n-2)不行，所以（m，n-1)没有遍历到，但后面发现（m,n)可以遍历，因此(m，n-1)也可以遍历到，
    这种情况不存在，因为只有39->40时才会有前面的不行，后面的行的情况，这样的话，一次向上就可以了
    终于运行了，坎坎坷坷的，时间34%，空间83%

    答案说只需要向下和向右就可以了，想一想确实是的，即便(99,99)不可以，(100,100)可以，但无法到达
    修改后47%，39%
 */
    public static void main(String[] args) {
//        int m=16,n=8, k=4;
//        int m=2,n=3, k=1;
//        int m=3,n=1, k=0;
//        int m=3,n=1, k=0;
        int r  = movingCount2(38,15,9);
        System.out.println(r);


    }
    public static int movingCount(int m, int n, int k) {
        int[][] digits = new int[m][n];
        int sumx,sumy;
        if(k >=0)digits[0][0] =1;
        for (int i = 0; i < m; i++) {
            sumx = sum(i);
            for (int j = 0; j < 3; j++) {
                if(digits[i][j] != 1){
                    System.out.println(i+" "+j +"!=1");
                    continue;
                }
                sumy = sum(j);
                if(i-1>=0 && digits[i-1][j] ==0){
                    digits[i-1][j] = sum(i-1)+sumy<= k ? 1:-1;
//                    System.out.println(sum(i-1)+" "+sumy+" "+i+" "+j+"--"+(i-1)+"  "+(j));
                }
                if(i+1<m && digits[i+1][j] ==0){
                    digits[i+1][j] = sum(i+1)+sumy<= k ? 1:-1;
//                    System.out.println(sum(i+1)+" "+sumy+" "+i+" "+j+"--"+(i+1)+"  "+(j));
                }
                if(j-1>=0 && digits[i][j-1] ==0){
                    digits[i][j-1] = sumx+sum(j-1)<= k ? 1:-1;
//                    System.out.println(sumx+" "+sum(j-1)+" "+i+" "+j+"--"+i+"  "+(j-1));
                }
                if(j+1<n && digits[i][j+1] ==0){
                    digits[i][j+1] = sumx+sum(j+1)<= k ? 1:-1;
//                    System.out.println(sumx+" "+sum(j+1)+" "+i+" "+j+"--"+i+"  "+(j-1));
                }
            }

        }
        System.out.println("--------------------");
        int s =0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(digits[i][j] ==1)s++;
//                System.out.println(i+"  "+j);
            }

        }
        return s;
    }
    public static int sum (int i){
        return i/100+i%100/10+i%10;
    }

    public static int movingCount2(int m, int n, int k) {
        int[][] digits = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(digits[i][j]+"  ");
            }
            System.out.println();

        }System.out.println("--------------------------------------");
        System.out.println();
        int sumx,sumy;
        if(k >=0)digits[0][0] =1;
        for (int i = 0; i < m; i++) {
            sumx = sum(i);
            for (int j = 0; j < n; j++) {
                if(digits[i][j] != 1){
                    System.out.println(i+" "+j +"!=1");
                    continue;
                }
                sumy = sum(j);
                if(i-1>=0 && digits[i-1][j] ==0){
                    if(sum(i-1)+sumy<= k){
                        digits[i-1][j] =1;
                        System.out.println(sum(i-1)+" "+sumy+"--"+" "+i+" "+j+"--"+(i-1)+"  "+(j));
                    }
                    else digits[i-1][j] =-1;
                }
                if(i+1<m && digits[i+1][j] ==0){
                    if(sum(i+1)+sumy<= k){
                        digits[i+1][j] =1;
                        System.out.println(sum(i+1)+" "+sumy+"--"+" "+i+" "+j+"--"+(i+1)+"  "+(j));
                    }
                    else digits[i+1][j] =-1;
                }
                if(j-1>=0 && digits[i][j-1] ==0){
                    if(sumx+sum(j-1)<= k){
                        digits[i][j-1] =1;
                        System.out.println(sumx+" "+sum(j-1)+"--"+" "+i+" "+j+"--"+(i)+"  "+(j-1));
                    }
                    else digits[i][j-1] =-1;
                }
                if(j+1<n && digits[i][j+1] ==0){
                    if(sumx+sum(j+1)<= k){
                        digits[i][j+1] =1;
                        System.out.println(sumx+" "+sum(j+1)+"--"+" "+i+" "+j+"--"+(i)+"  "+(j+1));
                    }
                    else digits[i][j+1] =-1;
                }
            }

        }
        System.out.println("--------------------");
        int s =0;
        for (int i = 0; i < m; i++) {
            System.out.print(i+"** ");
            for (int j = 0; j < n; j++) {
                if(digits[i][j] ==1)s++;
                System.out.print(digits[i][j]+"  ");
            }
            System.out.println();
        }
        return s;
    }
}
