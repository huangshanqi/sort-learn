package cn.evilcoder;

import java.util.Arrays;

/**
 * User: Huangshanqi
 * Date: 2016/3/21
 * Time: 17:03
 */
public class BubbleSort {

    private static final int limit = 100;
    private static final int len = 20;
    public static void main(String[] args) {
        int[] nums = RandomArray.genArrays(limit,len);
        System.out.println("before:"+Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println("after　:"+Arrays.toString(nums));
    }
    public static void bubbleSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    Utils.swap(nums,j,j+1);
                }
            }
        }
    }
}
