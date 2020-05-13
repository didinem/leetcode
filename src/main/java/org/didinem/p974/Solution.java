package org.didinem.p974;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static int subarraysDivByK(int[] A, int K) {
        if (A == null) {
            return 0;
        }

        if (A.length == 0) {
            return 0;
        }

        if (K == 0) {
            return 0;
        }

        List<Integer> sumList = new ArrayList<>(A.length);
        return doSum(sumList, A, 0, K);
    }

    private static int doSum(List<Integer> lastIndexSumList, int[] A, int index, int K) {
        int number = 0;

        List<Integer> currentIndexSumList = new ArrayList<>(A.length);
        int currentIndexValue = A[index];

        currentIndexSumList.add(A[index]);
        if (currentIndexValue % K == 0) {
            number++;
        }

        for (int i = 0; i < lastIndexSumList.size(); i++) {
            if ((lastIndexSumList.get(i) + currentIndexValue) % K == 0) {
                number++;
            }
            currentIndexSumList.add(currentIndexValue + lastIndexSumList.get(i));
        }

        if (index == A.length - 1) {
            return number;
        }

        return doSum(currentIndexSumList, A, index + 1, K) + number;
    }


    public static void main(String[] args) {
        int[] A = new int[]{4, 5, 0, -2, -3, 1};
        int K = 5;
        System.out.println(subarraysDivByK(A, K));
    }



}
