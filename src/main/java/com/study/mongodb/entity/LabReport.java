package com.study.mongodb.entity;

/**
 * @author: renjiahui
 * @date: 2021-04-11 16:30
 * @description:
 */
public class LabReport {

    private Integer id;

    private Integer labId;

    private String labName;

    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", labId=" + labId +
                ", labName='" + labName + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
