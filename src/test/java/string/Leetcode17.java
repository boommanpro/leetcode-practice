package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Leetcode17 {


    @Test
    public void leetcode17Test() throws Exception {
//        List<String> strings = letterCombinations("23");
//        System.out.println(strings);

        String s = numberCombine(2, 3);
        System.out.println(s);
    }

    public List<String> letterCombinations(String digits) {
        //把table上的数字对应的字母列出来，当输入为2是，digits[2]就是2所对应的"abc"
        String[] table = new String[]
                {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<String>();
        //index从0开始，即digits的第一个数字
        letterCombinations(list, digits, "", 0, table);
        return list;
    }

    private void letterCombinations(List<String> list, String digits,
                                    String curr, int index, String[] table) {
        //最后一层退出条件
        if (index == digits.length()) {
            if (curr.length() != 0) list.add(curr);
            return;
        }

        //找到数字对应的字符串
        String temp = table[digits.charAt(index) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            //每次循环把不同字符串加到当前curr之后
            String next = curr + temp.charAt(i);
            //进入下一层
            letterCombinations(list, digits, next, index + 1, table);
        }
    }


    public String numberCombine(int n1, int n2) throws Exception {


        String[] table = new String[]
                {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> result = new ArrayList<>();

        String first = table[n1];
        String second = table[n2];
        if (first.equals("") || second.equals("")) {
            return "null";
        }
        String temp;
        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                temp = "" + first.charAt(i) + second.charAt(j);
                result.add(temp);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s).append(",");
        }
        return   sb.toString().substring(0,sb.length()-1);


    }


}
