package WsyBBs.user.service;

import com.baomidou.mybatisplus.service.IService;

import WsyBBs.user.entity.Group;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-05
 */
public interface IGroupService extends IService<Group> {
	public Group getGroupByUser(Integer integer);
}
