package com.spig.server;
import java.io.*;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) throws InterruptedException {

        for (int a = 0;a<1000;a++){


            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                            TimeUnit.SECONDS.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(String.valueOf(Thread.currentThread().getName())+" : "+String.valueOf(Thread.currentThread().getId()));

                }
            });
            t1.start();

        }
    }
}
