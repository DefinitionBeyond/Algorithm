package one_privi.zuochengyun;


import data_structure.Linklist.*;

import java.util.Random;

public class printPublicElemLinklist{
    public static void main(String[] args) {
        Random random = new Random();
        SimpleLinklist l1 = new SimpleLinklist();
        int []a = {1,4,6,8,9,12,14,15,16,18};
        int []b = {2,4,5,9,10,11,13,15,17,18};
        for(int i = 0 ; i < a.length ; i++){
            l1.addLast(a[i]);
        }
        SimpleLinklist l2 = new SimpleLinklist();
        for(int i = 0 ; i < b.length ; i++){
            l2.addLast(b[i]);
        }
        new printPublicElemLinklist().opreat(l1,l2);
    }
    public void opreat(SimpleLinklist a, SimpleLinklist b){
       while(a.frist!=null&&b.frist!=null){
           if(a.frist.data<b.frist.data){
               a.frist = a.frist.next;
           }else if(a.frist.data>b.frist.data){
               b.frist = b.frist.next;
           }else {
               System.out.println(a.frist.data);
               a.frist = a.frist.next;
               b.frist = b.frist.next;
           }
       }
    }
}