package acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

/**
 * link: https://www.acwing.com/problem/content/4/
 */
class Acwing4_Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        // 物品的数量为N
        int n = reader.nextInt();
        // 背包的容量为V
        int v = reader.nextInt();
        //物品列表 0,1,2 分别是体积 价值 数量
        int[][] goodsList = new int[n][3];
        for (int i = 1; i <= n; i++) {
            // 接下来有 N 行，每行有两个整数:v[i],w[i]，用空格隔开，分别表示第i件物品的体积和价值
            goodsList[i - 1][0] = reader.nextInt();
            goodsList[i - 1][1] = reader.nextInt();
            goodsList[i - 1][2] = reader.nextInt();
        }
        reader.close();

        Solution solution = new Solution();
        System.out.println(solution.calcMaxValue(n, v, goodsList));

    }

    public static class Solution {

        /**
         * 一个物品有数量限制
         */
        public int calcMaxValue(int n, int v, int[][] goodsList) {
            //多重背包问题 -> 01背包问题
            List<int[]> temp = new ArrayList<>();
            for (int[] goods : goodsList) {
                for (int i = 0; i < goods[2]; i++) {
                    temp.add(new int[]{goods[0], goods[1]});
                }
            }
            int n01 = temp.size();
            int[][] goods01List = new int[n01][2];
            for (int i = 0; i < n01; i++) {
                int[] goods = temp.get(i);
                goods01List[i] = goods;
            }
            return calc01MaxValue(v, goods01List);
        }

        public int calc01MaxValue(int maxV, int[][] goodsList) {
            //总共有n件物品
            int n = goodsList.length;
            int[][] f = new int[n + 1][maxV + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= maxV; j++) {
                    f[i][j] = f[i - 1][j];
                    if (goodsList[i - 1][0] <= j) {
                        f[i][j] = Math.max(f[i][j], goodsList[i - 1][1] + f[i - 1][j - goodsList[i - 1][0]]);
                    }
                }
            }
            return f[n][maxV];
        }

    }

    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(10, solution.calcMaxValue(4, 5, new int[][]{{1, 2, 3}, {2, 4, 1}, {3, 4, 3}, {4, 5, 2}}));
        }
    }

}