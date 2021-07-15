package test.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class t3 {
    /*
    对字符串进行操作
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            if ("0".equals(line)) {
                break;
            }
            String[] split = line.split(" ");
            System.out.println(getSum(split));
        }
        bufferedReader.close();


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s;
//        while((s = br.readLine()) != null) {
//            //String s = br
//            String []arr = s.split(" ");
//            int sum = 0;
//            if(Integer.parseInt(arr[0]) == 0) {
//                break;
//            }
//            for(int i=1; i<=Integer.parseInt(arr[0]); i++) {
//                sum += Integer.parseInt(arr[i]);
//            }
//            System.out.println(sum);
    }

    private static int getSum(String[] split) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.asList(split).stream().forEach(item ->{
            list.add(Integer.valueOf(item));
        });

        Integer size = list.get(0);

        List<Integer> integers = list.subList(1, size+1);

        return integers.stream().mapToInt(Integer::intValue).sum();
    }
//    public static void main(String[] args) {
//        Scanner sc =new Scanner(System.in);
//        while(sc.hasNext()){
//            int num = sc.nextInt();
//            int sum = 0;
//            for (int i = 0; i < num; i++) {
//                sum += sc.nextInt();
//            }
//            System.out.println(sum);
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            if(a ==0 && b ==0)break;
//            System.out.println(a+b);
//        }
//    }

    public static void t5() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        int l = 0;
        while((line = bf.readLine()) != null){
            if(l==0){
                l=1;continue;
            }
            String[] num = line.split(" ");
            int sum = 0;
            for (int i = 0; i < num.length; i++) {
                sum += Integer.parseInt(num[i]);
            }
            System.out.println(sum);
        }
        bf.close();
    }



}
