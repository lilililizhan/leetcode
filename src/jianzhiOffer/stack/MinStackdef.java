package jianzhiOffer.stack;
/*
栈的实现，由于min,push,pop的时间复杂度是o(1),所以采用数组的形式，但min函数有点难啊，
使用linkedlist来实现吧，但是min真的不会啊，

初始代码超出时间限制，我不会了，看答案

不是很懂答案的逻辑，原来stack是已知的，关键问题在于min函数，
看了官方的解答，不懂这个类的定义，难道是因为判断的时候A.pop已经执行一次了吗
通过测试，果然是的
 */

import java.util.LinkedList;
import java.util.Stack;

public class MinStackdef{
    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(1);
        System.out.println(minStack.min());
        minStack.pop();
//        System.out.println();
        System.out.println(minStack.top());
        System.out.println(minStack.min());

    }

}

class MinStack {
    LinkedList<Integer> num = new LinkedList<>();
    public MinStack() {

    }

    public void push(int x) {
        num.push(x);
    }

    public void pop() {
        num.pop();
    }

    public int top() {
        return num.get(0);
    }

    public int min() {
        int min = num.get(0);
        for (int i = 0; i < num.size(); i++) {
            if(num.get(i)<min)min = num.get(i);
        }
        return min;
    }
}

class MinStack2 {
    Stack<Integer> A, B;
    public MinStack2() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    public void pop() {
//        A.pop();
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }
}

