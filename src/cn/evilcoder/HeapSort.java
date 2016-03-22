package cn.evilcoder;

import java.util.Arrays;

/**
 * User: Huangshanqi
 * Date: 2016/3/22
 * Time: 12:01
 */
public class HeapSort {

    private static final int limit = 100;
    private static final int len = 20;
    public static void main(String[] args) {
        int[] nums = RandomArray.genArrays(limit,len);
        System.out.println("before:"+ Arrays.toString(nums));
        heapSort(nums);
        System.out.println("after　:"+Arrays.toString(nums));
    }

    public static void heapSort(int[] nums){
        for(int i=nums.length/2-1;i>=0;i--){
            maxHeapAjust(nums,i,nums.length-1);
        }

        for(int i=nums.length-1;i>0;i--){
            Utils.swap(nums,0,i);
            maxHeapAjust(nums,0,i-1);
        }
    }

    public static void maxHeapAjust(int[] nums,int start,int end){
        int left = start*2;
        int right = start*2+1;
        int max = start;
        if(left<=end && nums[left]>nums[max]){
            max = left;
        }
        if(right<=end && nums[right]>nums[max]){
            max = right;
        }
        if(max!=start){
            Utils.swap(nums,max,start);
            maxHeapAjust(nums,max,end);
        }
    }
}
