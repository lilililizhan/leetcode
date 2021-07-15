package jianzhiOffer.hard;

public class IsMatch {
    /*
    挑战一下hard，这道题归在了动态规划中，
    "abaacdf" "a.*f"这个竟然是true,
    "abaacdf" "a.f" false
"abaacfdf"  "a.*f"两个f,还是true
"abaacfdfd"  "a.*f" false
    首先，两个字符串的谁常谁短不确定，
    以s为基准，在p中寻找s，
    比较难搞的是中间出现 .* 的情况，
    s = "mississippi"
    p = "mis*is*p*."

    当出现*时就应该从后面开始匹配
    不会不会了

    官方解答使用的是动态规划
         */
    public static void main(String[] args) {

    }
    public static boolean isMatch(String s, String p) {
        int i =0,j=0;
        boolean b = false;
        while(i<s.length()-1 && j <s.length()-1){
            if((s.charAt(i)==p.charAt(j)) ){
                i++;
                j++;
            }
            else {//不相等的情况
                if(p.charAt(j)!='.' ){//当前位不是.
                    if(p.charAt(j+1)!='*')return false;//后一位是不是*
                    else {//后一位是*
                        if(s.charAt(i-1) ==s.charAt(i))i++;//s有连续位，s++;
                        else j=j+2;
                    }
                }
                else {//当前位是.
                    if(p.charAt(j+1)!='*'){//后一位不是*
                        i++;
                        j++;
                    }
                    else{//后一位是*
                    }

                }

            }
        }
        return b;
    }
}
