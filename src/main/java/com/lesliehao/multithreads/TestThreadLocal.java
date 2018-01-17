package com.lesliehao.multithreads;

/**
 * DESC: 线程局部变量
 * Created by Hh on 2018/1/17
 */
public class TestThreadLocal {

    // 各线程value 相互独立
    private static final ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new MyRunnable(i)).start();
        }
    }

    static class MyRunnable implements Runnable {

        private int index;

        public MyRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("线程" + index + "的初始value" + value.get());
            for (int i = 0; i < 10; i++) {
                value.set(value.get() + i);
            }
            System.out.println("线程" + index + "的累加value" + value.get());
        }
    }

}
