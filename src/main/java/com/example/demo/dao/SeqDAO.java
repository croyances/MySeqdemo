package com.example.demo.dao;

import org.apache.ibatis.annotations.*;

/**
 * @author caiwenhai
 * @version 1.0
 * @date 2020/12/22 16:41
 */
@Mapper
public interface SeqDAO {


    @Update("${createTable}")
    void createTable(@Param("createTable") String script);

    @Select("select count(1) from cmn_sequence where seq_name = #{seqName}")
    int querySeq(String seqName);


    @Insert("insert into cmn_sequence value (#{seqName},#{value})")
    int insertSeq(String seqName ,long value);

    @Select("select count(1) from ${tableName}")
    int queryTable(@Param("tableName") String tableName);

    @Update("select count(1) from ${tableName}")
    int updateSeq(String seqName ,long value);
}
