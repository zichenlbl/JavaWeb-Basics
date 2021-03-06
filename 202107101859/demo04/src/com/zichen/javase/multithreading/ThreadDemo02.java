package com.zichen.javase.multithreading;

/**
 * 实现线程的第二种方式
 * @author zc
 * @date 2021-07-28 18:08
 */
public class ThreadDemo02 {

    public static void main(String[] args) {
        // 实现线程的第二种方式
        MyRunnable myRunnable = new MyRunnable();
        Thread thread/* = new Thread(myRunnable)*/;
        // 使用匿名内部类的方式
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("分支线程--->" + i);
                }
            }
        });
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程--->" + i);
        }
    }

}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("分支线程--->" + i);
        }
    }
}
