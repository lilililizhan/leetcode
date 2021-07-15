package former;

public class ValidMountainArray {
    public static void main(String[] args) {
        int[] arr= new int[]{0,2,3,3,5,2,1,0};
//        int[] arr= new int[]{3,5,5};
//        int[] arr= new int[]{0,3,2,1};
//        int[] arr= new int[]{2,1};
//        int[] arr= new int[]{};
//        int[] arr= new int[]{1,3,2};
//        int[] arr= new int[]{9,8,7,6,5,4,3,2,1,0};
        boolean r = validMountainArray(arr);
        System.out.println(r);

//        validMountainArray(arr);
//        System.out.println(validMountainArray(arr));

    }
    public static boolean validMountainArray(int[] A){
        if (A.length <3){
            return false;
        }
        else {
            int i = 0;
            while(i < A.length-1 && A[i]<= A[i+1]){
                i++;
            }
            if (i >0){
                if (i <= A.length - 2) {
                    while(i <=A.length-2 && A[i] > A[i+1]){
                        i++;
                    }
//                i值是峰谷，
                    if (i == A.length-1) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            else {
                return false;
            }
//            返回的i值是最大的峰值

        }
    }

//    public static boolean validMountainArray(int[] A){
//        if (A.length <3){
//            return false;
//        }
//        else {
//            int i = 0;
//            do {
//                //            System.out.println(A[i]);
//                i++;
//            } while (A[i - 1] <= A[i] && i < A.length - 1);
////i-1是峰值
//            if (i <= A.length - 1) {
//                do {
//                    //                System.out.println(A[i]);
//                    i++;
//                } while (A[i - 2] >= A[i-1] && i < A.length);
////                i-1值是峰值，
//                if (i == A.length-1) {
//                    return true;
//                } else {
//                    return false;
//                }
//            } else {
//                return false;
//            }
//        }
//    }
}
