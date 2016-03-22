package cn.evilcoder;

import java.util.Arrays;

/**
 * User: Huangshanqi
 * Date: 2016/3/22
 * Time: 11:59
 */
public class QuickSort {

    private static final int limit = 100;
    private static final int len = 20;
    public static void main(String[] args) {
        int[] nums = RandomArray.genArrays(limit,len);
        System.out.println("before:"+Arrays.toString(nums));
        quickSort(nums,0,nums.length-1);
        System.out.println("after　:"+Arrays.toString(nums));
    }

    public static int partition(int[] nums,int start,int end,int pivotIndex){
        //这个循环比一般的写法简洁高效,就是先统计比基准值小的个数smaller,最后基准值就放在smaller上了
        int pivot = nums[pivotIndex];
        int smaller = start;
        Utils.swap(nums,pivotIndex,end);
        for(int i=start;i<end;i++){
            if(nums[i]<pivot){
                Utils.swap(nums,i,smaller);
                smaller++;
            }
        }
        Utils.swap(nums,smaller,end);
        return smaller;
    }

    public static void quickSort(int[] nums,int start,int end){
        if(start<end){
            int pivot = partition(nums,start,end,start);
            System.out.println(pivot+":"+ Arrays.toString(nums));
            quickSort(nums,start,pivot-1);
            quickSort(nums,pivot+1,end);
        }
    }
}
