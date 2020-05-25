package org.didinem.sort.mergesort;

import java.util.Arrays;

/**
 * @Classname S20200525
 * @Description TODO
 * @Date 2020/5/25 12:45
 * @Created by didinem
 */
public class S20200525 {

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 3, 1, 7, 4, 2, 8, 3, 4, 9, 0};
        System.out.println(Arrays.toString(mergeSort(array, 0, array.length - 1)));

    }

    public static int[] mergeSort(int[] array, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return new int[]{array[startIndex]};
        }

        int size = endIndex - startIndex + 1;
        int[] left = mergeSort(array, startIndex, startIndex + size / 2 - 1);
        int[] right = mergeSort(array, startIndex + size / 2, endIndex);

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] temp = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int index = 0;
        for (;index < temp.length; index++) {
            if ((i > left.length - 1) || (j > right.length - 1)) {
                break;
            }
            if (left[i] > right[j]) {
                temp[index] = right[j];
                j++;
            } else {
                temp[index] = left[i];
                i++;
            }
        }
        while (i < left.length) {
            temp[index++] = left[i];
            i++;
        }
        while (j < right.length) {
            temp[index++] = right[j];
            j++;
        }
        return temp;
    }

}
