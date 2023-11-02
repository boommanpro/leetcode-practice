package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SolutionTest2127 {
//一个公司准备组织一场会议，邀请名单上有 n 位员工。公司准备了一张 圆形 的桌子，可以坐下 任意数目 的员工。
//
// 员工编号为 0 到 n - 1 。每位员工都有一位 喜欢 的员工，每位员工 当且仅当 他被安排在喜欢员工的旁边，他才会参加会议。每位员工喜欢的员工 不会
//是他自己。
//
// 给你一个下标从 0 开始的整数数组 favorite ，其中 favorite[i] 表示第 i 位员工喜欢的员工。请你返回参加会议的 最多员工数目 。
//
//
//
//
// 示例 1：
//
//
//
// 输入：favorite = [2,2,1,2]
//输出：3
//解释：
//上图展示了公司邀请员工 0，1 和 2 参加会议以及他们在圆桌上的座位。
//没办法邀请所有员工参与会议，因为员工 2 没办法同时坐在 0，1 和 3 员工的旁边。
//注意，公司也可以邀请员工 1，2 和 3 参加会议。
//所以最多参加会议的员工数目为 3 。
//
//
// 示例 2：
//
// 输入：favorite = [1,2,0]
//输出：3
//解释：
//每个员工都至少是另一个员工喜欢的员工。所以公司邀请他们所有人参加会议的前提是所有人都参加了会议。
//座位安排同图 1 所示：
//- 员工 0 坐在员工 2 和 1 之间。
//- 员工 1 坐在员工 0 和 2 之间。
//- 员工 2 坐在员工 1 和 0 之间。
//参与会议的最多员工数目为 3 。
//
//
// 示例 3：
//
//
//
// 输入：favorite = [3,0,1,4,1]
//输出：4
//解释：
//上图展示了公司可以邀请员工 0，1，3 和 4 参加会议以及他们在圆桌上的座位。
//员工 2 无法参加，因为他喜欢的员工 0 旁边的座位已经被占领了。
//所以公司只能不邀请员工 2 。
//参加会议的最多员工数目为 4 。
//
//
//
//
// 提示：
//
//
// n == favorite.length
// 2 <= n <= 10⁵
// 0 <= favorite[i] <= n - 1
// favorite[i] != i
//
//
// Related Topics深度优先搜索 | 图 | 拓扑排序
//
// 👍 184, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 答案可能是什么？
         * 1. **所有**相互喜欢的人带舔狗坐在一起
         * 2. 凑成一个最大环
         *
         * 小环是相互喜欢最大舔狗单向长度
         * 大环是连环喜欢：int i; c=i;while(true){ c=f[c] if(c==i)=>环点 }
         */
        public int maximumInvitations(int[] f) {
            int n = f.length;
            int[] maxDp = new int[n];
            Arrays.fill(maxDp, 1);
            int[] inDegree = new int[n];

            // 计算入度
            for (int i = 0; i < n; i++) {
                inDegree[f[i]]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
            boolean[] used = new boolean[n];
            while (!queue.isEmpty()) {
                int x = queue.poll();
                used[x] = true;
                int y = f[x];
                inDegree[y]--;
                maxDp[y] = Math.max(maxDp[y], maxDp[x] + 1);
                if (inDegree[y] == 0) {
                    queue.add(y);
                }
            }

            int ring = 0;
            int total = 0;
            for (int i = 0; i < n; i++) {
                if (!used[i]) {
                    int y = f[i];
                    if (f[y] == i) {
                        total += maxDp[i] + maxDp[y];
                        used[i] = true;
                        used[y] = true;
                    } else {
                        int c = i;
                        int cnt = 0;
                        while (true) {
                            used[c] = true;
                            c = f[c];
                            cnt++;
                            if (c == i) {
                                break;
                            }
                        }
                        ring = Math.max(ring, cnt);
                    }
                }
            }

            return Math.max(ring, total);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(11, solution.maximumInvitations(new int[]{1, 0, 3, 2, 5, 6, 7, 4, 9, 8, 11, 10, 11, 12, 10}));
        }

    }
}
