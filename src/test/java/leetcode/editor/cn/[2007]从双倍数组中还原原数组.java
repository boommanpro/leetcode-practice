package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

class SolutionTest2007 {
//一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有
//元素 随机打乱 。
//
// 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以
//任意 顺序返回。
//
//
//
// 示例 1：
//
// 输入：changed = [1,3,4,2,6,8]
//输出：[1,3,4]
//解释：一个可能的 original 数组为 [1,3,4] :
//- 将 1 乘以 2 ，得到 1 * 2 = 2 。
//- 将 3 乘以 2 ，得到 3 * 2 = 6 。
//- 将 4 乘以 2 ，得到 4 * 2 = 8 。
//其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
//
//
// 示例 2：
//
// 输入：changed = [6,3,0,1]
//输出：[]
//解释：changed 不是一个双倍数组。
//
//
// 示例 3：
//
// 输入：changed = [1]
//输出：[]
//解释：changed 不是一个双倍数组。
//
//
//
//
// 提示：
//
//
// 1 <= changed.length <= 10⁵
// 0 <= changed[i] <= 10⁵
//
//
// Related Topics贪心 | 数组 | 哈希表 | 排序
//
// 👍 58, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOriginalArray(int[] changed) {
            int n = changed.length;
            if (n == 0 || (n & 1) != 0) {
                return new int[0];
            }
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i : changed) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            int[] res = new int[n / 2];
            int p = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer key = entry.getKey();
                Integer cnt = entry.getValue();
                if (cnt == 0) {
                    continue;
                }
                if (key == 0) {
                    if (cnt % 2 != 0) {
                        return new int[0];
                    }
                    cnt = cnt / 2;
                    for (Integer i = 0; i < cnt; i++) {
                        res[p + i] = key;
                    }
                    p += cnt;
                    continue;
                }
                Integer next = map.getOrDefault(key * 2, 0);
                if (next < cnt) {
                    return new int[0];
                }
                for (Integer i = 0; i < cnt; i++) {
                    res[p + i] = key;
                }
                p += cnt;
                map.put(key * 2, next - cnt);
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
            Assert.assertEquals("[1, 3, 4]", Arrays.toString(solution.findOriginalArray(new int[]{1, 3, 4, 2, 6, 8})));
            Assert.assertEquals("[0, 0]", Arrays.toString(solution.findOriginalArray(new int[]{0, 0, 0, 0})));
        }

    }
}
