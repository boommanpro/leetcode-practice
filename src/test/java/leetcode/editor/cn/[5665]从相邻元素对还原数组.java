package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest5665 {
//存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。 
//
// 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui
// 和 vi 在 nums 中相邻。 
//
// 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i]
//, nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。 
//
// 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。 
//
// 
//
// 示例 1： 
//
// 
//输入：adjacentPairs = [[2,1],[3,4],[3,2]]
//输出：[1,2,3,4]
//解释：数组的所有相邻元素对都在 adjacentPairs 中。
//特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
// 
//
// 示例 2： 
//
// 
//输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
//输出：[-2,4,1,-3]
//解释：数组中可能存在负数。
//另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
// 
//
// 示例 3： 
//
// 
//输入：adjacentPairs = [[100000,-100000]]
//输出：[100000,-100000]
// 
//
// 
//
// 提示： 
//
// 
// nums.length == n 
// adjacentPairs.length == n - 1 
// adjacentPairs[i].length == 2 
// 2 <= n <= 105 
// -105 <= nums[i], ui, vi <= 105 
// 题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums 
// 
// Related Topics 贪心算法 
// 👍 0 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] restoreArray(int[][] adjacentPairs) {
            Map<Integer, Set<Integer>> links = new HashMap<>();
            for (int[] adjacentPair : adjacentPairs) {
                addLinks(links, adjacentPair);
            }
            Integer curr = findStart(links);
            List<Integer> ans = new ArrayList<>();
            ans.add(curr);
            Integer prefix = null;
            do {
                Integer temp = findNext(links, curr, prefix);
                prefix = curr;
                curr = temp;
            } while (curr != null && ans.add(curr));
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }

        private Integer findNext(Map<Integer, Set<Integer>> links, int curr, Integer prefix) {
            for (Integer next : links.get(curr)) {
                if (!next.equals(prefix)) {
                    return next;
                }
            }
            return null;
        }

        private int findStart(Map<Integer, Set<Integer>> links) {
            for (Map.Entry<Integer, Set<Integer>> entry : links.entrySet()) {
                if (entry.getValue().size() == 1) {
                    return entry.getKey();
                }
            }
            throw new NoSuchElementException();
        }

        private void addLinks(Map<Integer, Set<Integer>> links, int[] pair) {
            links.compute(pair[0], (integer, set) -> {
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(pair[1]);
                return set;
            });
            links.compute(pair[1], (integer, set) -> {
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(pair[0]);
                return set;
            });
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[1, 2, 3, 4]", Arrays.toString(solution.restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}})));
            Assert.assertEquals("[-3, 1, 4, -2]", Arrays.toString(solution.restoreArray(new int[][]{{4, -2}, {1, 4}, {-3, 1}})));
        }
    }
}