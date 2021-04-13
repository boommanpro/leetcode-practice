package leetcode.editor.cn;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class SolutionTest1114 {
//我们提供了一个类： 
//
// 
//public class Foo {
//  public void first() { print("first"); }
//  public void second() { print("second"); }
//  public void third() { print("third"); }
//} 
//
// 三个不同的线程 A、B、C 将会共用一个 Foo 实例。 
//
// 
// 一个将会调用 first() 方法 
// 一个将会调用 second() 方法 
// 还有一个将会调用 third() 方法 
// 
//
// 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3]
//输出: "firstsecondthird"
//解释: 
//有三个线程会被异步启动。
//输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
//正确的输出是 "firstsecondthird"。
// 
//
// 示例 2: 
//
// 
//输入: [1,3,2]
//输出: "firstsecondthird"
//解释: 
//输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
//正确的输出是 "firstsecondthird"。 
//
// 
//
// 提示： 
//
// 
// 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。 
// 你看到的输入格式主要是为了确保测试的全面性。 
// 
// 👍 266 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Foo {

        public Foo() {

        }

        private final Object lock = new Object();

        private int v = 1;


        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            synchronized (lock) {
                printFirst.run();
                v++;
                lock.notifyAll();
            }


        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (v != 2) {
                    lock.wait();
                }
                printSecond.run();
                v++;
                lock.notifyAll();
            }


        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (v != 3) {
                    lock.wait();
                }
                printThird.run();
            }

            // printThird.run() outputs "third". Do not change or remove this line.

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Foo foo = new Foo();
            ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 3, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        foo.first(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("first");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        foo.second(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("second");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        foo.third(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("third");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadPool.shutdown();
            try {
                boolean status = threadPool.awaitTermination(20, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}