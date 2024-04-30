package net.liangyihui.manager.kypt.bos.api.request.team;

import net.liangyihui.manager.kypt.bos.api.request.BaseListRequest;

/**
 * @Author ruofa
 * @Date 2021/3/5 9:54
 */
public class QueryTeamRequest extends BaseListRequest {
    private String name;
    private int enterpriseId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
