package one_privi.leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(int x) {//回文数
        if(x<0){
            return false;
        }
        String s = String.valueOf(x);
        for(int i=0 ; i<s.length()/2 ;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
