package org.didinem.p75.repeat;

import java.util.Arrays;

/**
 * @Classname S05121
 * @Description TODO
 * @Date 2020/5/12 14:23
 * @Created by didinem
 */
public class S05121 {

    public static void sortColors(int[] nums) {
        sort1(nums, 0, nums.length - 1);
    }

    public static void sort0(int[] nums, int leftIndex, int rightIndex) {
        if (nums == null) {
            return;
        }
        if (leftIndex == rightIndex) {
            return;
        }
        if (rightIndex - leftIndex == 1) {
            if (nums[rightIndex] < nums[leftIndex]) {
                int temp = nums[rightIndex];
                nums[rightIndex] = nums[leftIndex];
                nums[leftIndex] = temp;
                return;
            }
        }

        int base = nums[leftIndex];
        int leftPointer = leftIndex + 1;
        int rightPointer = rightIndex;
        int state = 1;//0 left;1 right
        int space = leftIndex;

        while (leftPointer != rightPointer) {
            if (state == 1) {
                if (nums[rightPointer] < base) {
                    nums[space] = nums[rightPointer];
                    space = rightPointer;
                    rightPointer--;
                    state = 0;
                } else {
                    rightPointer--;
                }
            } else if (state == 0) {
                if (nums[leftPointer] > base) {
                    nums[space] = nums[leftPointer];
                    space = leftPointer;
                    leftPointer++;
                    state = 1;
                } else {
                    leftPointer++;
                }
            }
        }
        nums[leftPointer] = base;

//        int i = 0;
//        int[] leftArrays = new int[leftPointer];
//        int[] rightArrays = new int[nums.length - leftPointer - 1];
//        while (i < nums.length) {
//            if (i < leftPointer) {
//                leftArrays[i] = nums[i];
//            } else if (i > leftPointer) {
//                rightArrays[i - leftPointer - 1] = nums[i];
//            }
//        }
        System.out.println(Arrays.toString(nums));
    }

    public static void sort1(int[] nums, int leftIndex, int rightIndex) {
        if (nums == null) {
            return;
        }
        if (leftIndex == rightIndex) {
            return;
        }

        int leftPointer = leftIndex;
        int rightPointer = rightIndex;

        int temp;
        while (leftPointer != rightPointer) {
            while (rightPointer > leftPointer) {
                if (nums[rightPointer] < nums[leftPointer]) {
                    temp = nums[rightPointer];
                    nums[rightPointer] = nums[leftPointer];
                    nums[leftPointer] = temp;
                    leftPointer++;
                    break;
                }
                rightPointer--;
            }
            while (rightPointer > leftPointer) {
                if (nums[rightPointer] < nums[leftPointer]) {
                    temp = nums[rightPointer];
                    nums[rightPointer] = nums[leftPointer];
                    nums[leftPointer] = temp;
                    rightPointer--;
                    break;
                }
                leftPointer++;
            }
        }

        if (leftPointer - 1 > leftIndex) {
            sort1(nums, leftIndex, leftPointer - 1);
        }
        if (rightIndex > leftPointer + 1) {
            sort1(nums, leftPointer + 1, rightIndex);
        }

        System.out.println(Arrays.toString(nums));
    }

    public static int[] qsort(int nums[],int start,int end) {
        int pivot = nums[start];
        int i = start;
        int j = end;
        while (i<j) {
            while ((i<j)&&(nums[j]>pivot)) {
                j--;
            }
            while ((i<j)&&(nums[i]<pivot)) {
                i++;
            }
            if ((nums[i]==nums[j])&&(i<j)) {
                i++;
                // j--;也是可以的
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if (i-1>start) nums=qsort(nums,start,i-1);
        if (j+1<end) nums=qsort(nums,j+1,end);
        return (nums);
    }

    public static void main(String[] args) {
        sortColors(new int[]{3, 5, 1, 2, 7, 5, 4});
    }

}
