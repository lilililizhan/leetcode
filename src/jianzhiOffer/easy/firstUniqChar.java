package jianzhiOffer.easy;


import java.util.LinkedHashMap;

public class firstUniqChar {
    /*
    剑指offer50,easy，
    在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    示例:
    s = "abaccdeff"
    返回 "b"
    s = ""
    返回 " "
    使用什么存储呢，要存储字符和字符个数，还有位置，
    遍历两遍吗，第一遍计数，第二遍看谁在前面，LInkedHashaMap吧，就可以吧

    时间7%，空间74%

    官方方法一：使用hashmap两次遍历，第二次遍历s,
    官方方法二：使用哈希表存储索引，将出现多次的改为-1，然后对hashmap进行遍历
    官方方法三：队列，使用队列存储char与索引，然后对队列进行遍历，一边遍历一边修改队列，我觉得更麻烦了
     */
    public static void main(String[] args) {
//        String s= "abaccdeff";//b
        String s= "";//b
        char c = firstUniqChar(s);
        System.out.println(c);

    }
    public static char firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            else {
                map.put(s.charAt(i),1);
            }
        }
        for (Character c:map.keySet()
             ) {
            if(map.get(c)==1)return c;
        }
        return ' ' ;
    }

}
