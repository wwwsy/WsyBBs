package WsyBBs.user.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import WsyBBs.user.entity.Group;
import WsyBBs.user.mapper.GroupMapper;
import WsyBBs.user.service.IGroupService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-05
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements IGroupService {
	@Override
	public Group getGroupByUser(Integer userId) {
		return baseMapper.getGroupByUser(userId);
	}
}
