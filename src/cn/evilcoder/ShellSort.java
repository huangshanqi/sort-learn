package cn.evilcoder;

import java.util.Arrays;

/**
 * User: Huangshanqi
 * Date: 2016/3/22
 * Time: 11:58
 */
public class ShellSort {

    private static final int limit = 100;
    private static final int len = 20;
    public static void main(String[] args) {
        int[] nums = RandomArray.genArrays(limit,len);
        System.out.println("before:"+ Arrays.toString(nums));
        shellSort(nums);
        System.out.println("after　:"+Arrays.toString(nums));
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
