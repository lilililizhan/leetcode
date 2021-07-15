package lianbiao;

import java.util.*;

public class get {
    public static void main(String[] args) {
        String[][] accountsArr = {
                {"John", "johnsmith@mail.com", "john00@mail.com"},
                {"John", "johnnybravo@mail.com"},
                {"John", "johnsmith@mail.com", "john_newyork@mail.com"},
                {"Mary", "mary@mail.com"}};
        List<List<String>> accounts = new ArrayList<>();
        List<String[]> ls = Arrays.asList(accountsArr);
        for (String[] arr:ls
             ) {
            accounts.add(Arrays.asList(arr));
        }
        List<List<String>> res = mergeAccount(accounts);

        Collections.sort(res, new Comparator<List<String>>() {

            @Override
            public int compare(List<String> o1, List<String> o2) {
                String aName1 = String.join(",", o1);
                String aName2 = String.join(",", o2);
                return aName1.compareTo(aName2);
            }

        });

        for (int res_i = 0; res_i < res.size(); res_i++) {
            List<String> resItem = res.get(res_i);
            System.out.println(String.join(",", resItem));
        }


    }
    public static ListNode get(ListNode headA, ListNode headB){
        Set<ListNode> hashset = new HashSet<>();
        ListNode curNode = headA;
        while(curNode != null){
            hashset.add(curNode);
            curNode = curNode.next;
        }
        curNode = headB;
        while(curNode != null){
            if(hashset.contains(curNode)){
                return curNode;
            }
            curNode = curNode.next;
        }
        return null;
    }

    static List<List<String>> mergeAccount(List<List<String>> accounts) {
        // 在此处编写实现代码逻辑
        Map<String,String> mapMailToname = new HashMap<String,String>();
        Map<String,ArrayList<String>> mailGraph = new HashMap<>();
        for (List<String> account:accounts
             ) {
            String name = account.get(0);
            String mail = account.get(1);
            for (int i = 0; i < account.size(); i++) {
                mailGraph.computeIfAbsent(account.get(i),x->new ArrayList<String>()).add(mail);
                mailGraph.computeIfAbsent(mail,x->new ArrayList<String>()).add(account.get(i));
                mapMailToname.put(account.get(i),name);
            }
        }
        Set<String> mailset = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        for (String email:mailGraph.keySet()
             ) {
            if(! mailset.contains(email)){
                mailset.add(email);
                Stack<String > sk = new Stack<>();
                List<String> emailList = new ArrayList<>();
                sk.push(email);
                while(!sk.isEmpty()){
                    String emailpop = sk.pop();
                    emailList.add(emailpop);
                    for (String key:mailGraph.get(emailpop)
                         ) {
                        if(!mailset.contains(key)){
                            sk.push(key);
                            mailset.add(key);
                        }
                    }
                }
                Collections.sort(emailList);
//                emailList.add(0,mapMailToname.get(email));
                result.add(emailList);
            }
        }
        return result;

    }

}
