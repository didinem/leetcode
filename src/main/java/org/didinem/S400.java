package org.didinem;

/**
 * Created by zhongzhengmin on 2017/4/7.
 */
public class S400 {

    public int findNthDigit(int n) {
        int base = 9;
        int ntemp = n;
        int result = 0;
        if (n < 10) {
            return n;
        }
        for (int i = 1; i <= 10; i++) {
            int beishu = (int) Math.pow(10, i - 1);
            int range = crange(beishu, i, base);
            if (ntemp - range > 0) {
                ntemp -= range;
                continue;
            }
            int whichone = whichone(ntemp, i);
            int num = getMaxNum(i - 1) + whichone;
            int digit = ntemp - i * (whichone - 1);
            result = getP(num, digit);
            break;
        }
        return result;
    }

    public int getMaxNum(int weishu) {
        int max = (int) Math.pow(10, weishu);
        return max - 1;
    }

    public int whichone(int n, int weishu) {
        int whichone = 0;
        for (int i = n; i < Integer.MAX_VALUE; i++) {
            if (n % weishu == 0) {
                whichone = n;
                break;
            }
        }
        return whichone;
    }

    public int crange(int beishu, int weishu, int base) {
        long lbeishu = beishu;
        long lweishu = weishu;
        long lbase = base;
        long lrange = lbeishu * lweishu * lbase;
        return lrange > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) lrange;
    }

    public int getP(int num, int p) {
        int result = 0;
        int i = 1;
        while (i <= p) {
            result = num % 10;
            num = num / 10;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        S400 s = new S400();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(s.findNthDigit(Integer.MAX_VALUE));
    }
    
}
