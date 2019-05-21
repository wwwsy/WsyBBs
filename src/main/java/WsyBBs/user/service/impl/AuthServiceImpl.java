package WsyBBs.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import WsyBBs.user.entity.Auth;
import WsyBBs.user.mapper.AuthMapper;
import WsyBBs.user.service.IAuthService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-05
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, Auth> implements IAuthService {

	@Override
	public List<Auth> getAuthsByGroup(Integer groupId) {
		return baseMapper.getAuthsByGroup(groupId);
	}

}
