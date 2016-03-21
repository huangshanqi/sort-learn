package cn.evilcoder;

import java.util.Random;

/**
 * User: Huangshanqi
 * Date: 2016/3/21
 * Time: 17:13
 */
public class RandomArray {
    private static final Random randon = new Random(System.currentTimeMillis());
    public static int[] genArrays(int limit,int len){
        int[] result = new int[len];
        for(int i=0;i<len;i++){
            result[i] = randon.nextInt(limit);
        }
        return result;
    }
}
