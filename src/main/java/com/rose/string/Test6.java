package com.rose.string;

/**
 * Created on 2021/12/14 13:37
 *
 * @author Lakers
 *
 * 字符串转换整数 (atoi)
 */
public class Test6 {

    public static int myAtoi(String str) {
        //去掉前后的空格
        str = str.trim();
        //如果为空，直接返回0
        if (str.length() == 0) {
            return 0;
        }

        //遍历字符串中字符的位置
        int index = 0;
        //最终结果
        int res = 0;
        //符号，1是正数，-1是负数，默认为正数
        int sign = 1;
        int length = str.length();
        //判断符号
        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            sign = str.charAt(index++) == '+' ? 1 : -1;
        }
        for (; index < length; ++index) {
            //取出字符串中字符，然后转化为数字
            int digit = str.charAt(index) - '0';
            //按照题中的要求，读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
            //字符串的其余部分将被忽略。如果读取了非数字，后面的都要忽略
            if (digit < 0 || digit > 9) {
                break;
            }
            //越界处理
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                res = res * 10 + digit;
            }
        }
        return sign * res;

    }
}
