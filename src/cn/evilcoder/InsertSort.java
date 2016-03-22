package cn.evilcoder;

import java.util.Arrays;

/**
 * User: Huangshanqi
 * Date: 2016/3/22
 * Time: 11:57
 */
public class InsertSort {
    private static final int limit = 100;
    private static final int len = 20;
    public static void main(String[] args) {
        int[] nums = RandomArray.genArrays(limit,len);
        System.out.println("before:"+ Arrays.toString(nums));
        insertSort(nums);
        System.out.println("after　:"+Arrays.toString(nums));
    }

    public static void insertSort(int[] nums){
        for(int i=1;i<nums.length;i++){
            int temp = nums[i];
            int j = i-1;
            for(;j>=0 && nums[j]>temp;j--){
                //比temp大的往后移
                nums[j+1] = nums[j];
            }
            nums[j+1] = temp;
        }
    }
}
