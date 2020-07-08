package acwing;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

/**
 * link: https://www.acwing.com/problem/content/2/
 */
class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        // 物品的数量为N
        int n = reader.nextInt();
        // 背包的容量为V
        int v = reader.nextInt();
        //物品列表
        int[][] goodsList = new int[n][2];
        for (int i = 1; i <= n; i++) {
            // 接下来有 N 行，每行有两个整数:v[i],w[i]，用空格隔开，分别表示第i件物品的体积和价值
            goodsList[i - 1][0] = reader.nextInt();
            goodsList[i - 1][1] = reader.nextInt();
        }
        reader.close();

        Solution solution = new Solution();
        System.out.println(solution.calcMaxValue(n, v, goodsList));

    }

    public static class Solution {

        public int calcMaxValue(int n, int v, int[][] goodsList) {
            //n个物品 v的体积
            int[][] f = new int[n + 1][v + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= v; j++) {
                    f[i][j] = f[i - 1][j];
                    int[] goods = goodsList[i - 1];
                    if (goods[0] <= j) {
                        f[i][j] = Math.max(f[i][j], f[i - 1][j - goods[0]] + goods[1]);
                    }
                }
            }
            return f[n][v];
        }

    }

    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(8, solution.calcMaxValue(4, 5, new int[][]{{1, 2}, {2, 4}, {3, 4}, {4, 5}}));
        }
    }

}