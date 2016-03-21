package cn.evilcoder;

/**
 * User: evilcoder
 * Date: 2016/3/21
 * Time: 21:09
 */
public class Utils {
  public static void swap(int[] nums,int i,int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
