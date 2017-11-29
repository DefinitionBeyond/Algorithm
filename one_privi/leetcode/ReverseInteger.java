package one_privi.leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-100));
    }
    public String getType(Object o){
        return o.getClass().toString();
    }
    public int reverse(int x) {//反转数字
//        boolean falg = true;
//        if(x<0){
//            falg = false;
//            x = Math.abs(x);
//        }
//        String r = String.valueOf(x);
//        int len = r.length();
//        char []c = r.toCharArray();
//        char t;
//        for(int i =0 ; i< len/2 ;i++){
//                t = c[i];
//                c[i] = c[len-i-1];
//                c[len-i-1] = t;
//        }
//        System.out.println(getType(Integer.valueOf(String.valueOf(c))));
//        if(!falg){
//            return 0-Integer.valueOf(String.valueOf(c));
//        }
//        return Integer.valueOf(String.valueOf(c));
        boolean flag=true;
        if(x < 0)
        {
            x = -x;
            flag = false;
        }

        //算法核心部分,用一个long类型的ret去解决判断溢出问题
        long ret = 0;
        while(x != 0)
        {
            ret = ret * 10 + x % 10;
            x /= 10;
        }

        //判断是否溢出
        if(ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE)
        {
            ret = 0;
        }

        //处理负数
        if(!flag)
        {
            ret = -ret;
        }

        return (int)ret;
    }
}
