package stack;

import java.util.ArrayList;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
/*
由于并没有定义栈的大小，故使用ArrayList,
似乎不用定义栈顶，
需要定义一个ArrayList
 */
public class MinStack {
    ArrayList<Integer> stack = new ArrayList<>();
    public MinStack() {

    }

    public void push(int x) {
        stack.add(x);
    }

    public void pop() {
        stack.remove(stack.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);

    }

    public int getMin() {
        int min = stack.get(0);
        for (Integer s:stack
             ) {
            if(s<min){
                min = s;
            }

        }
        return min;
    }
}
