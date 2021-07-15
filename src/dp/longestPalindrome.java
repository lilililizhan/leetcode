package dp;

public class longestPalindrome {
    /*
    题号5，middle,应该是dp类的题吧，
    之前做过的题是求得最长的子序列回文长度，题号516，这两道题是不一样的，
    这道题不同的地方，使用临时变量来存储首尾索引号，并且在+2的时候需要考虑是否内部连续的,
    当两头不相同时，使用了-1来标志，并且会影响到之后的操作
    时间29%，空间5%

    官方还有一种思路是，随机找到中间两个i,i+1，然后依次向两端扩展，i的值是从0到len
     */
    public static void main(String[] args) {
//        String s = "babad";
//        String s = "cbbd";
        String[] slist = {"babad","cbbd","a","ac","aacabdkacaa"};
        for (int i = 0; i < slist.length; i++) {
            System.out.println(longestPalindrome2(slist[i]));
        }
//        String s = "aacabdkacaa";
//        System.out.println(longestPalindrome2(s));

    }

    public static String longestPalindrome2(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int maxlen =0;
        int start =-1;
        int end = -1;
        if(s.length()!=0)start=end=0;
        for (int i = s.length()-1; i >=0; i--) {
            dp[i][i] =1;
            for (int j = i+1; j < s.length(); j++) {//找最先出现的最大值
                if(s.charAt(i)==s.charAt(j)){
                    if(dp[i+1][j-1]!=-1)
                        dp[i][j] = dp[i+1][j-1]+2;
                    else dp[i][j] = -1;
                    if(dp[i][j] > maxlen){
                        maxlen = dp[i][j];
                        start  = i;
                        end = j;
                    }
                }
                else {
                    dp[i][j] = -1;
//                    break;
                }
            }

        }
//        System.out.println(dp[0][s.length()-1]);
        return start==-1 ? null : s.substring(start,end+1);
    }

    public static String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] =1;
        }
        int maxlen =0;
        int start =-1;
        int end = -1;
        if(s.length()!=0)start=end=0;
        for (int i = s.length()-1; i >=0; i--) {
            for (int j = i+1; j < s.length(); j++) {//找最先出现的最大值
                if(s.charAt(i)==s.charAt(j)){
//                    if(dp[i+1][j-1]!=0)
                    dp[i][j] = dp[i+1][j-1]+2;
                    if(dp[i][j] > maxlen){
                        maxlen = dp[i][j];
                        start  = i;
                        end = j;
                    }
                }
                else dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
            }

        }
//        System.out.println(dp[0][s.length()-1]);
        return start==-1 ? null : s.substring(start,end+1);
    }


}
