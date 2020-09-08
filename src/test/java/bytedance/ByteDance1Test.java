package bytedance;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;

/**
 * @author wangqimeng
 * @date 2020/9/6 16:10
 */
public class ByteDance1Test {


    // 1.程序随机生成100个长度在100到200位的长整数
    // 2.对这些长整数累加求和，并输出sum

    public static
    class Solution {

        Random uniqueRandom = new Random();


        public String generatorBitNumber(int bit) {
            if (bit <= 0) {
                return "";
            }
            char[] res = new char[bit];
            res[0] = (char) (uniqueRandom.nextInt(9) + 1 + '0');

            //除第一位是 1-9外,其余是0-9

            for (int i = 1; i < bit; i++) {
                res[i] = (char) (uniqueRandom.nextInt(10) + '0');
            }
            return new String(res);
        }

        public String generatorBitNumber(int start, int end) {
            return generatorBitNumber(generatorBit(start, end));
        }

        public int generatorBit(int start, int end) {
            return uniqueRandom.nextInt(end - start) + start;
        }

        public String sumLongNum(String[] nums) {
            StringBuilder res = new StringBuilder();
            OptionalInt maxOpt = Arrays.stream(nums).map(String::length).mapToInt(Integer::intValue).max();
            if (!maxOpt.isPresent()) {
                return "0";
            }
            int len = maxOpt.getAsInt();
            int carry = 0;
            for (int i = 0; i < len; i++) {
                int sum = carry;
                for (String num : nums) {
                    int currLen = num.length();
                    int v = currLen - i - 1;
                    if (currLen - i - 1 < 0) {
                        continue;
                    }
                    sum += num.charAt(v) - '0';
                }
                carry = sum / 10;
                res.append(sum % 10);
            }
            //carry处理
            while (carry != 0) {
                res.append(carry % 10);
                carry = carry / 10;
            }

            return res.reverse().toString();
        }

        public String[] generatorRandomNums(int N, int start, int end) {
            String[] result = new String[N];
            for (int i = 0; i < N; i++) {
                result[i] = generatorBitNumber(start, end);
            }
            return result;
        }
    }

    public static class TestClass {
        int N = 100;
        int lenStart = 100;
        int lenEnd = 200;
        private Solution solution;

        @Before
        public void init() {
            solution = new Solution();
        }

        @Test
        public void generatorBitTest() {
            for (int i = 0; i < 1000; i++) {
                int bit = solution.generatorBit(lenStart, lenEnd);
                Assert.assertTrue(bit >= lenStart && bit <= lenEnd);
            }
        }

        @Test
        public void generatorBitNumberTest() {
            for (int i = 0; i < 1000; i++) {
                String temp = solution.generatorBitNumber(lenStart, lenEnd);
                Assert.assertTrue(temp.length() >= lenStart && temp.length() <= lenEnd);
                Assert.assertTrue(temp.charAt(0) != '0');
            }
        }


        @Test
        public void defaultSolutionTest() {
            String[] nums = solution.generatorRandomNums(N, lenStart, lenEnd);
            Assert.assertEquals(calcSum(nums), solution.sumLongNum(nums));
        }

        private String calcSum(String[] nums) {
            BigDecimal result = Arrays.stream(nums)
                    .map(BigDecimal::new)
                    .reduce(BigDecimal::add)
                    .orElseThrow(() -> new RuntimeException("计算错误"));
            return result.toString();
        }
    }

}
