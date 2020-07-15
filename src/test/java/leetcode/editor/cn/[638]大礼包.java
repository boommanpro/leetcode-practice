package leetcode.editor.cn;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest638 {
//在LeetCode商店中， 有许多在售的物品。 
//
// 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。 
//
// 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。 
//
// 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。 
//
// 任意大礼包可无限次购买。 
//
// 示例 1: 
//
// 输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
//输出: 14
//解释: 
//有A和B两种物品，价格分别为¥2和¥5。
//大礼包1，你可以以¥5的价格购买3A和0B。
//大礼包2， 你可以以¥10的价格购买1A和2B。
//你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。 
//
// 示例 2: 
//
// 输入: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
//输出: 11
//解释: 
//A，B，C的价格分别为¥2，¥3，¥4.
//你可以用¥4购买1A和1B，也可以用¥9购买2A，2B和1C。
//你需要买1A，2B和1C，所以你付了¥4买了1A和1B（大礼包1），以及¥3购买1B， ¥4购买1C。
//你不可以购买超出待购清单的物品，尽管购买大礼包2更加便宜。
// 
//
// 说明: 
//
// 
// 最多6种物品， 100种大礼包。 
// 每种物品，你最多只需要购买6个。 
// 你不可以购买超出待购清单的物品，即使更便宜。 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 104 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            //记忆搜索化
            Map<List<Integer>, Integer> map = new HashMap<>();
            return shopping(price, special, needs, map);
        }

        public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> map) {
            //如果之前搜索过 直接返回记录值
            if (map.containsKey(needs))
                return map.get(needs);
            //res 默认值是最大值
            int j = 0, res = dot(needs, price);
            //遍历所有大礼包
            for (List<Integer> s : special) {
                //先将原来的clone
                List<Integer> afterBuy = new ArrayList<>(needs);
                //商品数量
                int n = needs.size();
                for (j = 0; j < n; j++) {
                    //计算差距数量
                    int diff = afterBuy.get(j) - s.get(j);
                    //如果大礼包数量多于商品数量 按照规则是不能买的
                    if (diff < 0)
                        break;
                    //设置买完后的数量
                    afterBuy.set(j, diff);
                }
                //如果都符合要求 即买成功
                if (j == n) {
                    //res ->  Math.min res or 大礼包 + next buy
                    res = Math.min(res, s.get(j) + shopping(price, special, afterBuy, map));
                }
            }
            map.put(needs, res);
            return res;
        }

        public int dot(List<Integer> a, List<Integer> b) {
            int sum = 0;
            for (int i = 0; i < a.size(); i++) {
                sum += a.get(i) * b.get(i);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(14, solution.shoppingOffers(Arrays.asList(2, 5), Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10)), Arrays.asList(3, 2)));
            Assert.assertEquals(11, solution.shoppingOffers(Arrays.asList(2, 3, 4), Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9)), Arrays.asList(1, 2, 1)));
        }
    }
}