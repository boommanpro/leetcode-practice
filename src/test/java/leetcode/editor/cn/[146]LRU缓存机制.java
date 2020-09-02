package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest146 {
//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 850 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {


        public static class DoubleLinkNode {
            int key;
            int value;
            DoubleLinkNode prev;
            DoubleLinkNode next;

            public DoubleLinkNode() {
            }

            public DoubleLinkNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity;
        private int size;
        private final DoubleLinkNode head;
        private final DoubleLinkNode tail;
        private final Map<Integer, DoubleLinkNode> cache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.head = new DoubleLinkNode();
            this.tail = new DoubleLinkNode();
            this.cache = new HashMap<>();
            head.next = tail;
            tail.prev = head;

        }

        public int get(int key) {
            DoubleLinkNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            move2Head(node);
            return node.value;
        }


        public void put(int key, int value) {
            DoubleLinkNode node = cache.get(key);
            if (node == null) {
                DoubleLinkNode newNode = new DoubleLinkNode(key, value);
                add2Head(newNode);
                cache.put(key, newNode);
                size++;
                if (size > capacity) {
                    DoubleLinkNode tail = removeTail();
                    cache.remove(tail.key);
                    size--;
                }
            } else {
                node.value = value;
                move2Head(node);
            }
        }


        private void move2Head(DoubleLinkNode node) {
            removeNode(node);
            add2Head(node);
        }


        private void add2Head(DoubleLinkNode node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        private DoubleLinkNode removeTail() {
            DoubleLinkNode res = tail.prev;
            removeNode(res);
            return res;
        }

        private void removeNode(DoubleLinkNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
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
        public void defaultSolutionTest() {
            LRUCache cache = new LRUCache(2);
            cache.put(1, 1);
            cache.put(2, 2);
            Assert.assertEquals(1, cache.get(1));
            cache.put(3, 3);
            Assert.assertEquals(-1, cache.get(2));
            cache.put(4, 4);
            Assert.assertEquals(-1, cache.get(1));
            Assert.assertEquals(3, cache.get(3));
            Assert.assertEquals(4, cache.get(4));

        }
    }
}