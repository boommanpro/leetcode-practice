package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest546 {
//给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。 
//你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分
//。 
//当你将所有盒子都去掉之后，求你能获得的最大积分和。 
//
// 
//
// 示例： 
//
// 输入：boxes = [1,3,2,2,2,3,4,3,1]
//输出：23
//解释：
//[1, 3, 2, 2, 2, 3, 4, 3, 1] 
//----> [1, 3, 3, 4, 3, 1] (3*3=9 分) 
//----> [1, 3, 3, 3, 1] (1*1=1 分) 
//----> [1, 1] (3*3=9 分) 
//----> [] (2*2=4 分)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= boxes.length <= 100 
// 1 <= boxes[i] <= 100 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 159 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int score = 0;

        public int removeBoxes(int[] boxes) {
            score = 0;
            if (boxes == null || boxes.length == 0) {
                return 0;
            }
            List<Integer> selectPath = Arrays.stream(boxes).boxed().collect(Collectors.toList());
            backtracking(selectPath, 0);
            return score;
        }

        private void backtracking(List<Integer> selectPath, int curr) {
            if (selectPath.size() == 0) {
                score = Math.max(curr, score);
                return;
            }
            int n = selectPath.size();
            for (int i = 0; i < n; i++) {
                Sequence sequence = getSequence(selectPath, i);
                i = sequence.end;
                //删除
                delete(selectPath, sequence);
                backtracking(selectPath, curr + sequence.length * sequence.length);
                //恢复
                recovery(selectPath, sequence);
            }
        }

        private void recovery(List<Integer> selectPath, Sequence sequence) {
            int len = sequence.length;
            int start = sequence.start;
            int value = sequence.value;
            while (len > 0) {
                selectPath.add(start, value);
                len--;
            }
        }

        private void delete(List<Integer> selectPath, Sequence sequence) {
            int start = sequence.start;
            int len = sequence.length;
            while (len > 0) {
                selectPath.remove(start);
                len--;
            }
        }

        private Sequence getSequence(List<Integer> selectPath, int start) {
            int n = selectPath.size();
            int end = start;
            for (int i = start + 1; i < n; i++) {
                if (!selectPath.get(i).equals(selectPath.get(start))) {
                    break;
                }
                end = i;
            }
            return new Sequence(start, end, selectPath.get(start));
        }

        public class Sequence {

            int start;

            int end;

            int length;

            int value;

            public Sequence(int start, int end, int value) {
                this.start = start;
                this.end = end;
                this.value = value;
                this.length = end - start + 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(23, solution.removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}));
            Assert.assertEquals(1, solution.removeBoxes(new int[]{3, 8, 8, 5, 5, 3, 9, 2, 4, 4, 6, 5, 8, 4, 8, 6, 9, 6, 2, 8, 6, 4, 1, 9, 5, 3, 10, 5, 3, 3, 9, 8, 8, 6, 5, 3, 7, 4, 9, 6, 3, 9, 4, 3, 5, 10, 7, 6, 10, 7}));
        }
    }
}