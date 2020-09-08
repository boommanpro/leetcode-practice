package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SolutionTest710 {
//给定一个包含 [0，n ) 中独特的整数的黑名单 B，写一个函数从 [ 0，n ) 中返回一个不在 B 中的随机整数。 
//
// 对它进行优化使其尽量少调用系统方法 Math.random() 。 
//
// 提示: 
//
// 
// 1 <= N <= 1000000000 
// 0 <= B.length < min(100000, N) 
// [0, N) 不包含 N，详细参见 interval notation 。 
// 
//
// 示例 1: 
//
// 
//输入: 
//["Solution","pick","pick","pick"]
//[[1,[]],[],[],[]]
//输出: [null,0,0,0]
// 
//
// 示例 2: 
//
// 
//输入: 
//["Solution","pick","pick","pick"]
//[[2,[]],[],[],[]]
//输出: [null,1,1,1]
// 
//
// 示例 3: 
//
// 
//输入: 
//["Solution","pick","pick","pick"]
//[[3,[1]],[],[],[]]
//Output: [null,0,0,2]
// 
//
// 示例 4: 
//
// 
//输入: 
//["Solution","pick","pick","pick"]
//[[4,[2]],[],[],[]]
//输出: [null,1,3,1]
// 
//
// 输入语法说明： 
//
// 输入是两个列表：调用成员函数名和调用的参数。Solution的构造函数有两个参数，N 和黑名单 B。pick 没有参数，输入参数是一个列表，即使参数为空，
//也会输入一个 [] 空列表。 
// Related Topics 排序 哈希表 二分查找 Random 
// 👍 42 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<Integer> randomList;

        int N;

        Random random = new Random();

        public Solution(int N, int[] blacklist) {
            Set<Integer> black = Arrays.stream(blacklist).boxed().collect(Collectors.toSet());
            randomList = IntStream.range(0, N).boxed().filter(i -> !black.contains(i)).collect(Collectors.toList());
            this.N = randomList.size();
        }

        public int pick() {
            return randomList.get(random.nextInt(N));
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(N, blacklist);
     * int param_1 = obj.pick();
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution1 = new Solution(1, new int[]{});
            Assert.assertEquals(0, solution1.pick());
            Assert.assertEquals(0, solution1.pick());
            Assert.assertEquals(0, solution1.pick());
        }
    }
}