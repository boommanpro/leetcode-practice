package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionTest3072 {
//给你一个下标从 1 开始、长度为 n 的整数数组 nums 。
//
// 现定义函数 greaterCount ，使得 greaterCount(arr, val) 返回数组 arr 中 严格大于 val 的元素数量。
//
// 你需要使用 n 次操作，将 nums 的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二
//次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：
//
//
// 如果 greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]) ，将 nums[i] 追加到
//arr1 。
// 如果 greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]) ，将 nums[i] 追加到
//arr2 。
// 如果 greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]) ，将 nums[i] 追加到元
//素数量较少的数组中。
// 如果仍然相等，那么将 nums[i] 追加到 arr1 。
//
//
// 连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么
//result = [1,2,3,4,5,6] 。
//
// 返回整数数组 result 。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,1,3,3]
//输出：[2,3,1,3]
//解释：在前两次操作后，arr1 = [2] ，arr2 = [1] 。
//在第 3 次操作中，两个数组中大于 3 的元素数量都是零，并且长度相等，因此，将 nums[3] 追加到 arr1 。
//在第 4 次操作中，两个数组中大于 3 的元素数量都是零，但 arr2 的长度较小，因此，将 nums[4] 追加到 arr2 。
//在 4 次操作后，arr1 = [2,3] ，arr2 = [1,3] 。
//因此，连接形成的数组 result 是 [2,3,1,3] 。
//
//
// 示例 2：
//
//
//输入：nums = [5,14,3,1,2]
//输出：[5,3,1,2,14]
//解释：在前两次操作后，arr1 = [5] ，arr2 = [14] 。
//在第 3 次操作中，两个数组中大于 3 的元素数量都是一，并且长度相等，因此，将 nums[3] 追加到 arr1 。
//在第 4 次操作中，arr1 中大于 1 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[4] 追加到 arr1 。
//在第 5 次操作中，arr1 中大于 2 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[5] 追加到 arr1 。
//在 5 次操作后，arr1 = [5,3,1,2] ，arr2 = [14] 。
//因此，连接形成的数组 result 是 [5,3,1,2,14] 。
//
//
// 示例 3：
//
//
//输入：nums = [3,3,3,3]
//输出：[3,3,3,3]
//解释：在 4 次操作后，arr1 = [3,3] ，arr2 = [3,3] 。
//因此，连接形成的数组 result 是 [3,3,3,3] 。
//
//
//
//
// 提示：
//
//
// 3 <= n <= 10⁵
// 1 <= nums[i] <= 10⁹
//
//
// Related Topics树状数组 | 线段树 | 数组 | 模拟
//
// 👍 7, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public class SegmentTree {
            long[] data;
            long[] maxTree;
            long[] minTree;
            long[] sumTree;

            public SegmentTree(long[] arr) {
                int n = arr.length;
                data = new long[n];
                System.arraycopy(arr, 0, data, 0, n);
                maxTree = new long[4 * n];
                minTree = new long[4 * n];
                sumTree = new long[4 * n];
                build(0, 0, n - 1);
            }

            public SegmentTree(int[] arr) {
                int n = arr.length;
                data = new long[n];
                for (int i = 0; i < n; i++) {
                    data[i] = arr[i];
                }
                maxTree = new long[4 * n];
                minTree = new long[4 * n];
                sumTree = new long[4 * n];
                build(0, 0, n - 1);
            }


            private void build(int treeIdx, int l, int r) {
                if (l == r) {
                    maxTree[treeIdx] = data[l];
                    minTree[treeIdx] = data[l];
                    sumTree[treeIdx] = data[l];
                    return;
                }
                int mid = ((r - l) >> 1) + l;
                int left = treeIdx * 2 + 1;
                int right = treeIdx * 2 + 2;
                build(left, l, mid);
                build(right, mid + 1, r);
                maxTree[treeIdx] = Math.max(maxTree[left], maxTree[right]);
                minTree[treeIdx] = Math.min(minTree[left], minTree[right]);
                sumTree[treeIdx] = sumTree[left] + sumTree[right];
            }


            public long queryMax(int l, int r) {
                return queryMax(0, 0, data.length - 1, l, r);
            }

            private long queryMax(int treeIdx, int l, int r, int queryL, int queryR) {
                if (l == queryL && r == queryR) {
                    return maxTree[treeIdx];
                }
                int mid = ((r - l) >> 1) + l;
                int left = treeIdx * 2 + 1;
                int right = treeIdx * 2 + 2;
                if (queryL >= mid + 1) {
                    return queryMax(right, mid + 1, r, queryL, queryR);
                } else if (queryR <= mid) {
                    return queryMax(left, l, mid, queryL, queryR);
                }

                long leftResult = queryMax(left, l, mid, queryL, mid);
                long rightResult = queryMax(right, mid + 1, r, mid + 1, queryR);
                return Math.max(leftResult, rightResult);
            }

            public long queryMin(int l, int r) {
                return queryMin(0, 0, data.length - 1, l, r);
            }

            private long queryMin(int treeIdx, int l, int r, int queryL, int queryR) {
                if (l == queryL && r == queryR) {
                    return minTree[treeIdx];
                }
                int mid = ((r - l) >> 1) + l;
                int left = treeIdx * 2 + 1;
                int right = treeIdx * 2 + 2;
                if (queryL >= mid + 1) {
                    return queryMin(right, mid + 1, r, queryL, queryR);
                } else if (queryR <= mid) {
                    return queryMin(left, l, mid, queryL, queryR);
                }

                long leftResult = queryMin(left, l, mid, queryL, mid);
                long rightResult = queryMin(right, mid + 1, r, mid + 1, queryR);
                return Math.min(leftResult, rightResult);
            }

            public long querySum(int l, int r) {
                return querySum(0, 0, data.length - 1, l, r);
            }

            private long querySum(int treeIdx, int l, int r, int queryL, int queryR) {
                if (l == queryL && r == queryR) {
                    return sumTree[treeIdx];
                }
                int mid = ((r - l) >> 1) + l;
                int left = treeIdx * 2 + 1;
                int right = treeIdx * 2 + 2;
                if (queryL >= mid + 1) {
                    return querySum(right, mid + 1, r, queryL, queryR);
                } else if (queryR <= mid) {
                    return querySum(left, l, mid, queryL, queryR);
                }

                long leftResult = querySum(left, l, mid, queryL, mid);
                long rightResult = querySum(right, mid + 1, r, mid + 1, queryR);
                return leftResult + rightResult;
            }

            public void update(int idx, long v) {
                data[idx] = v;
                update(0, 0, data.length - 1, idx, v);
            }

            public long get(int idx){
                return data[idx];
            }

            private void update(int treeIdx, int l, int r, int idx, long v) {
                if (l == r) {
                    maxTree[treeIdx] = v;
                    minTree[treeIdx] = v;
                    sumTree[treeIdx] = v;
                    return;
                }
                int mid = ((r - l) >> 1) + l;
                int left = treeIdx * 2 + 1;
                int right = treeIdx * 2 + 2;
                if (idx >= mid + 1) {
                    update(right, mid + 1, r, idx, v);
                } else {
                    update(left, l, mid, idx, v);
                }
                maxTree[treeIdx] = Math.max(maxTree[left], maxTree[right]);
                minTree[treeIdx] = Math.min(minTree[left], minTree[right]);
                sumTree[treeIdx] = sumTree[left] + sumTree[right];
            }
        }



        public int[] resultArray(int[] nums) {
            int n = nums.length;
            SegmentTree s1 = new SegmentTree(new int[n + 1]);
            SegmentTree s2 = new SegmentTree(new int[n + 1]);
            //离散化映射
            int[] sorted = Arrays.stream(nums).sorted().toArray();
            List<Integer> arr1 = new ArrayList<>();
            List<Integer> arr2 = new ArrayList<>();
            int v1 = Arrays.binarySearch(sorted, nums[0]) + 1;
            int v2 = Arrays.binarySearch(sorted, nums[1]) + 1;
            arr1.add(nums[0]);
            arr2.add(nums[1]);
            s1.update(v1, s1.get(v1) + 1);
            s2.update(v2, s2.get(v2) + 1);
            for (int i = 2; i < n; i++) {
                int v = Arrays.binarySearch(sorted, nums[i])+1;
                int a = (int) (arr1.size() - s1.querySum(1, v ));
                int b = (int) (arr2.size() - s2.querySum(1, v ));
                if (a > b || (a == b && arr1.size() <= arr2.size())) {
                    arr1.add(nums[i]);
                    s1.update(v, s1.get(v) + 1);
                }else {
                    arr2.add(nums[i]);
                    s2.update(v, s2.get(v) + 1);
                }
            }
            arr1.addAll(arr2);
            for (int i = 0; i < nums.length; i++) {
                nums[i] = arr1.get(i);
            }
            return nums;
        }

        private int greaterCount(List<Integer> arr1, int num) {
            int cnt = 0;
            for (Integer i : arr1) {
                if (i > num) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[2, 3, 1, 3]", Arrays.toString(solution.resultArray(new int[]{2, 1, 3, 3})));
            Assert.assertEquals("[5, 3, 1, 2, 14]", Arrays.toString(solution.resultArray(new int[]{5, 14, 3, 1, 2})));
            Assert.assertEquals("[3, 3, 3, 3]", Arrays.toString(solution.resultArray(new int[]{3, 3, 3, 3})));
        }

    }
}
