package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题17_18 {
//假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。 
//
// 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。 
//
// 示例 1: 
//
// 输入:
//big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
//small = [1,5,9]
//输出: [7,10] 
//
// 示例 2: 
//
// 输入:
//big = [1,2,3]
//small = [4]
//输出: [] 
//
// 提示： 
//
// 
// big.length <= 100000 
// 1 <= small.length <= 100000 
// 
// Related Topics Sliding Window 
// 👍 22 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] shortestSeq(int[] big, int[] small) {
            int minLen = Integer.MAX_VALUE;
            int ans[] = new int[]{-1, -1};
            Map<Integer, Integer> window = new HashMap<>();
            Set<Integer> keys = Arrays.stream(small).boxed().collect(Collectors.toSet());
            int currLen = 0;
            int windowLen = small.length;
            for (int l = 0, r = 0; r < big.length; r++) {
                int curr = big[r];
                if (keys.contains(curr)) {
                    if (window.get(curr) == null || window.get(curr) == 0) {
                        currLen++;
                    }
                    window.put(curr, window.getOrDefault(curr, 0) + 1);
                    while (currLen > windowLen) {
                        if (keys.contains(big[l])) {
                            window.put(big[l], window.get(big[l]) - 1);
                            if (window.get(big[l]) == 0) {
                                currLen--;
                            }
                        }
                        l++;
                    }
                }
                if (currLen == windowLen) {
                    while (!keys.contains(big[l]) || window.get(big[l]) > 1) {
                        if (!keys.contains(big[l])) {
                            l++;
                            continue;
                        }
                        if (window.get(big[l]) > 1) {
                            window.put(big[l], window.get(big[l]) - 1);
                            l++;
                        }
                    }
                    if (r - l + 1 < minLen) {
                        minLen = r - l + 1;
                        ans[0] = l;
                        ans[1] = r;
                    }
                }
            }
            return minLen == Integer.MAX_VALUE ? new int[]{} : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[7, 10]", Arrays.toString(solution.shortestSeq(new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}, new int[]{1, 5, 9})));
            Assert.assertEquals("[]", Arrays.toString(solution.shortestSeq(new int[]{1, 2, 3}, new int[]{4})));
        }
    }
}