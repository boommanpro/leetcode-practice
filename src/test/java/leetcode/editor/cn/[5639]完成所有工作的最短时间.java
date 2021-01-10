package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest5639 {
//给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。 
//
// 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你
//设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。 
//
// 返回分配方案中尽可能 最小 的 最大工作时间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：jobs = [3,2,3], k = 3
//输出：3
//解释：给每位工人分配一项工作，最大工作时间是 3 。
// 
//
// 示例 2： 
//
// 
//输入：jobs = [1,2,4,7,8], k = 2
//输出：11
//解释：按下述方式分配工作：
//1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
//2 号工人：4、7（工作时间 = 4 + 7 = 11）
//最大工作时间是 11 。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= jobs.length <= 12 
// 1 <= jobs[i] <= 107 
// 
// Related Topics 递归 回溯算法 
// 👍 2 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] mJobs = null;
        int mK = 0;
        int mTotal = 0;
        // cache for state
        int[] totalC = null;

        public int minimumTimeRequired(int[] jobs, int k) {
            int N = jobs.length;
            int count = 1 << N;
            mJobs = jobs;
            mK = k;
            totalC = new int[count];
            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                indexMap.put(1 << i, i);
            }
            for (int i = 1; i < count; i++) {
                int index = indexMap.get(i & -i);
                totalC[i] = totalC[(i & (i - 1))] + jobs[index];
            }
            int max = totalC[count - 1];
            int min = Math.max(Arrays.stream(jobs).sum() / k, Arrays.stream(jobs).max().getAsInt());
            return binarySearch(min, max);

        }

        private int binarySearch(int min, int max) {
            int l = min, r = max;
            while (l < r) {
                int mid = ((r - l) >> 1) + l;
                if (checkValid(mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }


        private boolean checkValid(int c) {
            int state = 1 << mJobs.length;
            int mask = state - 1;
            HashSet<Integer> set = new HashSet<>();
            set.add(0);
            for (int i = 0; i < mK; i++) {
                HashSet<Integer> set2 = new HashSet<>();
                for (int s : set) {
                    int nextStateP = ~s & mask;
                    for (int preState = nextStateP; preState > 0; preState = (preState - 1) & nextStateP) {
                        if (totalC[preState] <= c) {
                            int validState = s | preState;
                            if (validState == mask) {
                                return true;
                            }
                            set2.add(validState);
                        }
                    }
                }
                set = set2;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertEquals(11, solution.minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));
            Assert.assertEquals(3, solution.minimumTimeRequired(new int[]{3, 2, 3}, 3));
        }
    }
}