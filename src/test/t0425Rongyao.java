package test;

import java.util.*;

public class t0425Rongyao {
    /*
    先统计大于3万的个数及天数，并统计大于1万的天数，大于5000小于1万，和小于5000的天数，
    问题在于输入输出的排序，使用什么来存结果呢，每个类型一个二维数组，并组内排序
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> arr= new ArrayList<>();
        ArrayList<String > name = new ArrayList<>();
        String s;
        while((s = sc.nextLine()).length()!=0){
//            s = sc.nextLine();
            System.out.println(s);
            String[] temp = s.split(":");
            if(temp.length==0)break;
//            System.out.println(Arrays.toString(temp));
            name.add(temp[0]);
            String[] temp2 = temp[1].split(" ");
            int[] arrtemp = new int[temp2.length];
            for (int i = 0; i < temp2.length; i++) {
                arrtemp[i] = Integer.parseInt(temp2[i]);
            }
            arr.add(arrtemp);
            System.out.println(Arrays.toString(arrtemp));
        }
        String[] namearr = name.toArray(new String[0]);
//        System.out.println(Arrays.toString(namearr));

//        int[][] arr = {{35000,0,0,0,0,36000,0,0,0,0,0,40000,0,0,0,0,32000},
//                {12000,12000,12000,12000,12000,12000,12000,0,12000,12000,12000,12000,0,12000,12000,12000,12000,12000,12000},
//                {2000},
//                {6000,6000,6000,6000,0,6000,6000,6000,0,0,6000,6000,6000,6000,6000,6000,6000,6000,6000,6000,6000,6000,6000},
//                {3000}};
//        String[] name = {"Gsy","wj","Jww","Zzc","Dbw"};
        int[] res =new int[2];
        ArrayList<int[]> excell1 = new ArrayList<>();
        ArrayList<int[]> excell2 = new ArrayList<>();
        ArrayList<int[]> good = new ArrayList<>();
        ArrayList<int[]> bad = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            res = eval(arr.get(i));
            if(res[0]==1)excell1.add(new int[]{i,res[1]});
            else if(res[0]==2)excell2.add(new int[]{i,res[1]});
            else if(res[0]==3)good.add(new int[]{i,res[1]});
            else bad.add(new int[]{i,res[1]});
        }
        if(excell1.size()+excell2.size()==0) System.out.println("excellent is null");
        else {
            if(excell1.size() !=0)print(namearr,1,excell1);
            if(excell2.size() !=0) print(namearr,2,excell2);
        }
        if(good.size()==0)System.out.println("good is null");
        else print(namearr,3,good);
        if(bad.size()==0) System.out.println("bad is null");
        else print(namearr,4,bad);

    }
    public static int[] eval(int[] num){
        int sum = 0;
        int num3 = 0;
        ArrayList<Integer> days = new ArrayList<>();
        int num1 = 0;
        int num051  =0;
        int num05 = 0;
        for (int i = 0; i < num.length; i++) {
            if(num[i] > 30000 ){
                num3 ++;
                num1++;
                days.add(i);
            }
            else if(num[i]>10000)num1++;
            else if(num[i]>5000 )num051++;
            else num05++;
            sum += num[i];
        }
        if(num3>=4){
            int i= 0;
            int dayindex = -5;
            boolean flag = true;
            while(i<days.size()-1){
                if(days.get(i+1)-days.get(i)>4)i++;
                else {
                    flag =false;
                    break;
                }
            }
            if(flag)return new int[]{1,sum};

        }
        else if(num1>15)return new int[]{2,sum};
        else if(num051>18)return new int[]{3,sum};
        else return new int[]{4,sum};
        return null;
    }

    public static int[][] sort(ArrayList<int[]> temp){
        int[][] res = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        return res;
    }
    public static void print(String[] name,int dengji, ArrayList<int[]> temp){
        int[][] res = sort(temp);
        String s;
        if(dengji ==1 || dengji ==2)s = ":excelllent ";
        else if(dengji ==3)s = ":good ";
        else s = ":bad ";
        for (int i = 0; i < res.length; i++) {
            System.out.println(name[res[i][0]]+s+res[i][1]);
        }
    }


    public static int score(String st1,String st2){
        String[] s1 = st1.split(" ");
        String[] s2 = st2.split(" ");
        int i = 0;
        int j = 0;
        int sco = s1.length;
        while(i< s1.length-1 && j< s1.length-1){
            if(s1[i]==s2[i]){
                i++;
                j++;
            }
            else if(s1[i]==s2[j+1]){//新增
                sco -= 2;
                i++;
                j+=2;
            }
            else if(s1[i+1]==s2[j]) {//删除
                sco -=1;
                i+=2;
                j++;
            }
            else {//判断是否替换
                if(tihuan(s1[i],s2[j])) sco -=1;
                else sco -= 3;
                i++;
                j++;
            }
        }
        if(i== s1.length-2){

        }
        else{

        }
        return sco;
    }
    public static boolean tihuan(String s1,String s2){
        Map<Character,Integer> map = new HashMap<>();
        char temp;
        int num;
        int comnum=0;
        for (int i = 0; i < s1.length(); i++) {
            temp = s1.charAt(i);
            num = map.getOrDefault(temp,0);
            map.put(temp,num+1);
        }
        for (int i = 0; i < s2.length(); i++) {
            temp = s2.charAt(i);
            num = map.getOrDefault(temp,0);
            if(num>1){
                comnum++;
                map.put(temp,num-1);
            }
        }
        return comnum >= s1.length() ? true :false;
    }

}
