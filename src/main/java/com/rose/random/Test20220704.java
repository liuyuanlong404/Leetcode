package com.rose.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2022/7/4 10:55
 *
 * @author Lakers
 *
 * 1200. 最小绝对差
 *
 * 给你个整数数组 arr，其中每个元素都不相同。
 *
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 */
public class Test20220704 {


    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = arr[1] - arr[0];
        for (int i = 0; i <= arr.length - 2; i++){
            min = Math.min(arr[i + 1] - arr[i], min);
        }
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i <= arr.length - 2; i++){
            if (arr[i + 1] - arr[i] == min){
                int finalI = i;
                resList.add(new ArrayList<Integer>(){{add(arr[finalI]); add(arr[finalI + 1]);}});
            }
        }
        return resList;
    }
}
