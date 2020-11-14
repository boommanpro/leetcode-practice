package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

class SolutionTest1122 {
//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
// 👍 113 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            Set<Integer> dict = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
            // arr1数据分两部分 1. arr2中存在的需要排序的部分 2.在arr2中不存在的 按照升序
            Map<Integer, Integer> countMap = new HashMap<>();
            List<Integer> surplus = new ArrayList<>();
            Arrays.stream(arr1).forEach(value -> {
                if (dict.contains(value)) {
                    countMap.put(value, countMap.getOrDefault(value, 0) + 1);
                } else {
                    surplus.add(value);
                }
            });
            int i = 0;
            for (int v : arr2) {
                int count = countMap.get(v);
                while (count > 0) {
                    arr1[i] = v;
                    i++;
                    count--;
                }
            }
            Collections.sort(surplus);
            for (Integer v : surplus) {
                arr1[i] = v;
                i++;
            }
            return arr1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19]", Arrays.toString(solution.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
            Assert.assertEquals("[22, 28, 8, 6, 17, 44]", Arrays.toString(solution.relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6})));
        }
    }
}