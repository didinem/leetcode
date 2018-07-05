package org.didinem;

/**
 * Created by zhongzhengmin on 2017/4/7.
 */
public class S414 {

    public int thirdMax(int[] nums) {

        Integer m1 = null;
        Integer m2 = null;
        Integer m3 = null;
        for (int num : nums) {
            if (m1 == null || m1 <= num) {
                m1 = num;
                continue;
            }
            if (m2 == null || m2 <= num) {
                m2 = num;
                continue;
            }
            if (m3 == null || m3 <= num) {
                m3 = num;
                continue;
            }

        }
        return m3 == null ? m3 : m1;
    }

    public static void main(String[] args) {
        S414 s = new S414();
        s.thirdMax(new int[]{1, 2, 3});
    }


}
