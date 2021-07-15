import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IsMagic {
    public static void main(String[] args) {
        int[] target = {2,4,3,1,5};
//        int[] target = {5,4,3,2,1};
//        int[] target = {2,4,3,1,5,6,7,8,9,10};
//        Arrays.sort(target);
//        System.out.println(target.toString());
        List<Integer> tlist = Arrays.stream(target).boxed().collect(Collectors.toList());
//        System.out.println(jiaohuan(tlist,2).toString());
        System.out.println(isMagic(target));

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
        for (int k = 1; k <= target2.length; k++) {
            r.clear();
            tlist = Arrays.stream(target2).boxed().collect(Collectors.toList());
            int index =0;
            boolean btemp = true;
            while(r.size()!=target2.length && btemp ==true){
                temp = jiaohuan(tlist,k);
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


            }
//            for (int i = 0; i < target.length; i++) {
//                if(target[i] != r.get(i)){
//                    break;
//                }
//                else if(i == target2.length-1){
//                b = true;
//                }
//            }
            if(btemp == true){
                b = true;
                break;
            }
        }
        return b;
    }
    public static List<Integer> jiaohuan(List<Integer> arr, int k){
//        System.out.println("--!!!!");
//        System.out.println("______"+arr.indexOf(1));
        ArrayList<Integer> arr2 = new ArrayList<>();
//        System.out.println(arr.toString());
        for (int i = 1; i < arr.size(); i+=2) {
//            System.out.println(i);
            arr2.add(arr.get(i));
//            System.out.println("----"+arr2.toString());
        }
//        System.out.println("______"+arr.indexOf(0));
        for (int i = 0; i < arr.size(); i+=2) {
//            System.out.println(i);
//            System.out.println("______"+arr.indexOf(i));
            arr2.add(arr.get(i));
//            System.out.println("----"+arr2.toString());
        }
//        System.out.println("arr2:  "+arr2.toString());
        return arr2;
//        if(arr2.size()<= k){
////            return arr2.toArray(new int[]);
//            return arr2;
//        }
//        return arr2.subList(k,arr2.size());
    }
}
