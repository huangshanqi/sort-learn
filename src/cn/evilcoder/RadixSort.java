package cn.evilcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Huangshanqi
 * Date: 2016/3/22
 * Time: 12:01
 */
public class RadixSort {

    private static final int limit = 100;
    private static final int len = 20;
    public static void main(String[] args) {
        int[] nums = RandomArray.genArrays(limit,len);
        System.out.println("before:"+ Arrays.toString(nums));
        radixSort(nums);
        System.out.println("after　:"+Arrays.toString(nums));
    }

    private static void radixSort(int[] nums){
        //找出最大数
        int max = Integer.MIN_VALUE;
        for(int n:nums){
            max = Math.max(max,n);
        }
        //确定需要的排序趟数，最大数的位数
        int step = 0;
        while (max!=0){
            step++;
            max /= 10;
        }
        //0-9共十个基数数组
        List<List<Integer>> radix = new ArrayList<List<Integer>>();
        for(int i=0;i<10;i++){
            radix.add(new ArrayList<Integer>());
        }
        //进行step次的分配收集
        int pow = 1;
        for(int i=0;i<step;i++){
            pow *= 10;
            for(int n:nums){
                int rad  = (n%pow)*10/pow;
                List<Integer> temp = radix.get(rad);
                temp.add(n);
                radix.set(rad,temp);
            }
            //收集
            int index = 0;
            for(List<Integer> list:radix){
                for(int n:list){
                    nums[index++] = n;
                }
                list.clear();
            }
        }
    }
}
