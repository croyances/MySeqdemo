package com.example.demo.utils;

/**
 * @author caiwenhai
 * @version 1.0
 * @date 2020/12/8 15:32
 */
public interface MyList <E> {


    /**
     * 自定义数组生成类
     * @param e
     */

    void add(E e);

    int size(E e);

    int t(MyListImpl.student e);
}
