package template;

import java.util.List;

public class WareHouseLocationSelection {


    /**
     *
     * @param size 仓库大小
     * @param pos 仓库信息
     * @return result[0] 首次最佳坐标 result[1] 最小花费
     */
    public static long[] getGreatPositionAndCost(int size, List<Integer> pos) {
        long[] result = new long[2];
        result[1] = Long.MAX_VALUE;
        int n = pos.size();
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + pos.get(i);
        }
        for (int right = size; right <= n; right++) {
            // s1+s2 是 j 在 [left, right) 中的所有 pos[j] 到 index=pos[(left+right)/2] 的距离之和
            int left = right - size;
            int i = left + size / 2;
            long index = pos.get(i);
            long s1 = index * (i - left) - (sum[i] - sum[left]);
            long s2 = sum[right] - sum[i] - index * (right - i);
            if (s1 + s2 < result[1]) {
                result[0] = index;
                result[1] = Math.min(result[1], s1 + s2);
            }
        }
        return result;
    }
}
