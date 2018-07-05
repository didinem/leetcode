package org.didinem;

/**
 * Created by zhongzhengmin on 2018/2/26.
 */
public class S5M1 {

    public String longestPalindrome(String s) {
        char[] string = s.toCharArray();
        int left = 0;
        int right = 0;


        while (left < string.length && right < string.length) {

        }

        return "";
    }

    public static boolean isPalindromic(char[] substring) {
        int i = 0;
        int j = substring.length - 1;
        while (i < j) {
            if (substring[i] == substring[j]) {
                i++;
                j--;
                continue;
            }
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromic("a".toCharArray()));
    }

}
