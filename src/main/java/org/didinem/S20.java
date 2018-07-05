package org.didinem;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhongzhengmin on 2017/4/7.
 */
public class S20 {

    public boolean isValid(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }

        List<Character> starts = Arrays.asList('(', '[', '{');
        List<Character> ends = Arrays.asList(')', ']', '}');
        List<String> match = Arrays.asList("()", "[]", "{}");
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (starts.contains(c)) {
                stack.push(c);
                continue;
            }
            if (ends.contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character start = stack.peek();
                String str = String.valueOf(new char[]{start, c});
                if (!match.contains(str)) {
                    return false;
                }
                stack.pop();
                continue;
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        S20 s = new S20();
        String string = "([{]})";
        System.out.println(s.isValid(string));
    }

}
