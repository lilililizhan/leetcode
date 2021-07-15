package test;

/*
不能定义新的类
这是一个构建树并打印的过程，
 */


import java.util.*;
public class t0428 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int N = sc.nextInt();
        String[][] str = new String[N][2];
        for (int i = 0; i < N; i++) {
            str[i][0] = sc.next();
            str[i][1] = sc.next();
        }
        Character[][] list = new Character[N][2];
        for (int i = 0; i < N; i++) {
            list[i][0] = str[i][0].charAt(3);
            list[i][1] = str[i][1].charAt(3);
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(list[i]));
//        }
//        Character[][] liststring = {{'a','b'},
//                {'c','b'},
//                {'b','f'},
//                {'e','f'},
//                {'d','e'}};
        create(list,num);
//        for (Node n:rootlist
//             ) {
//            n.strings();
//        }
//        System.out.println("-----------");
//        for (Node n:childlist
//        ) {
//            n.strings();
//        }
//        System.out.println("----------");
        List<Character> res = print2(rootlist);
        System.out.println("false");
        for (int i = 0; i < res.size()-1; i++) {
            System.out.print("lib"+res.get(i)+".dll ");
        }
        System.out.print("lib"+res.get(res.size()-1)+".dll");

    }
    static Set<Node> rootlist = new HashSet<>();
    static Set<Node> childlist = new HashSet<>();
    static Set<Node> nodedel = new HashSet<>();
    public static void create(Character[][] liststring,int num){

        Node[] nodearr = new Node[num];
        for (int i = 0; i < liststring.length; i++) {
            char t1 = liststring[i][0];
            char t2 = liststring[i][1];
            int index1 = t1-'a';
            int index2 = t2-'a';
            Node temp1;
            Node temp2;
            if(nodearr[index1] == null) {
                temp1 = new Node(t1);
                nodearr[index1] = temp1;
            }
            else temp1 = nodearr[index1];
            childlist.add(temp1);
            if(rootlist.contains(temp1)){
                rootlist.remove(temp1);
                childlist.add(temp1);
            }

            if(nodearr[index2] == null) {
                temp2 = new Node(t2);
                nodearr[index2] = temp2;
            }
            else temp2 = nodearr[index2];
            if(childlist.contains(temp2)){
                if(rootlist.contains(temp2))rootlist.remove(temp2);
            }
            else rootlist.add(temp2);

            if(temp2.next1 == null)temp2.next1 =temp1;
            else temp2.next2 = temp1;
//            else {
//                nodedel.add(temp2);
//                nodedel.add(temp1);
//            }
        }
    }

    static class Node{
        char val;
        Node next1;
        Node next2;
        Node(char c){
           this.val =c;
        }
        void strings(){
            System.out.print(val+"--");
        }
    }

    public static List<Character> print2(Set<Node> rootlist){
        LinkedList<Node> stack = new LinkedList<>();
        List<Character> res = new ArrayList<>();
        List<Character> temp = new ArrayList<>();
        List<Node> nodetemp = new ArrayList<>();
        for (Node n:rootlist
             ) {
            nodetemp.add(n);
            stack.addLast(n);
        }

        Character[] t1 = new Character[nodetemp.size()];
        for (int i = 0; i < t1.length; i++) {
            t1[i] = nodetemp.get(i).val;
        }
        Arrays.sort(t1);
//        for (int i = 0; i < t1.length; i++) {
//            res.add(t1[i]);
//        }

        while( !stack.isEmpty()){
            temp = new ArrayList<>();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                Node pop = stack.pop();
                if( nodedel.contains(pop))continue;
                temp.add(pop.val);
                if(pop.next1 != null)stack.addLast(pop.next1);
                if(pop.next2 != null)stack.addLast(pop.next2);
            }
            Character[] t = temp.toArray(new Character[0]);
            Arrays.sort(t);
            for (int i = 0; i < t.length; i++) {
                res.add(t[i]);
            }
        }
        return res;
    }
}

