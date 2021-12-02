package com.rose.string;

/**
 * Created on 2021/11/4 17:46
 *
 * @author Rose
 *                              反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Test1 {

    public static void main(String[] args) {
        char[] s = {'1','2'};
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++){
            char c = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = c;
        }
    }
}
