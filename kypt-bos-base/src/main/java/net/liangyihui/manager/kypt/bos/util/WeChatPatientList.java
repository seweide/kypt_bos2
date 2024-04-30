package net.liangyihui.manager.kypt.bos.util;


/**
 * 获取微信用户列表
 */
public class WeChatPatientList {
    private Integer total;//关注该公众账号的总用户数

    private Integer count;//拉取的OPENID个数，最大值为10000

    private WeChatOpenidInfo data;//列表数据，OPENID的列表

    private String next_openid;//拉取列表的最后一个用户的OPENID

    private int errcode;//错误编码

    private String errmsg="ok";//错误提示

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public WeChatOpenidInfo getData() {
        return data;
    }

    public void setData(WeChatOpenidInfo data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
