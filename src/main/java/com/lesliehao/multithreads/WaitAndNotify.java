package com.lesliehao.multithreads;

/**
 * 两个线程交替输出0-100
 * @author HaoHao
 * @date 2019-05-27 21:13
 */
public class WaitAndNotify implements Runnable {

    private static int num = 0;

    private String name;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                this.notify();
                if (num <= 100) {
                    System.out.println(num++);
                } else {
                    break;
                }
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        WaitAndNotify waitAndNotify = new WaitAndNotify();
        Thread t1 = new Thread(waitAndNotify);
        Thread t2 = new Thread(waitAndNotify);
        t1.start();
        t2.start();
    }
}
