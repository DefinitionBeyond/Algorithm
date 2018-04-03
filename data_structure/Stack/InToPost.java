package data_structure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author liutao
 * @date 2018/3/28  18:05
 */
public class InToPost {
    private Stack<Character> stack;
    private String input;
    private String output = "";

    public InToPost(String input) {
        this.input = input;
        int stackSize = input.length();
        stack = new Stack();
    }

    public String doTrans() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1); // 如果是+ 和 - 出栈操作，运算符优先级为1
                    break;
                case '*':
                case '/':
                    gotOper(ch, 1); // 如果是 / 和 * 出栈操作，运算符优先级为2
                    break;
                case '(':
                    stack.push(ch); // 如果是（ 直接push入栈
                    break;
                case ')':
                    gotParen(ch); //如果是 ） 出栈操作
                    break;
                default:
                    output += ch; // 不是运算符 ，写入结果
                    break;
            }
        }
        while (!stack.isEmpty()) {
            output = output + stack.pop(); //遍历完表达式，运算符栈中还有元素，直接pop
        }
        return output;
    }

    /**
     * 当前操作符是）时，之前操作符是（ 时，（直接出栈，不是就把（之前的操作符全部写入结果
     *
     * @param ch 后括号
     */
    private void gotParen(char ch) {
        while (!stack.isEmpty()) {
            char chx = stack.pop();
            if (chx == '(') {
                break;
            } else output = output + chx;
        }
    }

    /**
     * @param opThis 运算符
     * @param prec   运算符的优先级
     */
    private void gotOper(char opThis, int prec) {
        while (!stack.isEmpty()) {
            char opTop = stack.pop(); // 之前运算符
            if (opTop == '(') { // 如果是（ 运算符入栈
                stack.push(opTop);
                break;
            } else { //如果是操作符
                int prec1;
                if (opTop == '+' || opTop == '-') { //看之前一个操作符的优先级
                    prec1 = 1;
                } else {
                    prec1 = 2;
                }
                if (prec1 < prec) { //如果当前操作符优先级比之前的优先级高
                    stack.push(opTop); // 之前的操作符入栈
                    break;
                } else {
                    output = output + opTop; //否则之前的操作符写入结果
                }
            }
        }
        stack.push(opThis); //当前操作符入栈
    }

    //    public void display(){
//
//    }
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        InToPost transfor = new InToPost(s);
        String output = transfor.doTrans();
        System.out.println(output);

    }
}
// A*(B+C)-D/(E+F)
