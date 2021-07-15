package jianzhiOffer.middle;

public class Exist {
    /*
    题目出现在深度优先遍历的列表中，
    有点像迷宫问题，
    递归，路程有向上向上向左向右，结果取决于下一步是否成功
    路径不能重复，故需要矩阵标记是否走过

    写代码的过程中的问题是，走过的点标记的问题
    时间7%，空间76%

    看了官方的答案，思路是一致的，但写法简单了很多
    同时，判断是否越界放在调用递归后，而不是先判断，再调用递归
    并且没有是否遍历的二维数组，
    遍历过后，修改board的值，太机智了吧
    先改为\0,四个方向遍历后再改为原来的值，不太懂!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!这一步很重要

    这道题花了太长的时间了
     */
    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
//        String word = "ABCCED";
//        String word = "ABCB";

//        char[][] board = {{'A','B'}, {'C','D'}};
//        String word = "ABCD";
//        char[][] board = {{'a'}};
//        String word = "a";

//        char[][] board = {{'C','A','A'}, {'A','A','A'}, {'B','C','D'}};
//        String word = "AAB";

//        char[][] board= {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
//        String word =  "ABCEFSADEESE";
        char[][] board = {{'a','a'}};
        String word = "aaa";
        boolean r = exist0(board,word);
        System.out.println(r);

    }

    public static boolean exist0(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==word.charAt(0)){
                    if(exist3(board,word,i,j,0)){
                        return true;
                    }
                }
            }

        }
        return false;
//        return true;
    }
    public static boolean exist(char[][] board, String word) {
        int[][] bool = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==word.charAt(0)){
                    bool = new int[board.length][board[0].length];
                    bool[i][j]=1;
                    if(exist2(board,word,bool,i,j,1)){
                        return true;
                    }
                }
            }

        }
        return false;
//        return true;
    }
    public static boolean exist2(char[][] board, String word,int[][]bool,int i,int j,int n) {
//        bool[i][j]=1;
        if(n==word.length())return true;
        if(j+1<board[0].length && bool[i][j+1]==0 && board[i][j+1]==word.charAt(n)){
            bool[i][j+1]=1;
            if(n==word.length()-1)return true;
            else if(exist2(board,word,bool,i,j+1,n+1)){
                return true;
            }
            else bool[i][j+1]=0;

        }
        if(i+1<board.length && bool[i+1][j]==0 && board[i+1][j]==word.charAt(n)){
            bool[i+1][j]=1;
            if(n==word.length()-1)return true;
            else if(exist2(board,word,bool,i+1,j,n+1)){
                return true;
            }
            else bool[i+1][j]=0;
        }
        if(j-1>=0 && bool[i][j-1]==0 && board[i][j-1]==word.charAt(n)){
            bool[i][j-1]=1;
            if(n==word.length()-1)return true;
            else if(exist2(board,word,bool,i,j-1,n+1)){
                return true;
            }
            else bool[i][j-1]=0;
        }
        if(i-1>=0 && bool[i-1][j]==0 && board[i-1][j]==word.charAt(n)){
            bool[i-1][j]=1;
            if(n==word.length()-1)return true;
            else if(exist2(board,word,bool,i-1,j,n+1)){
                return true;
            }
            else bool[i-1][j]=0;
        }
        return false;
    }

    public static boolean exist3(char[][] board, String word,int i,int j,int n) {
//        bool[i][j]=1;
        if(n==word.length())return true;
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(n)) return false;
        board[i][j]='\0';//这一步很重要
        boolean b = exist3(board,word,i+1,j,n+1) || exist3(board,word,i-1,j,n+1)
                ||exist3(board,word,i,j+1,n+1)||exist3(board,word,i,j-1,n+1);
        board[i][j]=word.charAt(n);
        return b;
    }
}
