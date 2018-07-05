package org.didinem;

/**
 * Created by zhongzhengmin on 2017/4/1.
 */
public class S9 {

    public void aaa() {
        try {
            Integer a = null;
            a = a + 1;
        } catch (Exception e) {
        }
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int ws = 1;
        int xForws = x;
        while (xForws / 10 > 0) {
            ws++;
            xForws = xForws / 10;
        }
        return isPalindrome(x, ws, 1);
    }

    public boolean isPalindrome(int x, int p1, int p2) {
        if (p1 == p2) {
            return true;
        }
        int np1 = getP(x, p1);
        int np2 = getP(x, p2);
        if (np1 == np2) {
            if (p1 - 1 < p2 + 1) {
                return true;
            }
            return isPalindrome(x, p1 - 1, p2 + 1);
        }
        return false;
    }

    public int getWs(int num) {
        int ws = 1;
        while (num / 10 > 0) {
            ws++;
            num = num / 10;
        }
        return ws;
    }

    public int getP(int num, int p) {
        int result = 0;
        int ws = getWs(num);
        int times = Math.min(ws, p);
        int i = 1;
        while (i <= times) {
            result = num % 10;
            num = num / 10;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        S9 s = new S9();
//        System.out.println(s.isPalindrome(717));
        int num = 1122;
        System.out.println(s.isPalindrome(num));
    }

}
