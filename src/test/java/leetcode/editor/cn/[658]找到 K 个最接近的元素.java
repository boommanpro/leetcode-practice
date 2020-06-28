package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest658 {
//给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一
//样，优先选择数值较小的那个数。 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5], k=4, x=3
//输出: [1,2,3,4]
// 
//
// 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4,5], k=4, x=-1
//输出: [1,2,3,4]
// 
//
// 
//
// 说明: 
//
// 
// k 的值为正数，且总是小于给定排序数组的长度。 
// 数组不为空，且长度不超过 104 
// 数组里的每个元素与 x 的绝对值不超过 104 
// 
//
// 
//
// 更新(2017/9/19): 
//这个参数 arr 已经被改变为一个整数数组（而不是整数列表）。 请重新加载代码定义以获取最新更改。 
// Related Topics 二分查找

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
            int n = ret.size();
            //如果小于开始数据
            if (x <= ret.get(0)) {
                return ret.subList(0, k);
                //如果大于末尾数据
            }
            if (ret.get(n - 1) <= x) {
                return ret.subList(n - k, n);
            }
            //二分查找index
            //如果搜索键包含在列表中，则返回搜索键的索引
            // 否则返回 (-(插入点) - 1)。插入点 被定义为将键插入列表的那一点：即第一个大于此键的元素索引
            int index = Collections.binarySearch(ret, x);
            //index是第一个大于此键值的位置
            if (index < 0)
                index = -index - 1;
            //  low 最大可以到哪里 即左边最大可以到哪里
            int low = Math.max(0, index - k - 1);
            //  high 最多可以填充几个k 右边最大到哪里
            int high = Math.min(ret.size() - 1, index + k - 1);

            //如果 high -low > k-1 说明元素太多了
            while (high - low > k - 1) {
                //如果low的绝对值小于high的绝对值
                if ((x - ret.get(low)) <= (ret.get(high) - x))
                    high--;
                else if ((x - ret.get(low)) > (ret.get(high) - x))
                    low++;
                else
                    System.out.println("unhandled case: " + low + " " + high);
            }
            //抽取数据

            return ret.subList(low, high + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[1, 3, 6, 7]", solution.findClosestElements(new int[]{1, 3, 6, 7, 9}, 4, 4).toString());
            Assert.assertEquals("[1, 3, 6, 7]", solution.findClosestElements(new int[]{1, 3, 6, 7, 9}, 4, 5).toString());
            Assert.assertEquals("[1, 2, 3, 4]", solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3).toString());
            Assert.assertEquals("[1, 2, 3, 4]", solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1).toString());
            Assert.assertEquals("[1, 2, 3, 4]", solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 1).toString());
            Assert.assertEquals("[2, 3, 4, 5]", solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 5).toString());
            Assert.assertEquals("[2, 3, 4, 5]", solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 6).toString());

        }
    }
}