package leetcode.editor.cn;

import org.junit.Test;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class SolutionTest1115 {
//我们提供一个类： 
//
// 
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
// 
//
// 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。 
//
// 请设计修改程序，以确保 "foobar" 被输出 n 次。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 1
//输出: "foobar"
//解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
// 
//
// 示例 2: 
//
// 
//输入: n = 2
//输出: "foobarfoobar"
//解释: "foobar" 将被输出两次。
// 
// 👍 106 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class FooBar {
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        private final Object lock = new Object();
        boolean status = false;

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (status) {
                        lock.wait();
                    }
                    status = true;
                    printFoo.run();
                    lock.notifyAll();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (!status) {
                        lock.wait();
                    }
                    status = false;
                    printBar.run();
                    lock.notifyAll();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                ;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() throws InterruptedException {
            FooBar solution = new FooBar(10);
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        solution.bar(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("bar");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        solution.foo(new Runnable() {
                            @Override
                            public void run() {
                                System.out.print("foo");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            threadPoolExecutor.shutdown();
            threadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS);
        }

    }
}