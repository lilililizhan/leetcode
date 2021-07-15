package test;

import java.util.*;
public class t0429count {
    public static void main(String[] args) {
        //第一题
//        Scanner sc = new Scanner(System.in);
//        String text = sc.nextLine();
//        while(sc.hasNextLine()){
//            String stemp = sc.nextLine();
//            if(stemp.length()==0)break;
//            text += " "+stemp;
//        }
//        Map<String,Integer> map = count(text);
//        for (String s:map.keySet()
//             ) {
//            System.out.println(s+": "+map.get(s));
//        }


        //第二题
//        int[] arr = {23,23,56,90,76,73,11,90};
//        int[] res = del2(arr);
//        System.out.println(Arrays.toString(res));

        //第四题
//         int[] arr = {0,1,2,3,4,5,6};
//         dis(arr);
//        System.out.println(Arrays.toString(arr));

        //第三题
        int[] arr = {3,5,7,1,4,8};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));


    }
    public static Map<String, Integer> count(String text){
        Map<String,Integer> map = new HashMap<>();
        String[] sarr = text.split(" ");
//        System.out.println(Arrays.toString(sarr));
        for (int i = 0; i < sarr.length; i++) {
            int temp = map.getOrDefault(sarr[i],0);
            map.put(sarr[i],temp+1);
        }
        return map;
    }

    public static int[] del(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (Integer i: set) {
            res[index] = i;
            index++;
        }
        return res;
    }

    public static int[] del2(int[] arr){
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int[] res = new int[set.size()];
        int index = 0;
        System.out.println(set.toString());
        System.out.println("----------");
//        for (int i = 0; i < set.size(); i++) {
//            System.out.println(set.toString());
//        }
        for (Integer i: set) {
            res[index] = i;
            index++;
        }
        return res;
    }

    public static void dis(int[] arr){
        int len = arr.length;
        int i =0;
        int j = len-1;
        int temp;
        if(len %2 ==1){
            temp = arr[(i+j)/2];
            arr[(i+j)/2] = arr[0];
            arr[0] = temp;
        }
        while(i<j){
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }
    }
//
//    public static void quickSort(int[] arr,int left,int rigjt){
//        int i = left;
//        int j = rigjt;
//        if(i==j)return;
//        int middle = (i+j)/2;
//        while (i<j){
//            while (i<middle){
//                if(arr[i]<arr[middle])i++;
//                else break;
//            }
//            while(j>middle){
//                if(arr[j]>arr[middle])j--;
//                else break;
//            }
//            if(i>=j)break;
//            int temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//        }
//        quickSort(arr,0,middle-1);
//        quickSort(arr,middle+1,arr.length-1);
//
//    }

    public static void quickSort(int[] arr,int left, int right) {
        if(left>=right)return;
        int l = left;
        int r = right;
        int middle = arr[(left + right) / 2];
        int temp;
        while( l < r) {
            while( arr[l] < middle) l++;
            while(arr[r] > middle) r--;
            if( l >= r) break;

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(arr[l] == middle) r--;
            if(arr[r] == middle) l++;
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        quickSort(arr, left, r);
        quickSort(arr, l, right);
    }
}
