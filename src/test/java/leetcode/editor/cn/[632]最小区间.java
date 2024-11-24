package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

class SolutionTest632 {
//你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
//
// 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
//
// 示例 1:
//
//
//输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
//输出: [20,24]
//解释:
//列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
//列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
//列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
//
//
// 注意:
//
//
// 给定的列表可能包含重复元素，所以在这里升序表示 >= 。
// 1 <= k <= 3500
// -105 <= 元素的值 <= 105
// 对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。
//
// Related Topics 哈希表 双指针 字符串

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            int k = nums.size();
            Map<Integer, List<Integer>> index = new HashMap<>();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < k; i++) {
                for (Integer v : nums.get(i)) {
                    index.computeIfAbsent(v, p -> new ArrayList<>()).add(i);
                    min = Math.min(v, min);
                    max = Math.max(v, max);
                }
            }
            int[] res = new int[]{min, max};
            int[] freq = new int[k];
            int cnt = 0;
            int l = min, r = min - 1;
            while (r < max) {
                r++;
                if (index.containsKey(r)) {
                    for (int i : index.get(r)) {
                        freq[i]++;
                        if (freq[i] == 1) {
                            cnt++;
                        }
                    }
                    while (cnt == k) {
                        if (r - l < res[1] - res[0]) {
                            res[0] = l;
                            res[1] = r;
                        }

                        if (index.containsKey(l)) {
                            for (int i : index.get(l)) {
                                freq[i]--;
                                if (freq[i] == 0) {
                                    cnt--;
                                }
                            }

                        }
                        l++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();


            // 基本测试用例
            List<List<Integer>> input1 = Arrays.asList(
                    Arrays.asList(4, 10, 15, 24, 26),
                    Arrays.asList(0, 9, 12, 20),
                    Arrays.asList(5, 18, 22, 30)
            );
            assertArrayEquals(new int[]{20, 24}, solution.smallestRange(input1));

        }
    }
}
