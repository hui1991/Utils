package com.example.zhuguangjun.utils;

/**
 *  Created by zhuguangjun on 2017/8/20.
 *  单例模式
 */

public class Singleton {
    //私有化构造器
    private Singleton(){}

    private static volatile Singleton singleton;

    //懒汉式，双检锁（Double Check Lock）
    public Singleton getInstance(){
        //避免不必要的同步
        if (singleton==null){
            //同步锁
            synchronized (Singleton.class){
                //如果第一层判断时有多个线程进入，保证线程安全，只有一个实例
                if (singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
