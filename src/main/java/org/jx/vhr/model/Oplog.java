package org.jx.vhr.model;

import java.io.Serializable;

/**
 * (Oplog)实体类
 *
 * @author makejava
 * @since 2021-07-08 13:01:00
 */
public class Oplog implements Serializable {
    private static final long serialVersionUID = 728071184984541996L;

    private Integer id;
    /**
     * 添加日期
     */
    private Object adddate;
    /**
     * 操作内容
     */
    private String operate;
    /**
     * 操作员ID
     */
    private Integer hrid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getAdddate() {
        return adddate;
    }

    public void setAdddate(Object adddate) {
        this.adddate = adddate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Integer getHrid() {
        return hrid;
    }

    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }

}
