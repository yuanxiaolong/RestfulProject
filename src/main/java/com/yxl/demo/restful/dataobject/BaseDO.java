package com.yxl.demo.restful.dataobject;

/**
 * 共有字段类
 * author: xiaolong.yuanxl
 * date: 2015-05-01 下午11:03
 */
public abstract class BaseDO {

    private Long id;
    private String gmtCreated;
    private String gmtModified;
    private String gmtCreator;
    private String gmtModifier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(String gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getGmtCreator() {
        return gmtCreator;
    }

    public void setGmtCreator(String gmtCreator) {
        this.gmtCreator = gmtCreator;
    }

    public String getGmtModifier() {
        return gmtModifier;
    }

    public void setGmtModifier(String gmtModifier) {
        this.gmtModifier = gmtModifier;
    }
}
