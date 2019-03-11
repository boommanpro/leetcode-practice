package hashTable;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode36Test {
    @Test
    public void leetcode36Test() {


        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        boolean validSudoku = isValidSudoku(board);

        System.out.println(String.format("result:%s", validSudoku));
    }

    public boolean isValidSudoku(char[][] board) {

        int[] count;

        //判断行

        for (int i = 0; i < 9; i++) {
            count = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    count[board[i][j] - '1']++;
                    if (count[board[i][j] - '1'] > 1) {
                        return false;
                    }
                }
            }
        }

        //判断列
        for (int i = 0; i < 9; i++) {
            count = new int[9];
            for (int j = 0; j < 9; j++) {

                if (board[j][i] != '.') {
                    count[board[j][i] - '1']++;
                    if (count[board[j][i] - '1'] > 1) {
                        return false;
                    }
                }

            }
        }


        //判断3*3 *9 宫格
        int x = 3;
        int y = 3;
        while (y < 10) {
            while (x < 10) {

                count = new int[9];
                for (int i = x - 3; i < x; i++) {
                    for (int j = y - 3; j < y; j++) {
                        if (board[i][j] != '.') {
                            count[board[i][j] - '1']++;
                            if (count[board[i][j] - '1'] > 1) {
                                return false;
                            }
                        }
                    }
                }
                x += 3;
            }
            x = 3;
            y += 3;
        }

        return true;
    }
}
