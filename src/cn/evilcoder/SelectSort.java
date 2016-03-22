package cn.evilcoder;

import java.util.Arrays;

/**
 * User: Huangshanqi
 * Date: 2016/3/22
 * Time: 11:56
 */
public class SelectSort {
    private static final int limit = 100;
    private static final int len = 20;
    public static void main(String[] args) {
        int[] nums = RandomArray.genArrays(limit,len);
        System.out.println("before:"+ Arrays.toString(nums));
        selectSort(nums);
        System.out.println("after　:"+Arrays.toString(nums));
    }

    public static void selectSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            int min = nums[i];
            int minIndex = i;
            for(int j=i;j<nums.length;j++){
                if(min>nums[j]){
                    min = nums[j];
                    minIndex = j;
                }
            }
            nums[minIndex] = nums[i];
            nums[i] = min;
        }
    }
}
