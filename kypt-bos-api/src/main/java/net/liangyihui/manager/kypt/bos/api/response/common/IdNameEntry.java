package net.liangyihui.manager.kypt.bos.api.response.common;

import net.liangyihui.digitalmarketing.request.BaseEntity;


/**
 * @author liu_y
 */
public class IdNameEntry extends BaseEntity {

    private long id;

    private String name;

    private String code;

    public IdNameEntry() {
    }

    public IdNameEntry(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public IdNameEntry(long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
