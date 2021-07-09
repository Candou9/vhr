package org.jx.vhr.model;

import java.io.Serializable;

/**
 * (Nation)实体类
 *
 * @author makejava
 * @since 2021-07-08 13:00:59
 */
public class Nation implements Serializable {
    private static final long serialVersionUID = -16420239504961947L;

    private Integer id;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
