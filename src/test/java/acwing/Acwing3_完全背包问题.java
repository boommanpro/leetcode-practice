package acwing;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

/**
 * link: https://www.acwing.com/problem/content/3/
 */
class Acwing3_Main {

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

        /**
         * 一个物品能够装多次
         */
        public int calcMaxValue(int n, int v, int[][] goodsList) {
            //n个物品 v的体积
            int[] f = new int[v + 1];
            //体积从1到 v
            for (int i = 1; i <= v; i++) {
                //物品遍历所有
                for (int j = 0; j < n; j++) {
                    //物品信息
                    int[] goods = goodsList[j];
                    if (goods[0] <= i) {
                        f[i] = Math.max(f[i], goods[1] + f[i - goods[0]]);
                    }
                }
            }
            return f[v];
        }

    }

    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(10, solution.calcMaxValue(4, 5, new int[][]{{1, 2}, {2, 4}, {3, 4}, {4, 5}}));
        }
    }

}