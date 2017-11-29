package one_privi.zuochengyun;

import java.util.Random;
import java.util.Stack;

public class StackImpOtherStacksort {
    public static void main(String[] args) {
        Random random = new Random();

//        int s = random.nextInt(max)%(max-min+1) + min;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < 10 ;i++){
            stack.push(random.nextInt(100)%(100-1+1)+1);
        }
       StackImpOtherStacksort s = new StackImpOtherStacksort();
       s.print(s.sort(stack));
    }

    public void print(Stack<Integer> stack){
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public Stack<Integer> sort(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()) {
            int t = stack.pop();
            while (!help.isEmpty() && t < help.peek()) {//如果help栈顶元素小于stack栈顶元素，help一次入stack
                stack.push(help.pop());
            }
            help.push(t);//t小于栈顶元素，压栈help
        }
            while(!help.isEmpty()){//在全部放入stack
                stack.push(help.pop());
            }
        return stack;
    }

}
