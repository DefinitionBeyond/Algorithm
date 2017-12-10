package data_structure.exp;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author liutao
 * @date 2017/12/10  9:42
 */

public class test {
    @Test
    public void test1() {
        StringBuffer sb = null;
        FileReader reader = null;
        BufferedReader br = null;
        try {
            sb = new StringBuffer("");
            reader = new FileReader("resource/test.txt");
            br = new BufferedReader(reader);
            String str = null;
            LinkedList<String> list = new LinkedList<>();
            while ((str = br.readLine()) != null) {
                list = StrDeal(str, list);//将前缀表达式的操作符和数字依次存入list中
            }
            System.out.print("前缀式： ");
            list.forEach(s -> {
                System.out.print(s + " ");
            });
            System.out.println();
            new Postfix().transferToPostfix(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                br.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static boolean isOperator(String oper) {
        if (oper.equals("+") || oper.equals("-") || oper.equals("/") || oper.equals("*")
                || oper.equals("(") || oper.equals(")")) {
            return true;
        }
        return false;
    }

    private static LinkedList<String> StrDeal(String str, LinkedList<String> list) {
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            if (!isOperator(String.valueOf(str.charAt(i)))) {
                s += String.valueOf(str.charAt(i));
            }
            if (isOperator(String.valueOf(str.charAt(i)))) {
                list.add(s.trim()); // 去除左右空格
                list.add(String.valueOf(str.charAt(i)));
                s = "";
            }
            if (i == str.length() - 1) { // 对于最后一个
                list.add(s.trim());
                s = "";
            }
        }
        return list;
    }
}
