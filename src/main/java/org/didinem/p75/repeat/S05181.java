package org.didinem.p75.repeat;

import java.util.Arrays;

/**
 * @Classname S05181
 * @Description TODO
 * @Date 2020/5/18 14:40
 * @Created by didinem
 */
public class S05181 {

    public static void sortColors(int[] nums) {
        sort0(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort0(int[] nums, int leftIndex, int rightIndex) {
        if (nums == null) {
            return;
        }
        if (leftIndex >= rightIndex) {
            return;
        }

        int i = leftIndex;
        int j = rightIndex;
        int temp;
        while (i < j) {
            while (i < j) {
                if (nums[i] > nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    i++;
                    break;
                }
                j--;
            }
            while (i < j) {
                if (nums[i] > nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    break;
                }
                i++;
            }
        }

        if ((i - 1) - leftIndex > 0) {
            sort0(nums, leftIndex, i - 1);
        }
        if (rightIndex - (i + 1) > 0) {
            sort0(nums, (i + 1), rightIndex);
        }

    }


    public static void main(String[] args) {
        System.out.println(null == null);
        sortColors(new int[]{3, 5, 1, 2, 7, 5, 4});
    }

}
