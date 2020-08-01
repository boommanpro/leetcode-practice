package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            int size = nums.size();
            Map<Integer, List<Integer>> indices = new HashMap<Integer, List<Integer>>();
            int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                for (int x : nums.get(i)) {
                    List<Integer> list = indices.getOrDefault(x, new ArrayList<Integer>());
                    list.add(i);
                    indices.put(x, list);
                    xMin = Math.min(xMin, x);
                    xMax = Math.max(xMax, x);
                }
            }

            int[] freq = new int[size];
            int inside = 0;
            int left = xMin, right = xMin - 1;
            int bestLeft = xMin, bestRight = xMax;

            while (right < xMax) {
                right++;
                if (indices.containsKey(right)) {
                    for (int x : indices.get(right)) {
                        freq[x]++;
                        if (freq[x] == 1) {
                            inside++;
                        }
                    }
                    while (inside == size) {
                        if (right - left < bestRight - bestLeft) {
                            bestLeft = left;
                            bestRight = right;
                        }
                        if (indices.containsKey(left)) {
                            for (int x : indices.get(left)) {
                                freq[x]--;
                                if (freq[x] == 0) {
                                    inside--;
                                }
                            }
                        }
                        left++;
                    }
                }
            }

            return new int[]{bestLeft, bestRight};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }
    }
}