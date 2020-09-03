package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class SolutionTest460 {
//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。 
//
// 
// get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。 
// put(key, value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效
//。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除最久未使用的键。 
// 
//
// 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。 
//
// 
//
// 进阶： 
//你是否可以在 O(1) 时间复杂度内执行两项操作？ 
//
// 
//
// 示例： 
//
// LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回 1
//cache.put(3, 3);    // 去除 key 2
//cache.get(2);       // 返回 -1 (未找到key 2)
//cache.get(3);       // 返回 3
//cache.put(4, 4);    // 去除 key 1
//cache.get(1);       // 返回 -1 (未找到 key 1)
//cache.get(3);       // 返回 3
//cache.get(4);       // 返回 4 
// Related Topics 设计 
// 👍 263 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {
        Map<Integer, Node> cache;  // 存储缓存的内容
        Map<Integer, LinkedHashSet<Node>> freqMap; // 存储每个频次对应的双向链表
        int size;
        int capacity;
        int min; // 存储当前最小频次

        public LFUCache(int capacity) {
            cache = new HashMap<>(capacity);
            freqMap = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            freqInc(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            Node node = cache.get(key);
            if (node != null) {
                node.value = value;
                freqInc(node);
            } else {
                if (size == capacity) {
                    Node deadNode = removeNode();
                    cache.remove(deadNode.key);
                    size--;
                }
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                addNode(newNode);
                size++;
            }
        }

        void freqInc(Node node) {
            // 从原freq对应的链表里移除, 并更新min
            int freq = node.freq;
            LinkedHashSet<Node> set = freqMap.get(freq);
            set.remove(node);
            if (freq == min && set.size() == 0) {
                min = freq + 1;
            }
            // 加入新freq对应的链表
            node.freq++;
            LinkedHashSet<Node> newSet = freqMap.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>());
            newSet.add(node);
        }

        void addNode(Node node) {
            LinkedHashSet<Node> set = freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>());
            set.add(node);
            min = 1;
        }

        Node removeNode() {
            LinkedHashSet<Node> set = freqMap.get(min);
            Node deadNode = set.iterator().next();
            set.remove(deadNode);
            return deadNode;
        }

        public static class Node {
            int key;
            int value;
            int freq = 1;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }


    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            LFUCache cache = new LFUCache(2);
            cache.put(1, 1);
            cache.put(2, 2);
            Assert.assertEquals(1, cache.get(1));
            cache.put(3, 3);
            Assert.assertEquals(-1, cache.get(2));
            Assert.assertEquals(3, cache.get(3));
            cache.put(4, 4);
            Assert.assertEquals(-1, cache.get(1));
            Assert.assertEquals(3, cache.get(3));
            Assert.assertEquals(4, cache.get(4));


            LFUCache cache0 = new LFUCache(3);
            cache0.put(2, 2);
            cache0.put(1, 1);
            Assert.assertEquals(2, cache0.get(2));
            Assert.assertEquals(1, cache0.get(1));
            Assert.assertEquals(2, cache0.get(2));
            //此时 2-3  1-2  3-1
            cache0.put(3, 3);
            // 2-3 1-2 4-1
            cache0.put(4, 4);
            Assert.assertEquals(-1, cache0.get(3));
            //2-4 1-2  4-1
            Assert.assertEquals(2, cache0.get(2));
            //2-4 1-3 4-1
            Assert.assertEquals(1, cache0.get(1));
            Assert.assertEquals(4, cache0.get(4));

            LFUCache cache1 = new LFUCache(0);
            cache1.put(0, 0);
            Assert.assertEquals(-1, cache1.get(0));

        }
    }
}