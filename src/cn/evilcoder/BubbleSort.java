package cn.evilcoder;

import java.util.Arrays;

/**
 * User: Huangshanqi
 * Date: 2016/3/21
 * Time: 17:03
 */
public class BubbleSort {

    private static final int limit = 20;
    private static final int len = 10;
    public static void main(String[] args) {
        int[] nums = RandomArray.genArrays(limit,len);
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void bubbleSort(int[] nums){
    }
}
