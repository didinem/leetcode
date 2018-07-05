package org.didinem;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhongzhengmin on 2018/2/26.
 */
public class S3M1 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        char[] chars = s.toCharArray();
        Set<Character> longestSubStringSet = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            char currentStartChar = chars[i];
            Set<Character> currentSet = new HashSet<>();
            currentSet.add(currentStartChar);
            for (int j = i + 1; j < chars.length; j++) {
                int beforeAdd = currentSet.size();
                currentSet.add(chars[j]);
                int afterAdd = currentSet.size();
                if (afterAdd == beforeAdd) {
                    break;
                }
            }
            if (currentSet.size() > longestSubStringSet.size()) {
                longestSubStringSet = currentSet;
            }
        }

        return longestSubStringSet.size();
    }

}
