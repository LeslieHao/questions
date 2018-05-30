package com.lesliehao.multithreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author HaoHao
 * @Description: 读写锁
 * @date 2018/5/30下午3:03
 */
public class TestWriteReadLock {


    ReadWriteLock lock = new ReentrantReadWriteLock();

    Lock readLock = lock.readLock();

    Lock writeLock = lock.writeLock();

    int num = 0;

    // 使用synchronized 读操作也需要获取锁
    synchronized void synchronizedRead(){

    }


    void read() {
        readLock.lock();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "：读操作" + num);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readLock.unlock();
    }

    void write() {
        writeLock.lock();
        for (int i = 0; i < 10; i++) {
            num = (int) (Math.random() * 10);
            System.out.println(Thread.currentThread().getName() + "：写操作" + num);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writeLock.unlock();
    }

    public static void main(String[] args) {
        TestWriteReadLock test = new TestWriteReadLock();

        for (int i = 0; i < 2; i++)
            new Thread(test::read).start();
        for (int i = 0; i < 2; i++)
            new Thread(test::write).start();

    }

}
