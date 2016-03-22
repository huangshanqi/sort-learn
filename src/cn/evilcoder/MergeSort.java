package cn.evilcoder;

import java.util.Arrays;

/**
 * User: Huangshanqi
 * Date: 2016/3/22
 * Time: 12:00
 */
public class MergeSort {

    private static final int limit = 100;
    private static final int len = 20;
    public static void main(String[] args) {
        int[] nums = RandomArray.genArrays(limit,len);
        System.out.println("before:"+ Arrays.toString(nums));
        mergeSort(nums,0,nums.length-1);
        System.out.println("after　:"+Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums,int start,int end){
        if(start<end){
            int mid = start + (end - start)/2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    public static void merge(int[] nums,int start,int mid,int end){
        //临时数组存储中间需要合并的的元素
        int[] copy = new int[end+1-start];
        //已排序数组索引
        int count = 0;
        int left  = start;
        int right = mid+1;
        while(left<=mid && right<=end){
            if(nums[left]<nums[right]){
                copy[count++] = nums[left++];
            }else{
                copy[count++] = nums[right++];
            }
        }
        while (left<=mid){
            copy[count++] = nums[left++];
        }
        while (right<=end){
            copy[count++] = nums[right++];
        }
        //将临时已排序的数组复制回原数组的[start,end]
        for(count=0;count<copy.length;count++){
            nums[start++] = copy[count];
        }
    }
}
