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
        mergeSort(nums, 0, nums.length - 1);
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
            System.out.println(pivot+":"+Arrays.toString(nums));
            quickSort(nums,start,pivot-1);
            quickSort(nums,pivot+1,end);
        }
    }

    public static void mergeSort(int[] nums,int start,int end){
        if(start<end){
            int mid = start + (end - start)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
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
