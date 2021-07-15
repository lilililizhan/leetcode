package niuke;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class StrSort {
    public static void main(String arge[]) {
        System.out.println("输入");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n);
        System.out.println(sc.nextLine());
        String[] str = sc.nextLine().split(" ");
        System.out.println(str.toString());
        int[] value = new int[n];
        HashMap<Integer, Integer> mmap = new HashMap();
        for (int i = 0; i < n; i++) {
            int r = 0;
            for (int j = 0; j < str[i].length(); j++) {
                r += str[i].charAt(j) - 'a';
            }
            value[i] = r;
            mmap.put(r, i);
        }
        Arrays.sort(value);
        for (int k = 0; k < n - 1; k++) {
            System.out.println(str[mmap.get(value[k])] + " ");
        }
        System.out.println(str[mmap.get(value[n - 1])]);
    }
}
