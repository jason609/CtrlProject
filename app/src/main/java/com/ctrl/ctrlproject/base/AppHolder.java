package com.ctrl.ctrlproject.base;

/**
 * 全局控制类
 * 用于存储所有 全局控制变量
 * Created by jaosn on 2016-12-2.
 */
public class AppHolder {

    /** 私有化的构造方法，保证外部的类不能通过构造器来实例化*/
    private AppHolder() {
    }

    /**内部类，用于实现lzay机制*/
    private static class SingletonHolder {
        /**单例变量*/
        private static AppHolder instance = new AppHolder();
    }

    /**
     * 获取单例对象实例
     */
    public static AppHolder getInstance() {
        return SingletonHolder.instance;
    }



    /**下面是 app全局变量控制类**/

}
