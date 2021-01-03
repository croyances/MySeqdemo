package com.example.demo;

import com.example.demo.service.SeqService;
import com.example.demo.service.SeqServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author caiwenhai
 * @version 1.0
 * @date 2020/12/23 10:59
 */
@Component
public class SeqUtil<getNextSeq> {

   public static  String SEQUENCE_CREATE_SCRIPT =
            " CREATE TABLE cmn_sequence ( seq_name varchar(180) NOT NULL COMMENT '序号名称', "
                    + " seq_value bigint(20) DEFAULT NULL COMMENT '序号值', "
                    + " PRIMARY KEY (seq_name) ) ";

    @Autowired
    private SeqServiceImpl seqService;

    private Map<String, Config> cache = new ConcurrentHashMap<>();

    public void init(String seqName,long start ,long max ,long step){
        if (cache.get(seqName)!=null){
            return;
        }
        //先判断表是否存在 没有就创建表
        seqService.init(seqName,SEQUENCE_CREATE_SCRIPT);
        if (seqService.querySeq(seqName)){
            seqService.updateSeq(seqName,step);
        }else {
           seqService.insertSeq(seqName,step);
        }


        Config config = new Config();
        config.setMax(max);
        config.setMax(start);
        config.setSqlValue(step);
        cache.put(seqName, config);

    }

    public long getNextSeq(){
        return 0;
    }

    @Data
    public class Config{

        private long sqlValue;

        private long sqlLeft;

        private long start;

        private long max;

    }





}
