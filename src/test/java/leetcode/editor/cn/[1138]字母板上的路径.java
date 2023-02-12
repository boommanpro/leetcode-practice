package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest1138 {
//我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。 
//
// 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。 
//
// 
//
// 我们可以按下面的指令规则行动： 
//
// 
// 如果方格存在，'U' 意味着将我们的位置上移一行； 
// 如果方格存在，'D' 意味着将我们的位置下移一行； 
// 如果方格存在，'L' 意味着将我们的位置左移一列； 
// 如果方格存在，'R' 意味着将我们的位置右移一列； 
// '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。 
// 
//
// （注意，字母板上只存在有字母的位置。） 
//
// 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = "leet"
//输出："DDR!UURRR!!DDD!"
// 
//
// 示例 2： 
//
// 
//输入：target = "code"
//输出："RR!DDRR!UUL!R!"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target.length <= 100 
// target 仅含有小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 👍 74 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final String[] board = new String[]{
                "abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"
        };

        public String alphabetBoardPath(String target) {
            Map<Character, int[]> map = new HashMap<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length(); j++) {
                    map.put(board[i].charAt(j), new int[]{i, j});
                }
            }
            StringBuilder sb = new StringBuilder();
            int[] start = new int[]{0, 0};
            for (char c : target.toCharArray()) {
                int[] next = map.get(c);
                if (start[0] == next[0] && start[1] == next[1]) {
                    sb.append('!');
                    continue;
                }
                sb.append(calcGap(start, next));
                sb.append('!');
                start = next;
            }
            return sb.toString();
        }

        public String calcGap(int[] start, int[] next) {
            StringBuilder sb = new StringBuilder();
            int i = start[0];
            int j = start[1];
            int x = next[0];
            int y = next[1];
            if (i == 5 && j == 0) {
                i--;
                sb.append('U');
            }


            int col = j - y;
            char colChar = col >= 0 ? 'L' : 'R';
            col = col >= 0 ? col : -col;
            while (col > 0) {
                sb.append(colChar);
                col--;
            }


            int row = i - x;
            char rowChar = row >= 0 ? 'U' : 'D';
            row = row >= 0 ? row : -row;
            while (row > 0) {
                sb.append(rowChar);
                row--;
            }


            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("DDDDD!URRRUUUU!LLLDDDDD!", solution.alphabetBoardPath("zdz"));
        }

    }
}