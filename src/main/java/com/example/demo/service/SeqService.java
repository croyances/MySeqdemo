package com.example.demo.service;

/**
 * @author caiwenhai
 * @version 1.0
 * @date 2020/12/22 16:38
 */
public interface SeqService {


    void createTable(String script);

    Boolean queryTable(String tableName);
}
