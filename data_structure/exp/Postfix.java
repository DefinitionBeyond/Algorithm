package data_structure.exp;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author liutao
 * @date 2017/12/10  9:27
 */

/**
 * 将前缀式转化为逆波兰式(后缀式)
 */
public class Postfix {

    private LinkedList<String> operators = new LinkedList<>(); // 对操作符进行存储的列表

    private LinkedList<String> output = new LinkedList<>(); // 对后缀式结果的存储

    private StringBuffer sb = new StringBuffer();

    /**
     * 判断该字符是否是一个操作符
     *
     * @param oper
     * @return
     */
    private boolean isOperator(String oper) {
        if (oper.equals("+") || oper.equals("-") || oper.equals("/") || oper.equals("*")
                || oper.equals("(") || oper.equals(")")) {
            return true;
        }
        return false;
    }

    /**
     * 算术字符在运算中的优先级
     *
     * @param s
     * @return
     */
    private int priority(String s) {
        switch (s) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "(":
            case ")":
                return 3;
            default:
                return 0;
        }
    }

    public void transferToPostfix(LinkedList<String> list) {
        Iterator<String> it = list.iterator(); // 对给定的前缀式进行遍历
        while (it.hasNext()) {
            String s = it.next();
            if (isOperator(s)) {
                if (operators.isEmpty()) { //操作符列表为空的时候，无论什么操作符都放入列表
                    operators.push(s);
                } else {
                    //如果读入的操作符为非")"且优先级比栈顶元素的优先级高或一样，则将操作符压入栈
                    if (priority(operators.peek()) <= priority(s) && !s.equals(")")) {
                        operators.push(s);
                    }
                    //如果读入的操作符为非")"且优先级比栈顶元素的优先级低
                    else if (!s.equals(")") && priority(operators.peek()) > priority(s)) {

                        //如果栈顶元素优先级比当前元素优先级高，且栈顶元素的操作符不是'('
                        while (operators.size() != 0 && priority(operators.peek()) >= priority(s)
                                && !operators.peek().equals("(")) {
                            //一直出栈，直到栈顶元素为"("
                            if (!operators.peek().equals("(")) {
                                String operator = operators.pop();
                                sb.append(operator).append(" ");
                                output.push(operator);//入栈保存结果
                            }
                        }
                        //在把当前操作符加入结果
                        operators.push(s);
                    }
                    //如果读入的操作符是")"，则弹出从栈顶开始第一个"("及其之前的所有操作符
                    else if (s.equals(")")) {
                        while (!operators.peek().equals("(")) {
                            String operator = operators.pop();
                            sb.append(operator).append(" ");
                            output.push(operator);
                        }
                        //弹出"("
                        operators.pop();
                    }
                }
            }
            //读入的为非操作符，直接入栈
            else {
                sb.append(s).append(" ");
                output.push(s);
            }
        }

        LinkedList<String> ans = new LinkedList<>();
        operators.forEach(s -> {
            ans.push(s);
        });
//        System.out.println("=========");
        //如果操作符栈不为空,把操作栈里面剩余的操作符全部入结果栈
//        if (!operators.isEmpty()) {
//            Iterator<String> iterator=operators.iterator();
//            while (iterator.hasNext()) {
//                String operator=iterator.next();
//                sb.append(operator).append(" ");
//                output.push(operator);
//                iterator.remove();
//            }
//        }

        output.forEach(s -> {
            ans.push(s);
        });

        System.out.print("后缀式： ");
        ans.forEach(s -> {
            System.out.print(s + " ");
        });
//        System.out.println("后缀： "+sb);
    }
}
