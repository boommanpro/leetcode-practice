package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

class SolutionTest146 {
//
// 请你设计并实现一个满足
// LRU (最近最少使用) 缓存 约束的数据结构。
//
//
//
// 实现
// LRUCache 类：
//
//
//
//
//
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
//
//
//
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
//
//
//
// 示例：
//
//
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
//
//
//
//
// 提示：
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 10000
// 0 <= value <= 10⁵
// 最多调用 2 * 10⁵ 次 get 和 put
//
//
// Related Topics设计 | 哈希表 | 链表 | 双向链表
//
// 👍 3283, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        // 1. 最近最少使用，仅与时间有关，所以可以使用双向链表存储使用顺序，使用hash表存储节点顺序

        DoubleLinkedNode head;
        DoubleLinkedNode tail;
        int capacity;
        int size;
        HashMap<Integer, DoubleLinkedNode> map;


        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
            size = 0;
            head = new DoubleLinkedNode(0, 0);
            tail = new DoubleLinkedNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DoubleLinkedNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }


        public void put(int key, int value) {
            DoubleLinkedNode node = map.get(key);
            if (node == null) {
                node = new DoubleLinkedNode(key, value);
                map.put(key, node);
                addToHead(node);
                size++;
            } else {
                node.value = value;
                moveToHead(node);
            }
            if (size > capacity) {
                removeTail();
            }
        }


        private void moveToHead(DoubleLinkedNode node) {
            DoubleLinkedNode next = node.next;
            node.next = null;
            DoubleLinkedNode prev = node.prev;
            node.prev = null;
            prev.next = next;
            next.prev = prev;
            addToHead(node);
        }

        private void addToHead(DoubleLinkedNode node) {
            DoubleLinkedNode next = head.next;
            head.next = node;
            node.next = next;
            node.prev = head;
            next.prev = node;
        }

        private void removeTail() {
            DoubleLinkedNode prev = tail.prev;
            prev.next = null;
            tail.prev = prev.prev;
            prev.prev.next = tail;
            prev.prev = null;
            map.remove(prev.key);
            size--;
        }

        public static class DoubleLinkedNode {
            DoubleLinkedNode prev;
            DoubleLinkedNode next;
            int key;
            int value;

            public DoubleLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }



    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {


        @Test
        public void testLRUCache() {
            // 创建一个容量为2的LRU缓存
            LRUCache cache = new LRUCache(2);

            // lRUCache.put(1, 1); // 缓存是 {1=1}
            cache.put(1, 1);

            // lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
            cache.put(2, 2);

            // lRUCache.get(1);    // 返回 1
            assertEquals(1, cache.get(1));

            // lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
            cache.put(3, 3);

            // lRUCache.get(2);    // 返回 -1 (未找到)
            assertEquals(-1, cache.get(2));

            // lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
            cache.put(4, 4);

            // lRUCache.get(1);    // 返回 -1 (未找到)
            assertEquals(-1, cache.get(1));

            // lRUCache.get(3);    // 返回 3
            assertEquals(3, cache.get(3));

            // lRUCache.get(4);    // 返回 4
            assertEquals(4, cache.get(4));
        }


    }
}
