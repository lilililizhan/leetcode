package jianzhiOffer.stack;

import java.util.Arrays;
import java.util.Stack;

public class validateStackSequences {
    /*
    剑指offer31,middle,
    输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
    假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
    序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
    pushed 是 popped 的排列是啥意思，

    暂时没有思路，觉得应该分为小问题，
    [1,2,3,4,5]
    [4,5,3,2,1]true, [4,3,5,1,2]false
    [4,5]和[3,2,1],[4,3]和[5,1,2]
    感觉思路不太对，[5,1,2]和[1,2,5]为什么不匹配呢？？？

    啊想到啊，当pop中出现就入栈，
    自定义一个栈来维护，然后看出栈的顺序，看队列是否一致
    [][]
    [1,0][1,0]出错,当遍历到1时出现栈为空，
    时间复杂度95，空间复杂度44%
    官方思路一致，但代码好简洁，但是官方每次循环都要push,push后相等的话再pop,是两层的循环

    */
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
//        int[] popped = {4,5,3,2,1};//true
        int[] popped = {4,3,5,1,2};//false

//        int[] pushed = {1,0};
//        int[] popped = {1,0};//true
        boolean r = validateStackSequences2(pushed,popped);
        System.out.println(r);

    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        return true;
    }
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        if(popped.length<=2)return true;
        int start = 0;
        int end = 0;
        int tem= 0;
        for (int i = 0; i < pushed.length; i++) {
           if(pushed[i]==popped[0]){
               start = i;
               end = i;
           }
        }
        //start <=end
        if(popped[tem] < popped[tem+1]){
            while(end < pushed.length-1 && pushed[end+1]==popped[tem+1]){
                end++;
                tem++;
            }

        }
        else {
            while(end >0 && pushed[end-1]==popped[tem+1]){
                end--;
                tem++;
            }
        }

        return true;
    }

    //当最后stack为空即表示为真
    public static boolean validateStackSequences2(int[] pushed, int[] popped) {
        if(popped.length==0)return true;
        Stack<Integer> stack = new Stack<>();
        int indexpush= 0 ;
        int indexpop = 0;
//        stack.push(pushed[0]);
        while(indexpush <=pushed.length && indexpop<popped.length){
            if(stack.empty()){
                stack.push(pushed[indexpush]);
                indexpush++;
            }
            if(stack.peek()== popped[indexpop]){
                stack.pop();
                indexpop++;
            }
            else if(stack.peek() != popped[indexpop]){
                if(indexpush == pushed.length)return false;
                stack.push(pushed[indexpush]);
                indexpush++;

            }
        }
//        System.out.println(stack.toString());
        return stack.empty();
    }

    //官方解答，好简洁啊，
    public boolean validateStackSequences3(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

}

