package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题_08_04 {
//幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
//  输入： nums = [1,2,3]
// 输出：
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 29 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> result;

        public List<List<Integer>> subsets(int[] nums) {
            result = new ArrayList<>();
            result.add(new ArrayList<>());
            for (int num : nums) {
                int n = result.size();
                for (int i = 0; i < n; i++) {
                    List<Integer> temp = new ArrayList<>(result.get(i));
                    temp.add(num);
                    result.add(temp);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]", solution.subsets(new int[]{1, 2, 3}).toString());
        }
    }
}