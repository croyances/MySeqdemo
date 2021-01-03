package com.example.demo.domain;

import java.util.Date;

/**
 * @author caiwenhai
 * @version 1.0
 * @date 2020/12/22 16:39
 */
public class Seq {

    private String SeqName;

    private String SeqValue;

    private Date date;

    public String getSeqName() {
        return SeqName;
    }

    public void setSeqName(String seqName) {
        SeqName = seqName;
    }

    public String getSeqValue() {
        return SeqValue;
    }

    public void setSeqValue(String seqValue) {
        SeqValue = seqValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
