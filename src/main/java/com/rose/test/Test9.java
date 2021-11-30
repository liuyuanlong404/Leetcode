package com.rose.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2021/10/11 10:55
 *
 * @author Rose
 */
public class Test9 {

    public static void main(String[] args) {
        System.out.println(extremeValue(10));
    }

    public static List<String> extremeValue(int n){
        int[] num = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] length = new int[]{6,2,5,5,4,5,6,3,7,6};

        List<String> list = new ArrayList<>(2);
        if (n % 2 == 0){
            StringBuffer stringBuffer = new StringBuffer("");
            int i = n / 2;
            while (i != 0){
                stringBuffer = stringBuffer.append("1");
                i--;
            }
            list.add(stringBuffer.toString());
        }else {

        }
        return list;
    }

}
