import java.util.Arrays;

public class FindContentChildren {
    public static void main(String[] args) {
//        int[] g = {1,2,3};
//        int [] s={1,1};
        int[] g = {1,2};
        int [] s={1,2,3};
        int r = findContentChildren(g,s);
        System.out.println(r);
    }
    public static int findContentChildren(int[] g, int[] s) {
        /*
        尽可能满足越多数量的孩子，从胃口最小的孩子开始满足，
        依次从两个数组中挑选最小值
        先对数组进行排序
         */
        Arrays.sort(g);
        Arrays.sort(s);
        int r =0;
        int indexg = 0;
        int indexs = 0;
        while (indexg <g.length && indexs < s.length){
            if(g[indexg] <= s[indexs]){
                r++;
                indexg ++;
                indexs ++;
            }
            else {
                indexs++;
            }
        }
        return r;
    }
}
