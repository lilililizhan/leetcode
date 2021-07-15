import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IsMagic2 {
    public static void main(String[] args) {
        int[] target = {2,4,3,1,5};
        int[] target2 = {2,4,3,6,5,1};
        int[] target3 = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,35,41,33,39,37,47,43,45};
        int[] target4 = {5,4,3,2,1};

//        int[] target = {5,4,3,2,1};
//        int[] target = {2,4,3,1,5,6,7,8,9,10};
//        Arrays.sort(target);
//        System.out.println(target.toString());
        List<Integer> tlist = Arrays.stream(target).boxed().collect(Collectors.toList());
//        System.out.println(xiangtong(tlist,target2,3,1));
//        System.out.println(xiangtongk(tlist,target2));
//        System.out.println(jiaohuan(tlist,2).toString());
        System.out.println(isMagic(target4));

    }
    public static boolean isMagic(int[] target) {
        /*
        目前没有别的思路，那么就定义以k为参数的函数，然后依次循环
        算法的重点是将偶数位置的排放在奇数位置后
        使用Arraylist
         */
        int[] target2 = new int[target.length];
        for (int i = 0; i < target.length; i++) {
            target2[i] = target[i];
        }
        Arrays.sort(target2);
        boolean b =false;
        List<Integer> tlist;
        ArrayList<Integer> r = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        tlist = Arrays.stream(target2).boxed().collect(Collectors.toList());
        temp = jiaohuan(tlist);
        int k = xiangtongk(temp,target);
        if(k ==0){
            return false;
        }
        int index =0;
        boolean btemp = true;
        tlist = Arrays.stream(target2).boxed().collect(Collectors.toList());
        while(r.size()!=target2.length && btemp ==true){
            temp = jiaohuan(tlist);
            if(temp.size() <=k){
                r.addAll(temp);
                for (int i = index; i < target2.length; i++) {
                    if(target[i] != r.get(i)){
                        btemp =false;
                        break;
                    }
                }
                break;
            }
            r.addAll(temp.subList(0,k));
            for (int i = index; i < index+k; i++) {
                if(target[i] != r.get(i)){
                    btemp =false;
                    break;
                }
            }
            tlist = temp.subList(k,temp.size());
            index =index +k;
            if(btemp ==false){
                return false;
            }

        }
        if(btemp ==false){
            return false;
        }
        return true;
//        for (int k = 1; k <= target2.length; k++) {
//            r.clear();
//            tlist = Arrays.stream(target2).boxed().collect(Collectors.toList());
//            int index =0;
//            boolean btemp = true;
//            while(r.size()!=target2.length && btemp ==true){
//                temp = jiaohuan(tlist);
//                if(temp.size() <=k){
//                    r.addAll(temp);
//                    for (int i = index; i < target2.length; i++) {
//                        if(target[i] != r.get(i)){
//                            btemp =false;
//                            break;
//                        }
//                    }
//                    break;
//                }
//                r.addAll(temp.subList(0,k));
//                for (int i = index; i < index+k; i++) {
//                    if(target[i] != r.get(i)){
//                        btemp =false;
//                        break;
//                    }
//                }
//                tlist = temp.subList(k,temp.size());
//                index =index +k;
//                if(btemp ==false){
//                    break;
//                }
//
//            }
////            for (int i = 0; i < target.length; i++) {
////                if(target[i] != r.get(i)){
////                    break;
////                }
////                else if(i == target2.length-1){
////                b = true;
////                }
////            }
//            if(btemp == true){
//                b = true;
//                break;
//            }
//        }
//        return b;
    }
    public static List<Integer> jiaohuan(List<Integer> arr){
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i = 1; i < arr.size(); i+=2) {
            arr2.add(arr.get(i));
        }
        for (int i = 0; i < arr.size(); i+=2) {
            arr2.add(arr.get(i));
        }
        return arr2;
    }
    public static boolean xiangtong(List<Integer>  temp, int[] traget2, int k,int index){
        for (int i = index; i < index+k; i++) {
            if(temp.get(i) !=  traget2[i]){
                return false;
            }
        }
        return true;
    }
    public static int xiangtongk(List<Integer>  temp, int[] traget2){
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i) !=  traget2[i]){
                return i;
            }
        }
        return temp.size();
    }
}
