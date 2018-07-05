package org.didinem;

import java.util.HashSet;

/**
 * Created by zhongzhengmin on 2018/2/26.
 */
public class S3M2 {

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();

        // [left,right)
        while (left < chars.length && right < chars.length) {
            if (set.contains(chars[right])) {
                set.remove(chars[left]);
                left++;
            } else {
                set.add(chars[right]);
                right++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcd"));
    }




}
