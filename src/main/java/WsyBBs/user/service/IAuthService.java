package WsyBBs.user.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import WsyBBs.user.entity.Auth;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-05
 */
public interface IAuthService extends IService<Auth> {
	public List<Auth> getAuthsByGroup(Integer groupId);
}
