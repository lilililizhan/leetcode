package backtrack;

public class exist {
    /*
    回溯，middle,题号79
    绝对做过，真的做过，在剑指offer里，
    这里需要对网格的状态进行标记，并更改
    有一个问题，可以从任何位置开始
    这道题又写了好久哦

    出现了栈溢出，因为我在判断初始位置时出错，因此使用for循环吧,时间35%，空间99%
    能用动态规划的思想做吗？估计不能，
    看了官方，想法是一样的，
     */
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
//        String word = "ABCCED";//true
//        String word = "SEE";//true
        String word = "ABCB";//false
        boolean r = exist(board,word);
        System.out.println(r);

    }
    public static boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        boolean boool =false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boool = exist2(board,word,0,visited,i,j);
                if(boool)return true;
            }
        }
        return false;
    }
    public static boolean exist2(char[][] board, String word, int index,int[][] visited,int row,int col) {
        if(index == word.length())return true;
        if(row<0 || row >= board.length || col <0||col >= board[0].length )return false;
        if (visited[row][col]  ==1)return false;
//        if(board[row][col] != word.charAt(index) && index==0) return exist2(board,word,index,visited,row+1,col) || exist2(board,word,index,visited,row-1,col)
//                || exist2(board,word,index,visited,row,col+1) || exist2(board,word,index,visited,row,col-1);
        if(board[row][col] == word.charAt(index)){
            visited[row][col] =1;
            boolean booltemp= exist2(board,word,index+1,visited,row+1,col) || exist2(board,word,index+1,visited,row-1,col)
               || exist2(board,word,index+1,visited,row,col+1) || exist2(board,word,index+1,visited,row,col-1);
            visited[row][col] =0;
            return booltemp;
        }
        return false;
    }
}
