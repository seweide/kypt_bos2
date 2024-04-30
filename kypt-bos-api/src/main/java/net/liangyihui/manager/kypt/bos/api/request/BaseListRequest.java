package net.liangyihui.manager.kypt.bos.api.request;

import net.liangyihui.digitalmarketing.request.BaseEntity;

import javax.validation.constraints.Max;

/**
 * @author liu_y
 */
public class BaseListRequest extends BaseEntity {

    /**
     * 模糊查询
     */
    private int pageNum = 1;
    @Max(500)
    private int size = 50;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
