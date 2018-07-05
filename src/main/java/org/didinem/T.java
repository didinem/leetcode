package org.didinem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongzhengmin on 2017/4/25.
 */
public class T {

    public static void main(String[] args) {
//        char[] src = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
//        char[] target = new char[]{'p', 'v', 'w', 'd', 'g', 'a', 'z', 'x', 'u', 'b', 'q', 'f', 's', 'n', 'r', 'h', 'o', 'c', 'i', 't', 'l', 'k', 'e', 'y', 'm', 'j'};

        Map<Character, Character> map = new HashMap<>();
//        map.put('a','p');
//        map.put('b','v');
//        map.put('c','w');
//        map.put('d','d');
//        map.put('e','g');
//        map.put('f','a');
//        map.put('g','z');
//        map.put('h','x');
//        map.put('i','u');
//        map.put('j','b');
//        map.put('k','q');
//        map.put('l','f');
//        map.put('m','s');
//        map.put('n','n');
//        map.put('o','r');
//        map.put('p','h');
//        map.put('q','o');
//        map.put('r','c');
//        map.put('s','i');
//        map.put('t','t');
//        map.put('u','l');
//        map.put('v','k');
//        map.put('w','e');
//        map.put('x','y');
//        map.put('y','m');
//        map.put('z','j');
        map.put('p','a');
        map.put('v','b');
        map.put('w','c');
        map.put('d','d');
        map.put('g','e');
        map.put('a','f');
        map.put('z','g');
        map.put('x','h');
        map.put('u','i');
        map.put('b','j');
        map.put('q','k');
        map.put('f','l');
        map.put('s','m');
        map.put('n','n');
        map.put('r','o');
        map.put('h','p');
        map.put('o','q');
        map.put('c','r');
        map.put('i','s');
        map.put('t','t');
        map.put('l','u');
        map.put('k','v');
        map.put('e','w');
        map.put('y','x');
        map.put('m','y');
        map.put('j','z');

        String input = "Wxgcg txgcg ui p ixgff, txgcg ui p epm. I gyhgwt mrl lig txg ixgff wrsspnd tr irfkg txui hcrvfgs, nre, hfgpig tcm liunz txg crt13 ra \"ixgff\" tr gntgc ngyt fgkgf.";
        String lowercaseInput = input.toLowerCase();
        char[] characters = lowercaseInput.toCharArray();
        char[] outputs = new char[characters.length];
        for (int i = 0; i < characters.length; i++) {
            if (map.containsKey(characters[i])) {
                outputs[i] = map.get(characters[i]);
            } else {
                outputs[i] = characters[i];
            }
        }
        System.out.println(new String(outputs));
    }

}
