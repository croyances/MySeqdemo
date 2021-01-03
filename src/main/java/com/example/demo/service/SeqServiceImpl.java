package com.example.demo.service;

import com.example.demo.SeqUtil;
import com.example.demo.dao.SeqDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author caiwenhai
 * @version 1.0
 * @date 2020/12/22 16:38
 */

@Service
public class SeqServiceImpl  {

    @Resource
    private SeqDAO seqDAO;

   // @Override
    public void createTable(String script) {
        seqDAO.createTable(script);
    }

  //  @Override
    public Boolean queryTable(String tableName) {
        try {
            seqDAO.queryTable(tableName);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void init(String tableName,String script){
        if (!queryTable("cmn_sequence")) {
            createTable(script);
        }
    }


    public Boolean querySeq(String seqName) {
        if (seqDAO.querySeq(seqName)>0){
            return true;
        }
        return false;
    }

    public void insertSeq(String seqName ,long value) {
        seqDAO.insertSeq(seqName, value);
    }

    public void updateSeq(String seqName ,long value){
        seqDAO.updateSeq(seqName, value);
    }

}
