package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest2336 {
//现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...] 。
//
// 实现 SmallestInfiniteSet 类：
//
//
// SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
// int popSmallest() 移除 并返回该无限集中的最小整数。
// void addBack(int num) 如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集最后。
//
//
//
//
// 示例：
//
//
//输入
//["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest",
//"popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
//[[], [2], [], [], [], [1], [], [], []]
//输出
//[null, null, 1, 2, 3, null, 1, 4, 5]
//
//解释
//SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
//smallestInfiniteSet.addBack(2);    // 2 已经在集合中，所以不做任何变更。
//smallestInfiniteSet.popSmallest(); // 返回 1 ，因为 1 是最小的整数，并将其从集合中移除。
//smallestInfiniteSet.popSmallest(); // 返回 2 ，并将其从集合中移除。
//smallestInfiniteSet.popSmallest(); // 返回 3 ，并将其从集合中移除。
//smallestInfiniteSet.addBack(1);    // 将 1 添加到该集合中。
//smallestInfiniteSet.popSmallest(); // 返回 1 ，因为 1 在上一步中被添加到集合中，
//                                   // 且 1 是最小的整数，并将其从集合中移除。
//smallestInfiniteSet.popSmallest(); // 返回 4 ，并将其从集合中移除。
//smallestInfiniteSet.popSmallest(); // 返回 5 ，并将其从集合中移除。
//
//
//
// 提示：
//
//
// 1 <= num <= 1000
// 最多调用 popSmallest 和 addBack 方法 共计 1000 次
//
//
// Related Topics设计 | 哈希表 | 堆（优先队列）
//
// 👍 66, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class SmallestInfiniteSet {

        boolean[] prefix = new boolean[1001];
        int curr;

        public SmallestInfiniteSet() {
            Arrays.fill(prefix, true);
            curr = 1;
        }

        public int popSmallest() {
            int temp = curr;
            curr++;
            while (curr < 1001 && !prefix[curr]) {
                curr++;
            }
            prefix[temp] = false;
            return temp;
        }

        public void addBack(int num) {
            if (prefix[num]) {
                return;
            }
            if (num < curr) {
                curr = num;
            }
            prefix[num] = true;
        }
    }

    /**
     * Your SmallestInfiniteSet object will be instantiated and called as such:
     * SmallestInfiniteSet obj = new SmallestInfiniteSet();
     * int param_1 = obj.popSmallest();
     * obj.addBack(num);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
            smallestInfiniteSet.addBack(2);    // 2 已经在集合中，所以不做任何变更。
            Assert.assertEquals(1, smallestInfiniteSet.popSmallest()); // 返回 1 ，因为 1 是最小的整数，并将其从集合中移除。
            Assert.assertEquals(2, smallestInfiniteSet.popSmallest());  // 返回 2 ，并将其从集合中移除。
            Assert.assertEquals(3, smallestInfiniteSet.popSmallest()); // 返回 3 ，并将其从集合中移除。
            smallestInfiniteSet.addBack(1);    // 将 1 添加到该集合中。
            Assert.assertEquals(1, smallestInfiniteSet.popSmallest()); // 返回 1 ，因为 1 在上一步中被添加到集合中，
            // 且 1 是最小的整数，并将其从集合中移除。
            smallestInfiniteSet.popSmallest(); // 返回 4 ，并将其从集合中移除。
            Assert.assertEquals(5, smallestInfiniteSet.popSmallest()); // 返回 5 ，并将其从集合中移除。

            smallestInfiniteSet = new SmallestInfiniteSet();
            Assert.assertEquals(1, smallestInfiniteSet.popSmallest()); // 返回 1 ，因为 1 是最小的整数，并将其从集合中移除。
            smallestInfiniteSet.addBack(1);    // 2 已经在集合中，所以不做任何变更。
            Assert.assertEquals(1, smallestInfiniteSet.popSmallest());  // 返回 2 ，并将其从集合中移除。
            Assert.assertEquals(2, smallestInfiniteSet.popSmallest()); // 返回 3 ，并将其从集合中移除。
            Assert.assertEquals(3, smallestInfiniteSet.popSmallest()); // 返回 1 ，因为 1 在上一步中被添加到集合中，
            smallestInfiniteSet.addBack(2);    // 将 1 添加到该集合中。
            smallestInfiniteSet.addBack(3);    // 将 1 添加到该集合中。
            // 且 1 是最小的整数，并将其从集合中移除。
            Assert.assertEquals(2, smallestInfiniteSet.popSmallest()); // 返回 5 ，并将其从集合中移除。
            Assert.assertEquals(3, smallestInfiniteSet.popSmallest()); // 返回 5 ，并将其从集合中移除。
        }

    }
}
