package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest3117 {
//给你两个数组 nums 和 andValues，长度分别为 n 和 m。
//
// 数组的 值 等于该数组的 最后一个 元素。
//
// 你需要将 nums 划分为 m 个 不相交的连续 子数组，对于第 iᵗʰ 个子数组 [li, ri]，子数组元素的按位AND运算结果等于
//andValues[i]，换句话说，对所有的 1 <= i <= m，nums[li] & nums[li + 1] & ... & nums[ri] ==
//andValues[i] ，其中 & 表示按位AND运算符。
//
// 返回将 nums 划分为 m 个子数组所能得到的可能的 最小 子数组 值 之和。如果无法完成这样的划分，则返回 -1 。
//
//
//
// 示例 1：
//
//
// 输入： nums = [1,4,3,3,2], andValues = [0,3,3,2]
//
//
// 输出： 12
//
// 解释：
//
// 唯一可能的划分方法为：
//
//
// [1,4] 因为 1 & 4 == 0
// [3] 因为单元素子数组的按位 AND 结果就是该元素本身
// [3] 因为单元素子数组的按位 AND 结果就是该元素本身
// [2] 因为单元素子数组的按位 AND 结果就是该元素本身
//
//
// 这些子数组的值之和为 4 + 3 + 3 + 2 = 12
//
// 示例 2：
//
//
// 输入： nums = [2,3,5,7,7,7,5], andValues = [0,7,5]
//
//
// 输出： 17
//
// 解释：
//
// 划分 nums 的三种方式为：
//
//
// [[2,3,5],[7,7,7],[5]] 其中子数组的值之和为 5 + 7 + 5 = 17
// [[2,3,5,7],[7,7],[5]] 其中子数组的值之和为 7 + 7 + 5 = 19
// [[2,3,5,7,7],[7],[5]] 其中子数组的值之和为 7 + 7 + 5 = 19
//
//
// 子数组值之和的最小可能值为 17
//
// 示例 3：
//
//
// 输入： nums = [1,2,3,4], andValues = [2]
//
//
// 输出： -1
//
// 解释：
//
// 整个数组 nums 的按位 AND 结果为 0。由于无法将 nums 划分为单个子数组使得元素的按位 AND 结果为 2，因此返回 -1。
//
//
//
// 提示：
//
//
// 1 <= n == nums.length <= 10⁴
// 1 <= m == andValues.length <= min(n, 10)
// 1 <= nums[i] < 10⁵
// 0 <= andValues[j] < 10⁵
//
//
// Related Topics位运算 | 线段树 | 队列 | 数组 | 二分查找 | 动态规划
//
// 👍 9, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        private static final int INF = Integer.MAX_VALUE >> 1;

        public int minimumValueSum(int[] nums, int[] andValues) {
            Map<Tuple, Integer> memo = new HashMap<>();
            int ans = dfs(-1, 0, 0, nums, andValues, nums.length, andValues.length, memo);
            return ans == INF ? -1 : ans;
        }

        private int dfs(int and, int i, int j, int[] nums, int[] andValues, int n, int m, Map<Tuple, Integer> memo) {
            if (n - i < m - j) {
                return INF;
            }
            if (j == m) {
                return i == n ? 0 : INF;
            }

            Tuple key = new Tuple(and, i, j);
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
            and &= nums[i];
            int ans = dfs(and, i + 1, j, nums, andValues, n, m, memo);
            if (and == andValues[j]) {
                ans = Math.min(ans, nums[i] + dfs(-1, i + 1, j + 1, nums, andValues, n, m, memo));
            }
            memo.put(key, ans);
            return ans;
        }

        public static class Tuple implements Comparable<Tuple> {

            private final Object[] valueArray;

            private final List<Object> valueList;

            /**
             * @deprecated Will be removed in 1.4. The "size" parameter is of no use at
             * this level, so use the simpler Tuple(values) constructor instead.
             */


            public Tuple(final Object... values) {
                super();
                this.valueArray = values;
                this.valueList = Arrays.asList(values);
            }



            /**
             * <p>
             * Return the size of the tuple.
             * </p>
             *
             * @return the size of the tuple.
             */
            public int getSize() {
                return valueList.size();
            }


            /**
             * <p>
             * Get the value at a specific position in the tuple. This method
             * has to return object, so using it you will lose the type-safety you
             * get with the <tt>getValueX()</tt> methods.
             * </p>
             *
             * @param pos the position of the value to be retrieved.
             * @return the value
             */
            public final Object getValue(final int pos) {
                if (pos >= getSize()) {
                    throw new IllegalArgumentException("Cannot retrieve position " + pos + " in " + this.getClass().getSimpleName() + ". Positions for this class start with 0 and end with " + (getSize() - 1));
                }
                return this.valueArray[pos];
            }


            @Override
            public final String toString() {
                return this.valueList.toString();
            }


            public final boolean contains(final Object value) {
                for (final Object val : this.valueList) {
                    if (val == null) {
                        if (value == null) {
                            return true;
                        }
                    } else {
                        if (val.equals(value)) {
                            return true;
                        }
                    }
                }
                return false;
            }


            public final List<Object> toList() {
                return Collections.unmodifiableList(new ArrayList<Object>(this.valueList));
            }


            public final Object[] toArray() {
                return this.valueArray.clone();
            }


            @Override
            public final int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((this.valueList == null) ? 0 : this.valueList.hashCode());
                return result;
            }


            @Override
            public final boolean equals(final Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null) {
                    return false;
                }
                if (getClass() != obj.getClass()) {
                    return false;
                }
                final Tuple other = (Tuple) obj;
                return this.valueList.equals(other.valueList);
            }


            @SuppressWarnings({"rawtypes", "unchecked"})
            public int compareTo(final Tuple o) {

                final int tLen = this.valueArray.length;
                final Object[] oValues = o.valueArray;
                final int oLen = oValues.length;

                for (int i = 0; i < tLen && i < oLen; i++) {
                    final Comparable tElement = (Comparable) this.valueArray[i];
                    final Comparable oElement = (Comparable) oValues[i];

                    final int comparison = tElement.compareTo(oElement);
                    if (comparison != 0) {
                        return comparison;
                    }

                }
                return (Integer.valueOf(tLen)).compareTo(Integer.valueOf(oLen));

            }


        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(12, solution.minimumValueSum(new int[]{1, 4, 3, 3, 2}, new int[]{0, 3, 3, 2}));
            Assert.assertEquals(17, solution.minimumValueSum(new int[]{2, 3, 5, 7, 7, 7, 5}, new int[]{0, 7, 5}));
            Assert.assertEquals(-1, solution.minimumValueSum(new int[]{1, 2, 3, 4}, new int[]{2}));
            Assert.assertEquals(9, solution.minimumValueSum(new int[]{4, 8, 9}, new int[]{0}));
            Assert.assertEquals(17, solution.minimumValueSum(new int[]{2, 3, 5, 7, 7, 7, 5}, new int[]{0, 7, 5}));
        }

    }
}
