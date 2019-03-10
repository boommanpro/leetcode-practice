package array;

import org.junit.Test;

import java.util.Arrays;

public class Leetcode343Test {
    //    Example 1:
    //
    //    Input: ["h","e","l","l","o"]
    //    Output: ["o","l","l","e","h"]
    //    Example 2:
    //
    //    Input: ["H","a","n","n","a","h"]
    //    Output: ["h","a","n","n","a","H"]

    @Test
    public void leetcode343Test(){
        char[] input = {'H', 'e', 'l', 'l', 'o'};
        reverseString(input);
        System.out.println(String.format("reverse string result:%s", Arrays.toString(input)));
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            if (s[left] != s[right]) {
                swap(s, left, right);
            }
            left++;
            right--;
        }
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
