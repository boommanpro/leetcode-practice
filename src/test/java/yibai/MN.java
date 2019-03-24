package yibai;

import org.junit.Test;

public class MN {

    /**
     * M*N 可以走多少步 动态规划
     */

    @Test
    public void  MNTest(){
        int route = getRoute(5, 5);
        System.out.println(route);
    }

    public int getRoute(int col,int row){

        int[][] dp = new int[col+1][row+1];


        for (int i = 0; i <= col; i++) {
            for(int j=0; j<=row; j++)
            {
                dp[i][j]=1;
            }
        }

        for (int i = 1; i <= col; i++) {
            for(int j=1; j<=row; j++)
            {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[col][row];
    }

    public static int getTraversal(int p, int q) {
        int num = 0;
        if (p == 1 && q == 1) {
            return 1;
        }
        if (p > 1) {
            num += getTraversal(p - 1, q);
        }
        if (q > 1) {
            num += getTraversal(p, q - 1);
        }
        return num;
    }

    public static void main(String[] args) {
        int num = getTraversal(6, 6);
        System.out.println(num);
    }
}
