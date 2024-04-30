package net.liangyihui.manager.kypt.bos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.liangyihui.manager.kypt.bos.api.response.common.IdNameEntry;
import net.liangyihui.manager.kypt.bos.entity.AdminEnterpriseWechat;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 企业微信表 Mapper 接口
 * </p>
 *
 * @author liuyuepeng
 * @since 2021-02-02
 */
@Repository
public interface AdminEnterpriseWechatMapper extends BaseMapper<AdminEnterpriseWechat> {

    List<IdNameEntry> eChatList(@Param(value = "enterpriseId") int enterpriseId,
                              @Param(value = "name") String name,@Param(value = "pUserInfoId") Integer pUserInfoId);

}
