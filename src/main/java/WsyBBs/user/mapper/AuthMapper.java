package WsyBBs.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import WsyBBs.user.entity.Auth;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-05
 */
public interface AuthMapper extends BaseMapper<Auth> {
	@Select("select a.* from `Group` g inner join GroupAuthMapper gam on g.group_id = gam.group_id inner join Auth a on a.auth_id = gam.auth_id where g.group_id = #{groupId}")
	public List<Auth> getAuthsByGroup(Integer groupId);
}
