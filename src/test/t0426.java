package test;

/*
阿里
动态规划，但是可以从四个方向走，回溯吗
 */
public class t0426 {

    public static void main(String[] args) {

        int[][] difit = {{4,4,3},{3,5,4},{6,5,6},{7,4,10},{8,9,9}};
        int startx = 1;
        int starty = 1;
        int endx = 5;
        int endy = 3;
        int[] res = new int[]{Integer.MAX_VALUE};
        int[][] visit = new int[difit.length][difit[0].length];
        mindfs(visit,difit,startx-1,starty-1,endx-1,endy-1,res,0);
        int r = res[0] == Integer.MAX_VALUE ? -1:res[0];
        System.out.println(r);
    }
    public static void mindfs(int[][] visit,int[][] difit, int startx,int starty,int endx,int endy,int[] res,int restemp){
        int n= difit.length;
        int m = difit[0].length;
        if(endx ==startx  && endy ==starty){
            res[0] = Math.min(res[0],restemp);
            return;
        }
        else {
            if(startx+1 < n && difit[startx+1][starty] >= difit[startx][starty] && visit[startx+1][starty]==0){
                visit[startx+1][starty]=1;
                mindfs(visit,difit,startx+1,starty,endx,endy,res,restemp+1);
                visit[startx+1][starty]=0;
            }
            if(startx-1>=0 && difit[startx-1][starty] >= difit[startx][starty] && visit[startx-1][starty]==0){
                visit[startx-1][starty]=1;
                mindfs(visit,difit,startx-1,starty,endx,endy,res,restemp+1);
                visit[startx-1][starty]=0;
            }
            if(starty+1<m && difit[startx][starty+1] >= difit[startx][starty] && visit[startx][starty+1]==0){
                visit[startx][starty+1]=1;
                mindfs(visit,difit,startx,starty+1,endx,endy,res,restemp+1);
                visit[startx][starty+1]=0;
            }
            if(starty-1>=0 && difit[startx][starty-1] >= difit[startx][starty] && visit[startx][starty-1]==0){
                visit[startx][starty-1]=1;
                mindfs(visit,difit,startx,starty-1,endx,endy,res,restemp+1);
                visit[startx][starty-1]=0;
            }
        }
    }
}
