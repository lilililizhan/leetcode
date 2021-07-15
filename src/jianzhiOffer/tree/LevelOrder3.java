package jianzhiOffer.tree;

import java.util.*;

public class LevelOrder3 {
    /*
    广度优先，使用一个队列维护当前节点，
    问题是需要对节点按层输出，另外使用一个queue来保存层数
    其实最好的是每一层定义一个Queue


    使用了很多的list来存储不同的变量，时间26%，空间5%
    天呐看我之前的回答，都不敢相信是我自己做的，太厉害了

    看了官方的回答，queue在跳出循环前是不变的，不太懂，
    另外需要注意的点是，在头添加和在尾添加，需要一致
    */
    public static void main(String[] args) {
//        int[] num = {3,9,20,0,0,15,7};
//        int[] num = {1,2,3,4,5};
        int[] num = {1,2,3,4,0,0,5};
        TreeNode root = TreeNode.create(num);
//        levelOrder(root);
        List<List<Integer>> rlist= levelOrder(root);
        System.out.println(rlist);

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root ==null)return new ArrayList<>();
        LinkedList<TreeNode> nodelist  = new LinkedList();
        nodelist.push(root);
        ArrayList<Integer> value  = new ArrayList<>();
//        value.add(0);
        LinkedList<Integer> index  = new LinkedList();
        LinkedList<Integer> indexr  = new LinkedList();
        index.add(0);
        indexr.add(0);
        level2(nodelist,value,index,indexr);
        List<List<Integer>> rlist= new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int t = -1;
        for (int i = 0; i <indexr.size(); i++) {
            if(indexr.get(i) != t){
                t = indexr.get(i);
                if(i != 0)rlist.add(temp);
                temp = new ArrayList<>();
            }
            temp.add(value.get(i));
        }
        rlist.add(temp);
        for (int i = 0; i < rlist.size(); i++) {
            if(i%2 !=0){
//                System.out.println(rlist.get(i));
                Collections.reverse(rlist.get(i));
            }
        }
//        System.out.println(rlist);
        System.out.println(value);
        System.out.println(index);
        return rlist;

    }
    public static void level(LinkedList<TreeNode> nodelist, ArrayList<Integer> value,LinkedList<Integer> index){
        if(nodelist.size() ==0)return;
        TreeNode nodetemp = nodelist.pop();
        value.add(nodetemp.val);
        int indextemp = index.peek();
        if(nodetemp.left != null ){//这里index的方式不对，index需要及时出栈，
            nodelist.add(nodetemp.left);
//            nodelist.push(nodetemp.left);
            index.push(indextemp+1);
        }
        if(nodetemp.right != null){
            nodelist.add(nodetemp.right);
            index.push(indextemp+1);
        }
        level(nodelist,value,index);
    }

    public static void level2(LinkedList<TreeNode> nodelist, ArrayList<Integer> value,LinkedList<Integer> index, LinkedList<Integer> indexr){
        if(nodelist.size() ==0)return;
        TreeNode nodetemp = nodelist.pop();
        int indextemp = index.pop();
        value.add(nodetemp.val);
        if(nodetemp.left != null ){//这里index的方式不对，index需要及时出栈，
            nodelist.add(nodetemp.left);
//            nodelist.push(nodetemp.left);
            index.add(indextemp+1);
            indexr.add(indextemp+1);
        }
        if(nodetemp.right != null){
            nodelist.add(nodetemp.right);
            index.add(indextemp+1);
            indexr.add(indextemp+1);
        }
        level2(nodelist,value,index,indexr);
    }

/*
官方解答，三种，都不是很熟练，试着来一种吧
感觉在for循环中，deque是不变的，这应该是最重要的吧
 */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
