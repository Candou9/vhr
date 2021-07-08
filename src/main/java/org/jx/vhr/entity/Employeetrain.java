package org.jx.vhr.entity;

import java.io.Serializable;

/**
 * (Employeetrain)实体类
 *
 * @author makejava
 * @since 2021-07-08 13:00:54
 */
public class Employeetrain implements Serializable {
    private static final long serialVersionUID = -64791531870259433L;

    private Integer id;
    /**
     * 员工编号
     */
    private Integer eid;
    /**
     * 培训日期
     */
    private Object traindate;
    /**
     * 培训内容
     */
    private String traincontent;
    /**
     * 备注
     */
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Object getTraindate() {
        return traindate;
    }

    public void setTraindate(Object traindate) {
        this.traindate = traindate;
    }

    public String getTraincontent() {
        return traincontent;
    }

    public void setTraincontent(String traincontent) {
        this.traincontent = traincontent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
