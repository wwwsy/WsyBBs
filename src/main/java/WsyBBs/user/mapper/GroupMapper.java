package WsyBBs.user.mapper;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import WsyBBs.user.entity.Group;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-05
 */
public interface GroupMapper extends BaseMapper<Group> {
	@Select("select g.* from `User` u inner join GroupUserMapper gum on gum.user_id = u.user_id inner join `Group` g on gum.group_id = g.group_id where u.user_id = #{userId} limit 1")
	public Group getGroupByUser(Integer userId);
}
