package com.lesliehao.javabase;

import org.junit.Test;

/**
 * DESC: try catch finall 问题
 * Created by Hh on 2018/1/17
 */
public class TryCatchFinally {


    @Test
    public void test() {
        System.out.println(tryCatchFinally2());
    }

    /**
     * 如果进入catch 语句，catch语句包含return 直接返回，然后执行finally
     * 不论怎样 finally 都会执行
     * JVM 是栈模型
     * 转成字节码后
     * 在执行catch 时 会将num 值放到一个returnValue 中，并放到栈顶
     * 然后执行finally中的语句
     * 然后返回
     * @return
     */
    private int tryCatchFinally() {
        int num = 0;
        int arr[] = new int[]{1};
        try {
            System.out.println("try........");
            num++;
            arr[1] = 0;
        } catch (Exception e) {
            num++;
            System.out.println("catch.......");
            return num;
        }finally {
            num++;
            System.out.println("finally.......");
        }
        num++;
        return num;
    }

    private int tryCatchFinally2() {
        int num = 0;
        int arr[] = new int[]{1};
        try {
            System.out.println("try........");
            num++;
            arr[1] = 0;
        } catch (Exception e) {
            num++;
            System.out.println("catch.......");
            try {
                System.out.println("try2........");
                num++;
                arr[1] = 0;
            } catch (Exception e2) {
                num++;
                System.out.println("catch2.......");
                return num;
            }finally {
                num++;
                System.out.println("finally2.......");
            }
            return num;
        }finally {
            num++;
            System.out.println("finally.......");
        }
        num++;
        return num;
    }
}
