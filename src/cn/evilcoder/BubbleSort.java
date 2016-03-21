package cn.evilcoder;

import java.util.Arrays;

/**
 * User: Huangshanqi
 * Date: 2016/3/21
 * Time: 17:03
 */
public class BubbleSort {

    private static final int limit = 30;
    private static final int len = 20;
    public static void main(String[] args) {
        int[] nums = RandomArray.genArrays(limit,len);
        System.out.println("before:"+Arrays.toString(nums));
        shellSort(nums);
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

    public static void shellSort(int[] nums){
        int interval = nums.length/2;
        while(interval>1){
            for(int i=0;i<interval;i++){
                //下面就是插入排序了，跟上面的是一样的
                for(int j=i+interval;j<nums.length;j+=interval){
                    int temp = nums[j];
                    int k=j-interval;
                    for(;k>=0 && nums[k]>temp;k-=interval){
                        //比temp大的往后移
                        nums[k+interval] = nums[k];
                    }
                    nums[k+interval] = temp;
                }
            }
            interval /= 2;
        }
    }


}
