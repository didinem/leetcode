package org.didinem;

/**
 * Created by zhongzhengmin on 2017/4/1.
 */
public class s65 {

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        int sz = chars.length;
        boolean hasExp = false;
        boolean hasDecPoint = false;
        boolean allowSigns = false;
        boolean foundDigit = false;
        int start = chars[0] == 45?1:0;
        int i;
        if(sz > start + 1 && chars[start] == 48 && chars[start + 1] == 120) {
            i = start + 2;
            if(i == sz) {
                return false;
            } else {
                while(i < chars.length) {
                    if((chars[i] < 48 || chars[i] > 57) && (chars[i] < 97 || chars[i] > 102) && (chars[i] < 65 || chars[i] > 70)) {
                        return false;
                    }

                    ++i;
                }

                return true;
            }
        } else {
            --sz;

            for(i = start; i < sz || i < sz + 1 && allowSigns && !foundDigit; ++i) {
                if(chars[i] >= 48 && chars[i] <= 57) {
                    foundDigit = true;
                    allowSigns = false;
                } else if(chars[i] == 46) {
                    if(hasDecPoint || hasExp) {
                        return false;
                    }

                    hasDecPoint = true;
                } else if(chars[i] != 101 && chars[i] != 69) {
                    if(chars[i] != 43 && chars[i] != 45) {
                        return false;
                    }

                    if(!allowSigns) {
                        return false;
                    }

                    allowSigns = false;
                    foundDigit = false;
                } else {
                    if(hasExp) {
                        return false;
                    }

                    if(!foundDigit) {
                        return false;
                    }

                    hasExp = true;
                    allowSigns = true;
                }
            }

            return i < chars.length?(chars[i] >= 48 && chars[i] <= 57?true:(chars[i] != 101 && chars[i] != 69?(chars[i] == 46?(!hasDecPoint && !hasExp?foundDigit:false):(allowSigns || chars[i] != 100 && chars[i] != 68 && chars[i] != 102 && chars[i] != 70?(chars[i] != 108 && chars[i] != 76?false:foundDigit && !hasExp):foundDigit)):false)):!allowSigns && foundDigit;
        }
    }

}
